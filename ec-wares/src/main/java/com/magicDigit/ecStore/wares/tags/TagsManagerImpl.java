package com.magicDigit.ecStore.wares.tags;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-10-19-上午10:01
 */

@Transactional
@Service
public class TagsManagerImpl extends GenericManagerImpl<Tags, String, GlobalException> implements TagsManager {

    @Resource
    TagsDao tagsDao;

    protected GenericDao<Tags, String> getDao() {
	  return tagsDao;
    }

}
