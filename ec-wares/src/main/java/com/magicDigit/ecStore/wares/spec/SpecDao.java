package com.magicDigit.ecStore.wares.spec;

import com.magicDigit.ecStore.common.dao.GenericDao;

/**
 * Date: 2018-10-19-上午10:51
 */
public interface SpecDao extends GenericDao<Spec, String> {


    //    @Query(value = " SELECT * FROM bss_admin_user WHERE login_name = ?1 ", nativeQuery = true)
    Spec getBySpecName(String specName);

}
