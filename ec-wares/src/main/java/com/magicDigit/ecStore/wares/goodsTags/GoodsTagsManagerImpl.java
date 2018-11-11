package com.magicDigit.ecStore.wares.goodsTags;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-10-23-下午2:43
 */

@Transactional
@Service
public class GoodsTagsManagerImpl extends GenericManagerImpl<GoodsTags, String, GlobalException> implements GoodsTagsManager {

    @Resource
    GoodsTagsDao goodsTagsDao;

    protected GenericDao<GoodsTags, String> getDao() {
	  return goodsTagsDao;
    }

    @Transactional
    public void removeByGoodsId(String goodsId) throws GlobalException {
	  goodsTagsDao.removeByGoodsId(goodsId);
    }

}
