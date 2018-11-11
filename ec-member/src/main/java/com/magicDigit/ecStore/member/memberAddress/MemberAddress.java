package com.magicDigit.ecStore.member.memberAddress;

import com.magicDigit.ecStore.common.entity.GenericEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * Date: 2018-11-03-下午3:57
 */

@Entity
@Table(name = "BSS_MEMBER_ADDRESS")
@Data
@EntityListeners(AuditingEntityListener.class)
public class MemberAddress extends GenericEntity {


  @Column(name = "member_id", nullable = false, updatable = false)
  private String memberId;

  @Column(name = "receiver")
  private String receiver;

  @Column(name = "telephone")
  private String telephone;

  @Column(name = "mobile")
  private String mobile;

  @Column(name = "region")
  private String region;

  @Column(name = "address")
  private String address;

  @Column(name = "zip")
  private String zip;

  @Column(name = "is_main")
  private Integer isMain;

}
