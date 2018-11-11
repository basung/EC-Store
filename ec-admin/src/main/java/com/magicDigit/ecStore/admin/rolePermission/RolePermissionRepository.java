package com.magicDigit.ecStore.admin.rolePermission;

import com.magicDigit.ecStore.common.dao.GenericDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wangyang
 * Date: 2018-09-27
 * Time: 下午9:38
 */
@Repository
public interface RolePermissionRepository extends GenericDao<RolePermission, String> {

    @Modifying
    @Query(value = " DELETE FROM bss_admin_role_permission WHERE role_id = ?1 ", nativeQuery = true)
    void removeByRoleId(String roleId);

    @Query(value = " SELECT * FROM bss_admin_role_permission WHERE role_id = ?1 ", nativeQuery = true)
    List<RolePermission> getByRoleId(String roleId);

}
