package com.webj2eedev.ieltsnote.job;

import com.webj2eedev.ieltsnote.dao.WordLogDAO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class WordJob {
    private static Log log = LogFactory.getLog(WordJob.class);

    @Resource
    private WordLogDAO wordLogDAO;

    @Scheduled(cron = "0 0 4 1/1 * ?")
    public void wordLog(){
        wordLogDAO.log();
        log.info("Word log collected!");
    }
}
