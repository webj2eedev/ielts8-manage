package com.webj2eedev.ieltsnote.controller;

import com.webj2eedev.ieltsnote.bo.WritingBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.writing.*;
import com.webj2eedev.ieltsnote.entity.writing.WritingCategoryDO;
import com.webj2eedev.ieltsnote.entity.writing.WritingNewlyAddedDO;
import com.webj2eedev.ieltsnote.entity.writing.WritingSampleDO;
import com.webj2eedev.ieltsnote.entity.writing.WritingSampleLinkDO;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import com.webj2eedev.ieltsnote.utils.uuid.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/writing")
public class WritingController {
    @Autowired
    WritingBO bo;

    @Autowired
    MINIOClient minio;

    private final String WRITING_BUCKET_NAME = "writing";


    @ResponseBody
    @RequestMapping(value = "/queryCatetory", method = {RequestMethod.POST})
    public WrapperResponse<List<WritingCategoryDO>> queryCatetory() {
        List<WritingCategoryDO> ret = bo.queryCatetory();
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addSiblingCategory", method = {RequestMethod.POST})
    public WrapperResponse<Long> addSiblingCategory(@RequestBody AddSiblingCategoryDTO dto) {
        Long ret = bo.addSiblingCategory(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addChildCategory", method = {RequestMethod.POST})
    public WrapperResponse<Long> addChildCategory(@RequestBody AddChildCategoryDTO dto) {
        Long ret = bo.addChildCategory(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/updateCategory", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateCategory(@RequestBody WritingCategoryDO pdo) {
        Long ret = bo.updateCategory(pdo);
        return WrapperResponse.ok(ret);
    }


    @ResponseBody
    @RequestMapping(value = "/querySamples", method = {RequestMethod.POST})
    public WrapperResponse<List<WritingSampleDO>> querySamples(@RequestBody QuerySamplesDTO dto) {
        List<WritingSampleDO> ret = bo.querySamples(dto.getCategoryId());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addSample", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addSample(@RequestBody WritingSampleDO dto) {
        int id = bo.addSample(dto);
        return WrapperResponse.ok(id);
    }


    @ResponseBody
    @RequestMapping(value = "/updateSample", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateSample(@RequestBody WritingSampleDO dto) {
        Long ret = bo.updateSample(dto);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteSample", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteSample(@RequestBody DeleteSampleDTO dto) {
        Long ret = bo.deleteSample(dto.getUid());
        return WrapperResponse.ok(ret);
    }


    @ResponseBody
    @RequestMapping(value = "/queryWritingNewlyAdded", method = {RequestMethod.POST})
    public WrapperResponse<List<WritingNewlyAddedDO>> queryWritingNewlyAdded(@RequestBody QuerySamplesNewlyAddedDTO dto) {
        List<WritingNewlyAddedDO> ret = bo.queryWritingNewlyAdded(dto.getCreator());
        return WrapperResponse.ok(ret);
    }


    @ResponseBody
    @RequestMapping(value = "/uploadImage", method = {RequestMethod.POST})
    public WrapperResponse<String> uploadImage(@RequestParam(value = "image") MultipartFile image) {
        try {
            String imageId = "MD_EDITOR_IMAGE_"+ UUID.randomUUID().toString();

            minio.putObject(WRITING_BUCKET_NAME, imageId, image.getInputStream(), image.getSize(), image.getContentType());

            return WrapperResponse.ok(imageId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/addSampleLink", method = {RequestMethod.POST})
    public WrapperResponse<Long> addSampleLink(@RequestBody WritingSampleLinkDO dto) {
        Long id = bo.addSampleLink(dto);
        return WrapperResponse.ok(id);
    }

    @ResponseBody
    @RequestMapping(value = "/querySampleLinks", method = {RequestMethod.POST})
    public WrapperResponse<List<WritingSampleLinkDO>> querySampleLinks(@RequestBody QuerySampleLinksDTO dto) {
        List<WritingSampleLinkDO> ret = bo.querySampleLinks(dto.getSampleId());
        return WrapperResponse.ok(ret);
    }
}
