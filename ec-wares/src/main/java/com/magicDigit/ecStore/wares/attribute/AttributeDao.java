package com.magicDigit.ecStore.wares.attribute;

import com.magicDigit.ecStore.common.dao.GenericDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * Date: 2018-10-19-下午2:27
 */
public interface AttributeDao extends GenericDao<Attribute, String> {

    @Modifying
    @Transactional
    @Query(value = " DELETE FROM bss_wares_goods_attribute WHERE goods_id = ?1 ", nativeQuery = true)
    void removeByGoodsId(String goodsId);

}
