package com.magicDigit.ecStore.common.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Date: 2018-11-03-下午12:15
 */
@NoRepositoryBean
public interface GenericDao<T, ID extends Serializable> extends JpaSpecificationExecutor<T>, JpaRepository<T, ID> {

}
