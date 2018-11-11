package com.magicDigit.ecStore.order.orderItem;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-11-06-下午12:10
 */
@Transactional
@Service
public class OrderItemManagerImpl extends GenericManagerImpl<OrderItem, String, GlobalException> implements OrderItemManager {

  @Resource
  OrderItemDao orderItemDao;

  protected GenericDao<OrderItem, String> getDao(){return  orderItemDao;}

}
