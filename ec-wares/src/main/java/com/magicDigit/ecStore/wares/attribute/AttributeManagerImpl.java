package com.magicDigit.ecStore.wares.attribute;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-10-19-下午2:30
 */

@Transactional
@Service
public class AttributeManagerImpl extends GenericManagerImpl<Attribute, String, GlobalException> implements AttributeManager {

    @Resource
    AttributeDao attributeDao;

    protected GenericDao<Attribute, String> getDao() {
	  return attributeDao;
    }

    @Transactional
    public void removeByGoodsId(String goodsId) throws GlobalException {
	  attributeDao.removeByGoodsId(goodsId);
    }
}
