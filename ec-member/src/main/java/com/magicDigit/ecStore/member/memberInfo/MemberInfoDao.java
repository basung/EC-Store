package com.magicDigit.ecStore.member.memberInfo;

import com.magicDigit.ecStore.common.dao.GenericDao;
import org.springframework.data.jpa.repository.Query;

/**
 * Date: 2018-11-03-下午4:14
 */
public interface MemberInfoDao extends GenericDao<MemberInfo, String> {

    MemberInfo getMemberInfoByLoginName(String name);

}
