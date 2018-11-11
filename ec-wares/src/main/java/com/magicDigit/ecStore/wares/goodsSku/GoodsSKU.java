package com.magicDigit.ecStore.wares.goodsSku;

import com.magicDigit.ecStore.common.entity.GenericEntity;
import com.magicDigit.ecStore.wares.goods.Goods;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * Date: 2018-10-19-下午12:35
 */


@Entity
@Table(name = "BSS_WARES_GOODS_SKU")
@Data
@EntityListeners(AuditingEntityListener.class)
public class GoodsSKU extends GenericEntity {

    /**
     * 商品Id
     */
    @Column(name = "goods_id", nullable = false)
    private String goodsId;

    /**
     * 商品名称
     */
    @Column(name = "goods_name", nullable = false)
    private String goodsName;

    /**
     * 商品分类标识
     */
    @Column(name = "category_id", nullable = false)
    private String categoryId;

    /**
     * 商品分类名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 商品品牌标识
     */
    @Column(name = "brand_id", nullable = false)
    private String brandId;

    /**
     * 商品品牌名称
     */
    @Column(name = "brand_name")
    private String brandName;


    /**
     * 价格,单位为元
     */
    @Column(name = "sale_price", nullable = false)
    private double salePrice;

    /**
     * 市场价格,单位为元
     */
    @Column(name = "market_price")
    private double marketPrice;

    /**
     * 成本价格,单位为元
     */
    @Column(name = "cost_price")
    private double costPrice;

    /**
     * SKU图片
     */
    @Column(name = "sku_image", length = 256)
    private String skuImage;

    /**
     * SKU 名称 eg: 玉兰油沐浴露200ml
     */
    @Column(name = "sku_name")
    private String skuName;

    /**
     * 库存
     */
    @Column(name = "stock_num", nullable = false)
    private long stockNum;

    /**
     * SKU product code
     */
    @Column(name = "product_code")
    private String productCode;

    /**
     * 商品条码
     */
    @Column(name = "bar_code")
    private String barCode;

    /**
     * 商品规格
     */
    @Lob
    @Column(name = "sku_spec")
    private String skuSpec;

}
