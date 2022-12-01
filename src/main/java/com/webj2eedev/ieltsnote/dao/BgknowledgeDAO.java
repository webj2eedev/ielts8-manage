package com.webj2eedev.ieltsnote.dao;

import com.webj2eedev.ieltsnote.entity.BgknowledgeArticleDO;
import com.webj2eedev.ieltsnote.entity.BgknowledgeCategoryDO;
import com.webj2eedev.ieltsnote.entity.BgknowledgeLogDO;
import com.webj2eedev.ieltsnote.entity.BgknowledgeSummaryDO;

import java.util.List;

public interface BgknowledgeDAO {
    List<BgknowledgeCategoryDO> queryCatetory(BgknowledgeCategoryDO pDo);

    int addSiblingCategory(BgknowledgeCategoryDO pDo);

    int addChildCategory(BgknowledgeCategoryDO pDo);

    List<BgknowledgeArticleDO> queryArticles(BgknowledgeCategoryDO pDo);

    int addArticle(BgknowledgeArticleDO pDo);

    Long updateArticleContent(BgknowledgeArticleDO pDo);

    Long log(BgknowledgeLogDO pDo);
    List<BgknowledgeSummaryDO> queryLogSummary(BgknowledgeLogDO pDo);

}
