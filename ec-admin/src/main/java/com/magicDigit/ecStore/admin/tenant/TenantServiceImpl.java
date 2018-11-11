package com.magicDigit.ecStore.admin.tenant;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Date: 2018-10-18-下午2:28
 */
@Transactional
@Service
public class TenantServiceImpl extends GenericManagerImpl<Tenant, String, GlobalException> implements TenantService {

    @Resource
    TenantRepository tenantRepository;

    protected GenericDao<Tenant, String> getDao() {
	  return tenantRepository;
    }

}
