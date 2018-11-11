package com.magicDigit.ecStore.wares.attribute;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.manager.GenericManager;

/**
 * Date: 2018-10-19-下午2:28
 */
public interface AttributeManager extends GenericManager<Attribute, String, GlobalException> {

    void removeByGoodsId(String goodsId) throws GlobalException;

}
