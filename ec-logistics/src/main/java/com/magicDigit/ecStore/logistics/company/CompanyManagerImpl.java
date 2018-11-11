package com.magicDigit.ecStore.logistics.company;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-11-02-下午12:45
 */
@Transactional
@Service
public class CompanyManagerImpl extends GenericManagerImpl<Company, String, GlobalException> implements CompanyManager {

    @Resource
    CompanyDao companyDao;

    protected GenericDao<Company, String> getDao() {
	  return companyDao;
    }
}
