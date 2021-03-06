package com.magicDigit.ecStore.wares.spec;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-10-19-上午10:53
 */

@Transactional
@Service
public class SpecManagerImpl extends GenericManagerImpl<Spec, String, GlobalException> implements SpecManager {

    private final static Logger logger = LoggerFactory.getLogger(SpecManagerImpl.class);

    @Resource
    SpecDao specDao;

    protected GenericDao<Spec, String> getDao() {
	  return specDao;
    }

    public Spec createSpec(Spec spec) throws GlobalException {

	  checkSpecName(spec);
	  Spec spec1 = specDao.save(spec);
	  return spec1;

    }

    @Transactional
    public Spec updateSpec(Spec spec) throws GlobalException {
	  if (specDao.existsById(spec.getId())) {
		removeSpec(spec.getId());
		return specDao.save(spec);
	  } else {
		throw new GlobalException(400, "该规格不存在");

	  }
    }


    /**
     * 删除规格, 以及相关联的规格项
     *
     * @param specId
     * @throws GlobalException
     */
    protected void removeSpec(String specId) throws GlobalException {
	  specDao.deleteById(specId);
    }

    /**
     * 检查规格名是否已存在
     *
     * @param spec
     * @throws GlobalException
     */
    protected void checkSpecName(Spec spec) throws GlobalException {
	  logger.info(" spec === {}  ", spec.toString());
	  Spec spec1 = specDao.getBySpecName(spec.getSpecName());
	  if (spec1 != null) {
		throw new GlobalException(400, "该规格名已存在");
	  }
    }


}
