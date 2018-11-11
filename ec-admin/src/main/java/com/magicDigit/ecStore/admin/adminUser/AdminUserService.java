package com.magicDigit.ecStore.admin.adminUser;


import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.manager.GenericManager;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wangyang
 * Date: 2018-09-27
 * Time: 下午9:40
 */
public interface AdminUserService extends GenericManager<AdminUser, String, GlobalException> {

    AdminUser getAdminUserByUserName(String userName);

    AdminUser getAdminUserByUserId(String userId);

}
