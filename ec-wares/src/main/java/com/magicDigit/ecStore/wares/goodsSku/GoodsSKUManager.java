package com.magicDigit.ecStore.wares.goodsSku;


import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.manager.GenericManager;

/**
 * Date: 2018-10-19-下午12:41
 */
public interface GoodsSKUManager extends GenericManager<GoodsSKU, String, GlobalException> {

    void removeByGoodsId(String goodsId) throws GlobalException;
}
