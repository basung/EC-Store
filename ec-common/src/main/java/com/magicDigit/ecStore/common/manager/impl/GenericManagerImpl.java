package com.magicDigit.ecStore.common.manager.impl;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.entity.CommonEntity;
import com.magicDigit.ecStore.common.manager.GenericManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.List;

/**
 * Date: 2018-11-03-下午12:17
 */
public abstract class GenericManagerImpl<T extends CommonEntity, ID extends Serializable, E extends GlobalException> implements GenericManager<T, ID, E> {


  protected abstract GenericDao<T, ID> getDao();


  @Override
  public T save(T t) {
    return this.getDao().save(t);
  }

  @Override
  public Iterable<T> save(Iterable<T> entities) {
    return this.getDao().saveAll(entities);
  }

  @Override
  public void delete(ID id) {
    this.getDao().deleteById(id);
  }

  @Override
  public void delete(T t) {
    this.getDao().delete(t);
  }

  @Override
  public T findById(ID id) {

    if (this.getDao().findById(id).isPresent()) {
      return this.getDao().findById(id).get();
    } else {
      return null;
    }
  }

  @Override
  public List<T> findAll() {
    return this.getDao().findAll();
  }

  @Override
  public Boolean existsById(ID id) {
    return this.getDao().existsById(id);
  }

  @Override
  public Page<T> findAll(Pageable pageable) {
    return this.getDao().findAll(pageable);
  }

  @Override
  public List<T> query(Specification params) {
    return this.getDao().findAll(params);
  }

  @Override
  public Page<T> query(Specification params, Pageable pageable) {
    return this.getDao().findAll(params, pageable);
  }

}
