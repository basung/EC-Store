package com.magicDigit.ecStore.admin.permission;

import com.magicDigit.ecStore.common.dao.GenericDao;
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
public interface PermissionRepository extends GenericDao<Permission, String> {

    @Query(value = "select p.* from bss_admin_permission p left join bss_admin_role_permission rp on p.id=rp.relation_id where rp.role_id = ?1", nativeQuery = true)
    List<Permission> getPermissionsByRoleId(String roleId);

}
