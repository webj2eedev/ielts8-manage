package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.ielts.IeltsScoreDO;

import java.util.List;

public interface IeltsDao {
    List<IeltsScoreDO> queryScoreList();
}
