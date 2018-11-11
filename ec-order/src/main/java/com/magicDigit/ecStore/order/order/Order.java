package com.magicDigit.ecStore.order.order;

import com.magicDigit.ecStore.common.entity.GenericEntity;
import com.magicDigit.ecStore.order.orderItem.OrderItem;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

/**
 * Date: 2018-11-03-下午8:23
 */

@Entity
@Table(name = "BSS_ORDER")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Order extends GenericEntity {

  //订单状态(order_status,未付款,已付款,已发货,已签收,退货申请,退货中,已退货,取消交易)
  public static final Integer WAIT_ORDER_PAY = 1;   // 未付款
  public static final Integer WAIT_ORDER_SEND = 2; // 已付款等待发货
  public static final Integer WAIT_ORDER_RECEIVE = 3; // 已发货等待确认收货
  public static final Integer TRADE_FINISH = 4; // 已签收
  public static final Integer TRADE_ORDER_RETURN = 5; // 退货申请
  public static final Integer TRADE_ORDER_RETURN_IN = 6; // 退货中
  public static final Integer TRADE_ORDER_RETURN_FINISH = 7; // 已退货
  public static final Integer TRADE_ORDER_CANCEL = 8; // 取消交易

  //订单支付状态
  public static final Integer ORDER_WAIT_PAY = 1;   // 未付款
  public static final Integer ORDER_PAY_FINISH = 2;   // 付款完成
  public static final Integer ORDER_WAIT_RETURN_PAY = 3;   // 待退款
  public static final Integer ORDER_WAIT_RETURN_PAY_FINISH = 4;   // 已退款

  /**
   * 订单状态
   */
  @Column(name = "order_no", nullable = false, updatable = false)
  private String orderNo;

  /**
   * 订单状态
   */
  @Column(name = "order_status", nullable = false)
  private Integer orderStatus = WAIT_ORDER_PAY;

  /**
   * 支付状态
   */
  @Column(name = "order_pay_status", nullable = false)
  private Integer orderPayStatus = ORDER_WAIT_PAY;

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
   * 支付类型  支付类型|online:线上付款;offline:货到付款;
   */
  @Column(name = "pay_type", nullable = false, updatable = false)
  private String payType = "online";

  /**
   * 订单总金额
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
  private double pointsFee;

  /**
   * 促销优惠金额
   */
  @Column(name = "discount_fee", nullable = false, updatable = false)
  private double discountFee;

  /**
   * 订单邮费
   */
  @Column(name = "post_fee", nullable = false, updatable = false)
  private double postFee;

  /**
   * 收货人名称
   */
  @Column(name = "receiver_name", nullable = false, updatable = false)
  private String receiverName;

  /**
   * 关联收获地址
   */
  @Column(name = "receiver_address_id", nullable = false, updatable = false)
  private String receiverAddressId;

  /**
   * 收货人所在区域
   */
  @Column(name = "receiver_region", nullable = false, updatable = false)
  private String receiverRegion;

  /**
   * 收货人详细地址
   */
  @Column(name = "receiver_address", nullable = false, updatable = false)
  private String receiverAddress;

  /**
   * 收货人手机号
   */
  @Column(name = "receiver_mobile", nullable = false, updatable = false)
  private String receiverMobile;

  /**
   * 收货人电话
   */
  @Column(name = "receiver_phone", nullable = false, updatable = false)
  private String receiverPhone;


  /**
   * 是否需要开票
   */
  @Column(name = "need_invoice", nullable = false, updatable = false)
  private Integer needInvoice = 0;


  /**
   * 发票类型
   */
  //发票类型 invoiceType（normal : 普通发票、 electronicNormal : 电子普通发票、addedInvoice : 增值税专用发票）
  @Column(name = "invoice_type", nullable = false, updatable = false)
  private String invoiceType = "normal";

  /**
   * 发票抬头归属
   */
  // personal 、 company
  @Column(name = "invoice_title_type", nullable = false, updatable = false)
  private String invoiceTitleType = "personal";

  /**
   * 发票抬头
   */
  @Column(name = "invoice_title", nullable = false, updatable = false)
  private String invoiceTitle;

  /**
   * 纳税人识别号
   */
  @Column(name = "invoice_No", nullable = false, updatable = false)
  private String invoiceNo;

  /**
   * 增值税发票内容
   */
  // 商品明细 goods 、 商品分类 category
  @Column(name = "invoice_content", nullable = false, updatable = false)
  private String invoiceContent = "goods";


  /**
   * 买家实际使用积分
   */
  @Column(name = "real_point_fee", nullable = false, updatable = false)
  private double realPointFee = 0;

  /**
   * 买家获得积分,返点的积分
   */
  @Column(name = "obtain_point_fee", nullable = false, updatable = false)
  private double obtainPointFee = 0;

  /**
   * 卖家备注
   */
  @Column(name = "shop_memo")
  private String shopMemo;

  /**
   * 交易备注
   */
  @Column(name = "trade_memo")
  private String tradeMemo;

  /**
   * 买家是否已评价
   */
  @Column(name = "buyer_rate", nullable = false, updatable = false)
  private Integer buyerRate = 0;

  /**
   * 订单商品详情
   */
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "order_id", referencedColumnName = "id")
  private Set<OrderItem> orderItems;



}
