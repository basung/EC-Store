package com.magicDigit.ecStore.wares.goodsTags;


import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.manager.GenericManager;

/**
 * Date: 2018-10-23-下午2:43
 */
public interface GoodsTagsManager extends GenericManager<GoodsTags, String, GlobalException> {

    void removeByGoodsId(String goodsId) throws GlobalException;
}
