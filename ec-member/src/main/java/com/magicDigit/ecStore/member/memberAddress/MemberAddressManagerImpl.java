package com.magicDigit.ecStore.member.memberAddress;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-11-03-下午4:12
 */

@Transactional
@Service
public class MemberAddressManagerImpl extends GenericManagerImpl<MemberAddress, String, GlobalException> implements MemberAddressManager {

  @Resource
  MemberAddressDao memberAddressDao;

  protected GenericDao<MemberAddress, String> getDao(){ return memberAddressDao; }

}
