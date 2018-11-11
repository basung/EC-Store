package com.magicDigit.ecStore.admin.role;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wangyang
 * Date: 2018-09-27
 * Time: 下午9:40
 */

@Transactional
@Service
public class RoleServiceImpl extends GenericManagerImpl<Role, String, GlobalException> implements RoleService {

    @Resource
    RoleRepository roleRepository;

    protected GenericDao<Role, String> getDao() {
	  return roleRepository;
    }


}
