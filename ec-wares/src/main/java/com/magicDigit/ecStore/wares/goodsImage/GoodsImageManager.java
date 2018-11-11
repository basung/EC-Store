package com.magicDigit.ecStore.wares.goodsImage;


import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.manager.GenericManager;

/**
 * Date: 2018-10-19-下午12:31
 */
public interface GoodsImageManager extends GenericManager<GoodsImage, String, GlobalException> {

    void removeByGoodsId(String goodsId) throws GlobalException;

}
