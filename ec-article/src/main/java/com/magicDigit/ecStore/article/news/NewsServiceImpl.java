package com.magicDigit.ecStore.article.news;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-10-18-下午4:20
 */

@Transactional
@Service
public class NewsServiceImpl extends GenericManagerImpl<News, String, GlobalException> implements NewsService {


    @Resource
    NewsRepository newsRepository;

    protected GenericDao<News, String> getDao() {
	  return newsRepository;
    }

}
