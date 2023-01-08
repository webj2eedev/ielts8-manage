package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.GrammarDao;
import com.webj2eedev.ieltsnote.dto.grammar.AddChildCategoryDTO;
import com.webj2eedev.ieltsnote.dto.grammar.AddSiblingCategoryDTO;
import com.webj2eedev.ieltsnote.entity.grammar.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GrammarBO {
    @Resource
    private GrammarDao dao;

    public List<GrammarCategoryDO> queryCatetory() {
        List<GrammarCategoryDO> ret = dao.queryCatetory();
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

    public Long updateCategory(GrammarCategoryDO pdto) {
        Long ret = dao.updateCategory(pdto);
        return ret;
    }
}
