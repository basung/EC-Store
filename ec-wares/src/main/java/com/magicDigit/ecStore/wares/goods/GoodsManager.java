package com.magicDigit.ecStore.wares.goods;


import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.manager.GenericManager;

/**
 * Date: 2018-10-19-下午12:21
 */
public interface GoodsManager extends GenericManager<Goods, String, GlobalException> {

    /**
     * 创建商品，同时创建相应的SKU等数据
     *
     * @param goods
     * @return goods
     * @throws GlobalException
     */
    Goods createGoods(Goods goods) throws GlobalException;

    /**
     * 编辑商品
     *
     * @param goods
     * @return goods
     * @throws GlobalException
     */
    Goods updateGoods(Goods goods) throws GlobalException;


}
