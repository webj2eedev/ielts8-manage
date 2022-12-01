package com.webj2eedev.ieltsnote.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.webj2eedev.ieltsnote.bo.WordMngBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.WordDTO;
import com.webj2eedev.ieltsnote.entity.WordCntNewlyAddedDO;
import com.webj2eedev.ieltsnote.entity.WordDO;
import com.webj2eedev.ieltsnote.utils.WordUtil;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import com.webj2eedev.ieltsnote.utils.uuid.UUID;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/word/mng")
@Api(value = "单词管理", tags = "单词管理")
public class WordMngController {
    @Autowired
    WordMngBO wordMngBO;
    @Autowired
    MINIOClient minioClient;
    @ResponseBody
    @RequestMapping(value = "/queryWords", method = {RequestMethod.POST})
    public WrapperResponse<PageInfo> queryWords(@RequestBody WordDTO dto) {
        Page<WordDTO> objects = PageHelper.startPage(dto.getPagenum(), dto.getPagesize());

        wordMngBO.queryWords(dto);

        PageInfo<WordDTO> pageInfo = new PageInfo<>(objects);

        return WrapperResponse.ok(pageInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/queryWord", method = {RequestMethod.POST})
    public WrapperResponse<WordDO> queryWord(@RequestBody WordDTO dto) {
        WordDO word = wordMngBO.queryWord(dto);
        return WrapperResponse.ok(word);
    }

    @ResponseBody
    @RequestMapping(value = "/existWord", method = {RequestMethod.POST})
    public WrapperResponse<Boolean> existWord(@RequestBody WordDTO dto) {
        boolean ret = wordMngBO.existWord(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addWord", method = {RequestMethod.POST})
    public WrapperResponse<String> addWord(@RequestBody WordDTO dto) {
        String word = dto.getWord();

        // download audio
        if(word.indexOf(" ")  == -1){ // 有空格的一般不是单词..
            try{
                String ossid = word+"_"+"brithsh.mp3";
                byte[] audio = WordUtil.downloadWordAudio(word, "1");
                minioClient.putWordAudio(ossid, new ByteArrayInputStream(audio), Long.valueOf(Integer.toString(audio.length)), "audio/mpeg");
                dto.setAudioBritishOssid(ossid);
            }catch(IOException ex){
                ex.printStackTrace();
                System.out.println("Failed to download audio: "+word+", british.");
            }
            try{
                String ossid = word+"_"+"american.mp3";
                byte[] audio = WordUtil.downloadWordAudio(word, "2");
                minioClient.putWordAudio(ossid, new ByteArrayInputStream(audio), Long.valueOf(Integer.toString(audio.length)), "audio/mpeg");
                dto.setAudioAmericanOssid(ossid);
            }catch(IOException ex){
                ex.printStackTrace();
                System.out.println("Failed to download audio: "+word+", american.");
            }
        }


        wordMngBO.addWord(dto);
        return WrapperResponse.ok("ok");
    }
    @ResponseBody
    @RequestMapping(value = "/getWordAudioUrl", method = {RequestMethod.POST})
    public WrapperResponse<String> getWordAudioUrl(@RequestBody Map<String, String> body) {
        String url = minioClient.getWordAudioUrl(body.get("ossid"));
        return WrapperResponse.ok(url);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteWord", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteWord(@RequestBody WordDTO dto) {
        Long ret = wordMngBO.deleteWord(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/updateWordComment", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateWordComment(@RequestBody WordDTO dto) {
        Long ret = wordMngBO.updateWordComment(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/updateWordTagRel", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateWordTagRel(@RequestBody WordDTO dto) {
        Long ret = wordMngBO.updateWordTagRel(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/uploadImage", method = {RequestMethod.POST})
    public WrapperResponse<String> uploadImage(@RequestParam(value = "image") MultipartFile image) {
        String imageId = UUID.randomUUID().toString();

        try {
            minioClient.putWordImage(imageId, image.getInputStream(), image.getSize(), image.getContentType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String url = minioClient.getWordImageUrl(imageId);

        return WrapperResponse.ok(url);
    }

    @ResponseBody
    @RequestMapping(value = "/queryNewlyAddedWordCntSummary", method = {RequestMethod.POST})
    public WrapperResponse<List<WordCntNewlyAddedDO>> queryNewlyAddedWordCntSummary() {
        List<WordCntNewlyAddedDO> ret = wordMngBO.queryNewlyAddedWordCntSummary();
        return WrapperResponse.ok(ret);
    }
}
