package com.webj2eedev.ieltsnote.bo;

import com.webj2eedev.ieltsnote.dao.WordTagDAO;
import com.webj2eedev.ieltsnote.dto.WordTagDTO;
import com.webj2eedev.ieltsnote.entity.WordTagDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordTagBO {
    @Resource
    private WordTagDAO wordTagDAO;

    public List<WordTagDTO> queryWordTags(WordTagDTO dto) {
        WordTagDO _do = WordTagDO.builder().build();
        BeanUtils.copyProperties(dto, _do);

        List<WordTagDO> _dos = wordTagDAO.queryWordTags(_do);

        return _dos.stream().map(pDo -> {
            WordTagDTO pDto = WordTagDTO.builder().build();
            BeanUtils.copyProperties(pDo, pDto);
            return pDto;
        }).collect(Collectors.toList());
    }

    public boolean existWordTag(WordTagDTO dto) {
        WordTagDO _do = WordTagDO.builder().build();
        BeanUtils.copyProperties(dto, _do);
        return wordTagDAO.existWordTag(_do);
    }

    public int addWordTag(WordTagDTO dto) {
        WordTagDO _do = WordTagDO.builder().build();
        BeanUtils.copyProperties(dto, _do);
        wordTagDAO.addWordTag(_do);
        return _do.getId();
    }

    public Long deleteWordTag(WordTagDTO dto) {
        WordTagDO _do = WordTagDO.builder().build();
        BeanUtils.copyProperties(dto, _do);
        return wordTagDAO.deleteWordTag(_do);
    }

    public Long updateWordTag(WordTagDTO dto) {
        WordTagDO _do = WordTagDO.builder().build();
        BeanUtils.copyProperties(dto, _do);
        return wordTagDAO.updateWordTag(_do);
    }

}
