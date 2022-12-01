package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.StorylineDAO;
import com.webj2eedev.ieltsnote.dto.*;
import com.webj2eedev.ieltsnote.entity.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StorylineBO {
    @Resource
    private StorylineDAO dao;

    public List<StorylineCategoryDTO> queryCatetory(StorylineCategoryDTO pDto) {
        StorylineCategoryDO pDo = StorylineCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<StorylineCategoryDO> rDos = dao.queryCatetory(pDo);
        return rDos.stream().map(rDo -> {
            StorylineCategoryDTO rDto = StorylineCategoryDTO.builder().build();
            BeanUtils.copyProperties(rDo, rDto);
            return rDto;
        }).collect(Collectors.toList());
    }

    public int addSiblingCategory(StorylineCategoryDTO pDto) {
        StorylineCategoryDO pDo = StorylineCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        dao.addSiblingCategory(pDo);
        return pDo.getId();
    }

    public Long addChildCategory(StorylineCategoryDTO pDto) {
        StorylineCategoryDO pDo = StorylineCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.addChildCategory(pDo);
        return ret;
    }

    public StorylineCategoryDTO queryCategoryById(StorylineCategoryDTO pDto) {
        StorylineCategoryDO pDo = StorylineCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        StorylineCategoryDO rDo = dao.queryCategoryById(pDo);
        StorylineCategoryDTO rDto = StorylineCategoryDTO.builder().build();
        BeanUtils.copyProperties(rDo, rDto);
        return rDto;
    }

    public Long updateCategory(StorylineCategoryDTO pDto) {
        StorylineCategoryDO pDo = StorylineCategoryDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        Long ret = dao.updateCategory(pDo);
        return ret;
    }
}
