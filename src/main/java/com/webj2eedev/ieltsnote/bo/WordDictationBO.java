package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.WordDAO;
import com.webj2eedev.ieltsnote.dao.WordDictationDAO;
import com.webj2eedev.ieltsnote.dto.WordDTO;
import com.webj2eedev.ieltsnote.dto.WordDictationProgressDTO;
import com.webj2eedev.ieltsnote.dto.WordDictationProgressSummaryDTO;
import com.webj2eedev.ieltsnote.dto.WordDictationSessionDTO;
import com.webj2eedev.ieltsnote.entity.*;
import org.json.JSONArray;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordDictationBO {
    @Resource
    private WordDictationDAO wordDictationDAO;
    @Resource
    private WordDAO wordDAO;

    public int createDictationSession(WordDictationSessionDTO pDto){
        WordDictationSessionDO pDo = WordDictationSessionDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        // generate wordList
        List<DictationWordDO> dictationWordList = wordDictationDAO.generateDictationWordList(pDo);

        // createSession
        wordDictationDAO.createDictationSession(pDo);

        // createSessionDetail
        pDo.setWordNums(dictationWordList.size());
        pDo.setWordList(new JSONArray(dictationWordList).toString());
        wordDictationDAO.createDictationSessionDetail(pDo);
        return pDo.getId();
    }

    public int createDictationSessionWithDictationReportDontknowWordList(WordDictationSessionDTO pDto){
        WordDictationSessionDO pDo = WordDictationSessionDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<WordDO> words = wordDictationDAO.queryDictationReportDontknowWordList(pDo);

        // createSession
        // #{creator}
        WordDictationSessionDO pSessionDO = WordDictationSessionDO.builder().parentId(pDto.getId()).creator(pDto.getCreator()).build();
        wordDictationDAO.createDictationSession(pSessionDO);

        // createSessionDetail
        pSessionDO.setWordNums(words.size());
        pSessionDO.setWordList(new JSONArray(words).toString());
        wordDictationDAO.createDictationSessionDetail(pSessionDO);
        return pSessionDO.getId();
    }

    public Long completeDictationSession(WordDictationSessionDTO dto){

        WordDictationSessionDO _do = WordDictationSessionDO.builder().build();
        BeanUtils.copyProperties(dto, _do);

        Long ret = wordDictationDAO.completeDictationSession(_do);
        return ret;
    }

    public Long cancelDictationSession(WordDictationSessionDTO dto){

        WordDictationSessionDO _do = WordDictationSessionDO.builder().build();
        BeanUtils.copyProperties(dto, _do);

        Long ret = wordDictationDAO.cancelDictationSession(_do);
        return ret;
    }

    public WordDictationSessionDTO queryDictationSession(WordDictationSessionDTO dto){

        WordDictationSessionDO _do = WordDictationSessionDO.builder().build();
        BeanUtils.copyProperties(dto, _do);


        WordDictationSessionDO rdo = wordDictationDAO.queryDictationSession(_do);

        WordDictationSessionDTO rdto = WordDictationSessionDTO.builder().build();
        BeanUtils.copyProperties(rdo, rdto);

        return rdto;
    }

    public Long addDictationSessionProgress(WordDictationProgressDTO dto){

        WordDictationProgressDO _do = WordDictationProgressDO.builder().build();
        BeanUtils.copyProperties(dto, _do);

        Long ret = wordDictationDAO.addDictationSessionProgress(_do);
        return ret;
    }



    public List<WordDictationProgressSummaryDTO> queryDictationProgressSummary(WordDictationSessionDTO dto){

        WordDictationSessionDO _do = WordDictationSessionDO.builder().build();
        BeanUtils.copyProperties(dto, _do);

        List<WordDictationProgressSummaryDO> rdos = wordDictationDAO.queryDictationProgressSummary(_do);


        return rdos.stream().map(rdo -> {
            WordDictationProgressSummaryDTO rdto = WordDictationProgressSummaryDTO.builder().build();
            BeanUtils.copyProperties(rdo, rdto);
            return rdto;
        }).collect(Collectors.toList());
    }

    public List<WordDTO> queryDictationReportDontknowWordList(WordDictationSessionDTO dto){

        WordDictationSessionDO _do = WordDictationSessionDO.builder().build();
        BeanUtils.copyProperties(dto, _do);

        List<WordDO> rdos = wordDictationDAO.queryDictationReportDontknowWordList(_do);

        return rdos.stream().map(rdo -> {
            WordDTO rdto = WordDTO.builder().build();
            BeanUtils.copyProperties(rdo, rdto);
            return rdto;
        }).collect(Collectors.toList());
    }
}
