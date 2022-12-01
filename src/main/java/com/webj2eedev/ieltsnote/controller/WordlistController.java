package com.webj2eedev.ieltsnote.controller;

import com.webj2eedev.ieltsnote.bo.WordlistBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.entity.WordlistWordDO;
import com.webj2eedev.ieltsnote.utils.WordUtil;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/wordlist")
public class WordlistController {
    @Autowired
    WordlistBO bo;
    @Autowired
    MINIOClient minio;

    private final String WORDLIST_BUCKET_NAME = "wordlist-bucket";

    @ResponseBody
    @RequestMapping(value = "/addWord", method = {RequestMethod.POST})
    public WrapperResponse<String> addWord(@RequestBody WordlistWordDO pdo) {
        String word = pdo.getWord();

        // 有空格的一般不是单词
        if(word.indexOf(" ")  == -1) {
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
            try{
                String ossid = word+"_"+"british.mp3";
                byte[] audio = WordUtil.downloadWordAudio(word, "1");
                minio.putObject(WORDLIST_BUCKET_NAME, ossid, new ByteArrayInputStream(audio), Long.valueOf(Integer.toString(audio.length)), "audio/mpeg");
                pdo.setSpeechBritishOssid(ossid);
            }catch(IOException ex){
                ex.printStackTrace();
                System.out.println("Failed to download british speech: "+word+".");
            }

            // 获取发音-美式
            try{
                String ossid = word+"_"+"american.mp3";
                byte[] audio = WordUtil.downloadWordAudio(word, "2");
                minio.putObject(WORDLIST_BUCKET_NAME, ossid, new ByteArrayInputStream(audio), Long.valueOf(Integer.toString(audio.length)), "audio/mpeg");
                pdo.setSpeechAmericanOssid(ossid);
            }catch(IOException ex){
                ex.printStackTrace();
                System.out.println("Failed to download american speech: "+word+".");
            }
        }

        bo.addWord(pdo);

        return WrapperResponse.ok("ok");
    }
}
