package com.magicDigit.ecStore.wares.category;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-10-19-上午10:21
 */

@Transactional
@Service
public class CategoryManagerImpl extends GenericManagerImpl<Category, String, GlobalException> implements CategoryManager {

    @Resource
    CategoryDao categoryDao;

    protected GenericDao<Category, String> getDao() {
	  return categoryDao;
    }

}
