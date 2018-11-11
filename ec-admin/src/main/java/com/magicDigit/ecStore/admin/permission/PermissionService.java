package com.magicDigit.ecStore.admin.permission;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.manager.GenericManager;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wangyang
 * Date: 2018-09-27
 * Time: 下午9:40
 */
public interface PermissionService extends GenericManager<Permission, String, GlobalException> {

    List getPermissionsByRoleId(String roleId) throws GlobalException;

}
