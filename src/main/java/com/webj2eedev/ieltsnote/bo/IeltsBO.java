package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.IeltsDao;
import com.webj2eedev.ieltsnote.entity.ielts.IeltsScoreDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IeltsBO {
    @Resource
    private IeltsDao dao;

    public List<IeltsScoreDO> queryScoreList() {
        return dao.queryScoreList();
    }
}
