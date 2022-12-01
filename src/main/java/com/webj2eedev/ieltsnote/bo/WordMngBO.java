package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.WordDAO;
import com.webj2eedev.ieltsnote.dto.WordDTO;
import com.webj2eedev.ieltsnote.entity.WordCntNewlyAddedDO;
import com.webj2eedev.ieltsnote.entity.WordDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordMngBO {
    @Resource
    private WordDAO wordDAO;

    public List<WordDTO> queryWords(WordDTO pDto) {
        WordDO pDo = WordDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        List<WordDO> _dos = wordDAO.queryWords(pDo);
        return _dos.stream().map(_do -> {
            WordDTO dto = WordDTO.builder().build();
            BeanUtils.copyProperties(_do, dto, WordDTO.class);
            return dto;
        }).collect(Collectors.toList());
    }

    public WordDO queryWord(WordDTO pDto) {
        WordDO pDo = WordDO.builder().build();
        BeanUtils.copyProperties(pDto, pDo);

        WordDO rdo = wordDAO.queryWord(pDo);
        return rdo;
    }

    public boolean existWord(WordDTO dto) {
        WordDO _do = WordDO.builder().word(dto.getWord()).creator(dto.getCreator()).build();
        return wordDAO.existWord(_do);
    }

    public void addWord(WordDTO dto) {
        WordDO _do = WordDO.builder().build();
        BeanUtils.copyProperties(dto, _do);
        wordDAO.addWord(_do);
        wordDAO.updateWordTagRel(_do);
    }

    public Long deleteWord(WordDTO dto) {
        WordDO _do = WordDO.builder().word(dto.getWord()).build();
        return wordDAO.deleteWord(_do);
    }

    public Long updateWordComment(WordDTO dto) {
        WordDO _do = WordDO.builder().build();
        BeanUtils.copyProperties(dto, _do);
        return wordDAO.updateWordComment(_do);
    }
    public Long updateWordTagRel(WordDTO dto) {
        WordDO _do = WordDO.builder().build();
        BeanUtils.copyProperties(dto, _do);
        return wordDAO.updateWordTagRel(_do);
    }


    public List<WordCntNewlyAddedDO> queryNewlyAddedWordCntSummary() {
        List<WordCntNewlyAddedDO> rDos = wordDAO.queryNewlyAddedWordCntSummary();
        return rDos;
    }
}
