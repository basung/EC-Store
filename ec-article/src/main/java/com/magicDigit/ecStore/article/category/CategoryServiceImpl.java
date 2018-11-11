package com.magicDigit.ecStore.article.category;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Date: 2018-10-18-下午4:01
 */

@Transactional
@Service
public class CategoryServiceImpl extends GenericManagerImpl<NewsCategory, String, GlobalException> implements CategoryService {

    @Resource
    CategoryRepository categoryRepository;

    protected GenericDao<NewsCategory, String> getDao() {
	  return categoryRepository;
    }
}
