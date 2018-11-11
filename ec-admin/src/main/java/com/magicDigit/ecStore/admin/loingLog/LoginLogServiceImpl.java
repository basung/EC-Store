package com.magicDigit.ecStore.admin.loingLog;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Date: 2018-10-09-下午5:33
 */

@Transactional
@Service
public class LoginLogServiceImpl extends GenericManagerImpl<LoginLog, String, GlobalException> implements LoginLogService {

    @Resource
    LoginLogRepository loginLogRepository;

    protected GenericDao<LoginLog, String> getDao() {
	  return loginLogRepository;
    }

}

