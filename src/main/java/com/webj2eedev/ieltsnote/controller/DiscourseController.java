package com.webj2eedev.ieltsnote.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.webj2eedev.ieltsnote.bo.DiscourseBO;
import com.webj2eedev.ieltsnote.common.web.WrapperResponse;
import com.webj2eedev.ieltsnote.dto.discourse.*;
import com.webj2eedev.ieltsnote.entity.discourse.DiscourseDO;
import com.webj2eedev.ieltsnote.entity.discourse.DiscourseNewlyAddedDO;
import com.webj2eedev.ieltsnote.utils.minio.MINIOClient;
import com.webj2eedev.ieltsnote.utils.uuid.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/discourse")
public class DiscourseController {
    @Autowired
    DiscourseBO bo;

    @Autowired
    private MINIOClient minio;

    private final String BUCKET_NAME = "discourse";


    @ResponseBody
    @RequestMapping(value = "/addDiscourse", method = {RequestMethod.POST})
    public WrapperResponse<DiscourseDO> addDiscourse(@RequestBody AddDiscourseDTO pdto) {
        int uid = bo.addDiscourse(pdto.getType(), pdto.getText().trim(), pdto.getCreator());

        DiscourseDO ret = bo.queryDiscourse(uid);

        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryDiscourse", method = {RequestMethod.POST})
    public WrapperResponse<DiscourseDO> queryDiscourse(@RequestBody QueryDiscourseDTO pdto) {
        DiscourseDO ret = bo.queryDiscourse(pdto.getUid());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryDiscourses", method = {RequestMethod.POST})
    public WrapperResponse<PageInfo> queryDiscourses(@RequestBody QueryDiscoursesDTO pdto) {
        Page<DiscourseDO> objects = PageHelper.startPage(pdto.getPagenum(), pdto.getPagesize());

        bo.queryDiscourses(pdto.getCondition());

        PageInfo<DiscourseDO> pageInfo = new PageInfo<>(objects);
        return WrapperResponse.ok(pageInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteDiscourse", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteDiscourse(@RequestBody DeleteDiscourseDTO pdto) {
        Long ret = bo.deleteDiscourse(pdto.getUid());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/uploadImage", method = {RequestMethod.POST})
    public WrapperResponse<String> uploadImage(@RequestParam(value = "image") MultipartFile image) {
        try {
            String imageId = "MD_EDITOR_IMAGE_"+UUID.randomUUID().toString();

            minio.putObject(BUCKET_NAME, imageId, image.getInputStream(), image.getSize(), image.getContentType());

            return WrapperResponse.ok(imageId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/updateDiscourse", method = {RequestMethod.POST})
    public WrapperResponse<Long> updateDiscourse(@RequestBody DiscourseDO pdo) {
        Long ret = bo.updateDiscourse(pdo);
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryDiscourseNewlyAdded", method = {RequestMethod.POST})
    public WrapperResponse<List<DiscourseNewlyAddedDO>> queryDiscourseNewlyAdded() {
        List<DiscourseNewlyAddedDO> ret = bo.queryDiscourseNewlyAdded();
        return WrapperResponse.ok(ret);
    }


    //////////////////////////////////////////////////

    @ResponseBody
    @RequestMapping(value = "/addDiscourseExample", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addDiscourseExample(@RequestBody AddDiscourseExampleDTO pdto) {
        int uid = bo.addDiscourseExample(pdto);

        return WrapperResponse.ok(uid);
    }

    //////////////////////////////////////////////////

    @ResponseBody
    @RequestMapping(value = "/addDiscourseGroup", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addDiscourseGroup(@RequestBody AddDiscourseGroupDTO pdto) {
        int ret = bo.addDiscourseGroup(pdto.getCreator());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/addDiscourseInGroup", method = {RequestMethod.POST})
    public WrapperResponse<Integer> addDiscourseInGroup(@RequestBody AddDiscourseInGroupDTO pdto) {
        Integer ret = bo.addDiscourseInGroup(pdto.getGroupId(), pdto.getDiscourseType(), pdto.getDiscourseText(), pdto.getCreator());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteDiscourseInGroup", method = {RequestMethod.POST})
    public WrapperResponse<Long> deleteDiscourseInGroup(@RequestBody DeleteDiscourseInGroupDTO pdto) {
        Long ret = bo.deleteDiscourseInGroup(pdto.getGroupId(), pdto.getDiscourseId(), pdto.getCascade());
        return WrapperResponse.ok(ret);
    }

    @ResponseBody
    @RequestMapping(value = "/queryDiscoursesInGroup", method = {RequestMethod.POST})
    public WrapperResponse<List<DiscourseDO>> queryDiscoursesInGroup(@RequestBody QueryDiscoursesInGroupDTO pdto) {
        List<DiscourseDO> ret = bo.queryDiscoursesInGroup(pdto.getGroupId(), pdto.getCondition());
        return WrapperResponse.ok(ret);
    }
}
