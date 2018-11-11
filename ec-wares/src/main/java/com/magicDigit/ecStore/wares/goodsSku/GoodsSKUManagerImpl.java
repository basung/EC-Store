package com.magicDigit.ecStore.wares.goodsSku;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-10-19-下午12:41
 */

@Transactional
@Service
public class GoodsSKUManagerImpl extends GenericManagerImpl<GoodsSKU, String, GlobalException> implements GoodsSKUManager {

    @Resource
    GoodsSKUDao goodsSKUDao;

    protected GenericDao<GoodsSKU, String> getDao() {
	  return goodsSKUDao;
    }

    @Transactional
    public void removeByGoodsId(String goodsId) throws GlobalException {
	  goodsSKUDao.removeByGoodsId(goodsId);
    }

}
