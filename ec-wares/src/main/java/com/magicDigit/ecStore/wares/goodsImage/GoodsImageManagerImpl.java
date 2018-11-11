package com.magicDigit.ecStore.wares.goodsImage;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-10-19-下午12:32
 */
@Transactional
@Service
public class GoodsImageManagerImpl extends GenericManagerImpl<GoodsImage, String, GlobalException> implements GoodsImageManager {

    @Resource
    GoodsImageDao goodsImageDao;

    protected GenericDao<GoodsImage, String> getDao() {
	  return goodsImageDao;
    }


    @Transactional
    public void removeByGoodsId(String goodsId) throws GlobalException {
	  goodsImageDao.removeByGoodsId(goodsId);
    }

}
