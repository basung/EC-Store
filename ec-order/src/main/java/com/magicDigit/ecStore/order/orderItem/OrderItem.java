package com.magicDigit.ecStore.order.orderItem;

import com.magicDigit.ecStore.common.entity.GenericEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * Date: 2018-11-03-下午9:24
 */

@Entity
@Table(name = "BSS_ORDER_ITEM")
@Data
@EntityListeners(AuditingEntityListener.class)
public class OrderItem extends GenericEntity {


    /**
     * 订单所属的店铺id
     */
    @Column(name = "shop_id", nullable = false, updatable = false)
    private String shopId;

    /**
     * 会员id
     */
    @Column(name = "member_id", nullable = false, updatable = false)
    private String memberId;

    /**
     * 会员名称
     */
    @Column(name = "member_name")
    private String memberName;

    /**
     * 商品分类ID
     */
    @Column(name = "category_id")
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
     * 商品Id
     */
    @Column(name = "goods_id")
    private String goodsId;

    /**
     * 商品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * SKU Id
     */
    @Column(name = "sku_id")
    private String skuId;

    /**
     * SKU 名称
     */
    @Column(name = "sku_name")
    private String skuName;

    /**
     * SKU 编码
     */
    @Column(name = "sku_code")
    private String skuCode;

    /**
     * SKU 编码
     */
    @Column(name = "sku_bar_code")
    private String skuBarCode;

    /**
     * SKU 图片
     */
    @Column(name = "sku_image")
    private String skuImage;


    /**
     * 商品价格
     */
    @Column(name = "sku_price")
    private String skuPrice;

    /**
     * 商品数量
     */
    @Column(name = "sku_number")
    private String skuNumber;

    /**
     * 子订单总金额
     */
    @Column(name = "total_fee", nullable = false, updatable = false)
    private double totalFee;

    /**
     * 订单实际金额
     */
    @Column(name = "payment", nullable = false, updatable = false)
    private double payment;

    /**
     * 积分抵扣金额
     */
    @Column(name = "points_fee", nullable = false, updatable = false)
    private double pointsFee = 0;

    /**
     * 促销优惠金额
     */
    @Column(name = "discount_fee", nullable = false, updatable = false)
    private double discountFee = 0;


}
