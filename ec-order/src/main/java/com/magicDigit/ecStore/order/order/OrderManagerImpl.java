package com.magicDigit.ecStore.order.order;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.UUID;

/**
 * Date: 2018-11-06-下午12:07
 */
@Transactional
@Service
public class OrderManagerImpl extends GenericManagerImpl<Order, String, GlobalException> implements OrderManager {

  @Resource
  OrderDao orderDao;

  protected GenericDao<Order, String> getDao() {return  orderDao;}


  protected String generateNo()
  {
    int machineId = 1;//最大支持1-9个集群机器部署
    int hashCodeV = UUID.randomUUID().toString().hashCode();
    if (hashCodeV < 0) {//有可能是负数
      hashCodeV = -hashCodeV;
    }
    String no = machineId + String.format("%012d", hashCodeV);
    return no;
  }

}
