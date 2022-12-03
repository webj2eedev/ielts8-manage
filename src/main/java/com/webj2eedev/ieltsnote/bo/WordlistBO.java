package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.WordlistDao;
import com.webj2eedev.ieltsnote.entity.WordCntNewlyAddedDO;
import com.webj2eedev.ieltsnote.entity.WordDO;
import com.webj2eedev.ieltsnote.entity.WordlistRefDO;
import com.webj2eedev.ieltsnote.utils.WordUtil;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class WordlistBO {
    @Resource
    private WordlistDao dao;

    @Autowired
    private MINIOClient minio;

    private final String WORDLIST_BUCKET_NAME = "wordlist-bucket";

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
                    minio.putObject(WORDLIST_BUCKET_NAME, ossid, new ByteArrayInputStream(audio), Long.valueOf(Integer.toString(audio.length)), "audio/mpeg");
                    pdo.setSpeechBritishOssid(ossid);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.out.println("Failed to download british speech: " + word + ".");
                }

                // 获取发音-美式
                try {
                    String ossid = word + "_" + "american.mp3";
                    byte[] audio = WordUtil.downloadWordAudio(word, "2");
                    minio.putObject(WORDLIST_BUCKET_NAME, ossid, new ByteArrayInputStream(audio), Long.valueOf(Integer.toString(audio.length)), "audio/mpeg");
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

    public Long deleteWord(String word) {
        Long ret = dao.deleteWord(word);
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

    public List<WordCntNewlyAddedDO> queryNewlyAddedWordCntSummary() {
        List<WordCntNewlyAddedDO> rDos = dao.queryNewlyAddedWordCntSummary();
        return rDos;
    }

    public int createRef(String label, int creator) {
        WordlistRefDO pdo = WordlistRefDO.builder().label(label).creator(creator).build();
        dao.createRef(pdo);
        return pdo.getUid();
    }
}