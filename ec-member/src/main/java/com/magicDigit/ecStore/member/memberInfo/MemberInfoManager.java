package com.magicDigit.ecStore.member.memberInfo;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.manager.GenericManager;

/**
 * Date: 2018-11-03-下午4:15
 */
public interface MemberInfoManager extends GenericManager<MemberInfo, String, GlobalException> {


    MemberInfo getMemberByName(String name);

}
