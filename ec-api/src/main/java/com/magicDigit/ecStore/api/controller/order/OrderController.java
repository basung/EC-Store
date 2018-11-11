package com.magicDigit.ecStore.api.controller.order;

import com.magicDigit.ecStore.api.controller.wares.BrandController;
import com.magicDigit.ecStore.api.utils.ControllerUtils;
import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.controller.AutoEntityController;
import com.magicDigit.ecStore.order.order.Order;
import com.magicDigit.ecStore.order.order.OrderManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Date: 2018-11-06-下午12:12
 */

@Api(value = "商品订单  商品订单", tags = {"商品订单  商品订单"})
@RestController
@RequestMapping("/order/order")
public class OrderController extends AutoEntityController<Order, String, GlobalException, OrderManager> {

  private final static Logger logger = LoggerFactory.getLogger(BrandController.class);

  @Autowired
  private OrderManager orderManager;

  @Autowired
  private ControllerUtils controllerUtils;

  @PostConstruct
  public void init() {
    this.autoEntityManager = orderManager;
  }


  @ResponseBody
  @GetMapping(value = "query")
  @ApiOperation(value = "查询列表", httpMethod = "GET", response = Order.class)
  public void query(HttpServletRequest request, HttpServletResponse response) throws Exception {
    queryAutoEntity(request, response);
  }

  @ApiOperation(value = "新增", notes = "保存  新增")
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public void add(@ApiParam(value = "对象", required = true) @Validated @RequestBody Order order, Errors errors, HttpServletRequest request, HttpServletResponse response) throws Exception {

    controllerUtils.setTenantInfoByCreate(order);
    addAutoEntity(order, request, response);
  }


  @ResponseBody
  @PutMapping(value = "update")
  @ApiOperation(value = "修改", httpMethod = "PUT")
  public void update(@ApiParam(value = "对象", required = true) @Validated @RequestBody Order order, Errors errors, HttpServletRequest request, HttpServletResponse response) throws Exception {

    controllerUtils.setTenantInfoByUpdate(order);
    updateAutoEntity(order, response);
  }

  @ResponseBody
  @DeleteMapping(value = "/remove/{id}")
  @ApiOperation(value = "删除", httpMethod = "DELETE")
  public void del(@ApiParam(value = "标识", required = true) @PathVariable(value = "id") String id, HttpServletResponse response) throws Exception {
    removeAutoEntity(id, response);
  }

  @ResponseBody
  @GetMapping(value = "/get/{id}")
  @ApiOperation(value = "获取单个对象", httpMethod = "GET", response = Order.class)
  public void get(@ApiParam(value = "标识", required = true) @PathVariable String id, HttpServletResponse response) throws Exception {
    getAutoEntity(id, response);
  }


}
