package com.magicDigit.ecStore.admin.adminUser;

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
public class AdminUserServiceImpl extends GenericManagerImpl<AdminUser, String, GlobalException> implements AdminUserService {

    @Resource
    AdminUserRepository adminUserRepository;

    protected GenericDao<AdminUser, String> getDao() {
	  return adminUserRepository;
    }

    public AdminUser getAdminUserByUserName(String userName) {
	  AdminUser adminUser = this.adminUserRepository.getByUserName(userName);
	  return adminUser;
    }

    public AdminUser getAdminUserByUserId(String userId) {

	  AdminUser adminUser = this.adminUserRepository.getAdminUserById(userId);

	  return adminUser;

    }

}
