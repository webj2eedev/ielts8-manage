package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.WordlistDao;
import com.webj2eedev.ieltsnote.entity.WordlistWordDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WordlistBO {
    @Resource
    private WordlistDao dao;

    public void addWord(WordlistWordDO pdo) {
        dao.addWord(pdo);
    }
}
