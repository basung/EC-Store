package com.magicDigit.ecStore.admin.rolePermission;


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
public interface RolePermissionService extends GenericManager<RolePermission, String, GlobalException> {

    void createRolePermission(String var1, String var2) throws GlobalException;

    List getRolePermission(String roleId) throws GlobalException;
}
