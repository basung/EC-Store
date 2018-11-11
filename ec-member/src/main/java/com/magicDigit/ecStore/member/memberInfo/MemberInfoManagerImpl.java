package com.magicDigit.ecStore.member.memberInfo;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-11-03-下午4:15
 */

@Transactional
@Service
public class MemberInfoManagerImpl extends GenericManagerImpl<MemberInfo, String, GlobalException> implements MemberInfoManager {

  @Resource
  MemberInfoDao memberInfoDao;

  protected GenericDao<MemberInfo, String> getDao(){ return memberInfoDao; }

  public MemberInfo getMemberByName(String name) {
    MemberInfo memberInfo = this.memberInfoDao.getMemberInfoByLoginName(name);
    return memberInfo;
  }

}
