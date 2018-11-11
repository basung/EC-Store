package com.magicDigit.ecStore.logistics.carriage;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-11-02-下午1:35
 */

@Transactional
@Service
public class CarriageTemplateManagerImpl extends GenericManagerImpl<CarriageTemplate, String, GlobalException> implements CarriageTemplateManager {

    @Resource
    CarriageTemplateDao carriageTemplateDao;

    protected GenericDao<CarriageTemplate, String> getDao() {
	  return carriageTemplateDao;
    }

}
