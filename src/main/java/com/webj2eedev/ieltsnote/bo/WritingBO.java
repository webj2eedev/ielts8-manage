package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.WritingDao;
import com.webj2eedev.ieltsnote.dto.writing.AddChildCategoryDTO;
import com.webj2eedev.ieltsnote.dto.writing.AddSiblingCategoryDTO;
import com.webj2eedev.ieltsnote.entity.writing.WritingCategoryDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WritingBO {
    @Resource
    private WritingDao dao;

    public List<WritingCategoryDO> queryCatetory() {
        List<WritingCategoryDO> ret = dao.queryCatetory();
        return ret;
    }

    public Long addSiblingCategory(AddSiblingCategoryDTO pdto) {
        Long ret = dao.addSiblingCategory(pdto);
        return ret;
    }

    public Long addChildCategory(AddChildCategoryDTO pdto) {
        Long ret = dao.addChildCategory(pdto);
        return ret;
    }

    public Long updateCategory(WritingCategoryDO pdto) {
        Long ret = dao.updateCategory(pdto);
        return ret;
    }

//    public List<WritingExpressionDO> queryWritings(WritingCategoryDTO pDto) {
//        WritingCategoryDO pDo = WritingCategoryDO.builder().build();
//        BeanUtils.copyProperties(pDto, pDo);
//
//        List<WritingExpressionDO> rDos = dao.queryWritings(pDo);
//        return rDos;
//    }
//
//    public int addExpression(WritingExpressionDO pDo) {
//        dao.addExpression(pDo);
//
//        return pDo.getExpressionId();
//    }
//
//    public Long updateExpression(WritingExpressionDO pDo) {
//        Long ret = dao.updateExpression(pDo);
//        return ret;
//    }
//
//    public int addSample(WritingExpressionDO pDo) {
//        dao.addSample(pDo);
//
//        return pDo.getSampleId();
//    }
//
//    public Long updateSample(WritingExpressionDO pDo) {
//        Long ret = dao.updateSample(pDo);
//        return ret;
//    }
//
//    public Long deleteExpression(WritingExpressionDO pDo) {
//        Long ret = dao.deleteExpression(pDo);
//        return ret;
//    }
//    public Long deleteSample(WritingExpressionDO pDo) {
//        Long ret = dao.deleteSample(pDo);
//        return ret;
//    }
//
//
//    public Long log(WritingLogDO pDo) {
//        Long ret = dao.log(pDo);
//        return ret;
//    }
//
//    public List<WritingSummaryDTO> queryWritingSummary(WritingLogDO pDo) {
//        List<WritingSummaryDO> rDos = dao.queryWritingSummary(pDo);
//        return rDos.stream().map(rDo -> {
//            WritingSummaryDTO rDto = WritingSummaryDTO.builder().build();
//            BeanUtils.copyProperties(rDo, rDto);
//            return rDto;
//        }).collect(Collectors.toList());
//    }


}
