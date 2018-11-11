package com.magicDigit.ecStore.wares.goodsImage;

import com.magicDigit.ecStore.common.dao.GenericDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * Date: 2018-10-19-下午12:31
 */
public interface GoodsImageDao extends GenericDao<GoodsImage, String> {


    @Modifying
    @Transactional
    @Query(value = " DELETE FROM bss_wares_goods_image WHERE goods_id = ?1 ", nativeQuery = true)
    void removeByGoodsId(String goodsId);

}
