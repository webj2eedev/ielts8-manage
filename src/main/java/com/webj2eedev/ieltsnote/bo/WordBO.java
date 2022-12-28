package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.WordDao;
import com.webj2eedev.ieltsnote.entity.word.WordNewlyAddedDO;
import com.webj2eedev.ieltsnote.entity.word.WordDO;
import com.webj2eedev.ieltsnote.entity.word.WordGroupDO;
import com.webj2eedev.ieltsnote.entity.word.WordGroupDtlDO;
import com.webj2eedev.ieltsnote.utils.WordUtil;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class WordBO {
    @Resource
    private WordDao dao;

    @Autowired
    private MINIOClient minio;

    private final String WORD_BUCKET_NAME = "word";

    public int addWord(String word, int creator) {
        WordDO pdo = WordDO.builder().word(word).creator(creator).build();

        WordDO exist = this.queryWord(word);
        if (exist != null) {
            this.updateWord(WordDO.builder().uid(exist.getUid()).addCount(exist.getAddCount() + 1).build());
            return -1;
        } else {
            // 有空格的一般不是单词
            if (word.indexOf(" ") == -1) {
                // 获取音标
                try {
                    String[] phoneticSymbol = WordUtil.downloadWordPhoneticSymbol(word);
                    pdo.setPhoneticBritish(phoneticSymbol[0]);
                    pdo.setPhoneticBritish(phoneticSymbol[1]);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.out.println("Failed to download phonetic symbol: " + word + ".");
                }

                // 获取发音-英式
                try {
                    String ossid = word + "_" + "british.mp3";
                    byte[] audio = WordUtil.downloadWordAudio(word, "1");
                    minio.putObject(WORD_BUCKET_NAME, ossid, new ByteArrayInputStream(audio), Long.valueOf(Integer.toString(audio.length)), "audio/mpeg");
                    pdo.setSpeechBritishOssid(ossid);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.out.println("Failed to download british speech: " + word + ".");
                }

                // 获取发音-美式
                try {
                    String ossid = word + "_" + "american.mp3";
                    byte[] audio = WordUtil.downloadWordAudio(word, "2");
                    minio.putObject(WORD_BUCKET_NAME, ossid, new ByteArrayInputStream(audio), Long.valueOf(Integer.toString(audio.length)), "audio/mpeg");
                    pdo.setSpeechAmericanOssid(ossid);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.out.println("Failed to download american speech: " + word + ".");
                }

            }

            dao.addWord(pdo);

            return pdo.getUid();
        }
    }

    public Long deleteWord(Integer uid) {
        Long ret = dao.deleteWord(uid);
        return ret;
    }

    public Long updateWord(WordDO pdo) {
        Long ret = dao.updateWord(pdo);
        return ret;
    }

    public WordDO queryWord(String word) {
        return dao.queryWord(word);
    }

    public List<WordDO> queryWords(String condition) {
        return dao.queryWords(condition);
    }

    public boolean existWord(String word) {
        return dao.existWord(word);
    }

    public List<WordNewlyAddedDO> queryWordNewlyAdded() {
        List<WordNewlyAddedDO> rDos = dao.queryWordNewlyAdded();
        return rDos;
    }

    public int addWordGroup(int creator) {
        WordGroupDO pdo = WordGroupDO.builder().creator(creator).build();
        dao.addWordGroup(pdo);
        return pdo.getUid();
    }

    public int addWordInGroup(int groupId, String word, int creator) {
        int wordId;
        WordDO exist = this.queryWord(word);
        if (exist != null) {
            wordId = exist.getUid();
        } else {
            wordId = this.addWord(word, creator);
        }
        WordGroupDtlDO pdo = WordGroupDtlDO.builder().groupId(groupId).wordId(wordId).creator(creator).build();
        dao.addWordInGroup(pdo);
        return pdo.getUid();
    }

    public Long deleteWordInGroup(int groupId, int wordId, boolean cascade) {
        if(cascade){
            dao.deleteWordInGroup(groupId, wordId);
            return dao.deleteWord(wordId);
        }else{
            return dao.deleteWordInGroup(groupId, wordId);
        }
    }

    public List<WordDO> queryWordsInGroup(int refId, String condition) {
        return dao.queryWordsInGroup(refId, condition);
    }

}