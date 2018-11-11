package com.magicDigit.ecStore.admin.adminUser;

import com.magicDigit.ecStore.common.dao.GenericDao;
import org.springframework.data.jpa.repository.Query;


/**
 * @program: ecommerce
 * Description: ${description}
 * 作者 : wangyang
 * 来源 : https:www.basung.com
 * Date: 2018-09-29-下午3:02
 */
public interface AdminUserRepository extends GenericDao<AdminUser, String> {

    @Query(value = " SELECT * FROM bss_admin_user WHERE login_name = ?1 ", nativeQuery = true)
    AdminUser getByUserName(String userName);

    AdminUser getAdminUserById(String userId);

}
