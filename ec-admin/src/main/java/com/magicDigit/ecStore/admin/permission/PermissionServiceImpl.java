package com.magicDigit.ecStore.admin.permission;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wangyang
 * Date: 2018-09-27
 * Time: 下午9:40
 */

@Transactional
@Service
public class PermissionServiceImpl extends GenericManagerImpl<Permission, String, GlobalException> implements PermissionService {

    @Resource
    PermissionRepository permissionRepository;

    protected GenericDao<Permission, String> getDao() {
	  return permissionRepository;
    }


    public List getPermissionsByRoleId(String roleId) {

	  return permissionRepository.getPermissionsByRoleId(roleId);

    }

}
