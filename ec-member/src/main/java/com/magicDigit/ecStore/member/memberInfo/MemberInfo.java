package com.magicDigit.ecStore.member.memberInfo;

import com.magicDigit.ecStore.common.entity.GenericEntity;
import com.magicDigit.ecStore.member.memberAddress.MemberAddress;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Date: 2018-11-03-下午3:44
 */

@Entity
@Table(name = "BSS_MEMBER_INFO")
@Data
@EntityListeners(AuditingEntityListener.class)
public class MemberInfo extends GenericEntity {

  @ApiModelProperty(value = "登录账号")
  @NotBlank(message = "用户名不能为空")
  @Column(name = "login_name", nullable = false, updatable = false, length = 128)
  private String loginName;

  @NotBlank(message = "用户密码不能为空")
  @Column(name = "password", nullable = false, length = 128)
  private String password;

  @Column(name = "salt", length = 32)
  private String salt;

  @Column(name = "true_name", length = 128)
  private String trueName;

  @Column(name = "email", length = 128)
  private String email;

  @Column(name = "telephone", length = 32)
  private String telephone;

  @Column(name = "mobile", length = 32)
  private String mobile;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "birthday")
  private Date birthday;

  /**
   * 性别（1：男 2：女）
   */
  @Column(name = "sex")
  private Integer sex;

  /**
   * 头像
   */
  @Column(name = "avatar", length = 256)
  private String avatar;

  /**
   * 会员地区
   */
  @Column(name = "member_regions")
  private String memberRegions;

  /**
   * 会员地址
   */
  @Column(name = "member_address")
  private String memberAddress;

  /**
   * 订单数量
   */
  @Column(name = "order_number")
  private Integer orderNumber=0;

  /**
   * 会员等级
   */
  @Column(name = "member_level")
  private Integer memberLevel=1;

  /**
   * 账户余额
   */
  @Column(name = "advance")
  private Integer advance = 0;

  /**
   * 会员积分
   */
  @Column(name = "member_points")
  private Integer memberPoints = 0;


  /**
   * 会员地址
   */
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "member_id", referencedColumnName = "id")
  private Set<MemberAddress> memberAddressList;


}
