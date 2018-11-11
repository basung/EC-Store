package com.magicDigit.ecStore.api.controller.member;

import com.magicDigit.ecStore.api.controller.ecLogistics.CarriageController;
import com.magicDigit.ecStore.api.utils.ControllerUtils;
import com.magicDigit.ecStore.base.exception.ExceptionEnum;
import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.base.utils.MD5;
import com.magicDigit.ecStore.common.controller.AutoEntityController;
import com.magicDigit.ecStore.common.controller.ResponseUtils;
import com.magicDigit.ecStore.member.memberInfo.MemberInfo;
import com.magicDigit.ecStore.member.memberInfo.MemberInfoManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Date: 2018-11-03-下午4:18
 */

@Api(value = "会员信息  会员信息", tags = {"会员信息  会员信息"})
@RestController
@RequestMapping("/member/memberInfo")
public class memberInfoController extends AutoEntityController<MemberInfo, String, GlobalException, MemberInfoManager> {

    private final static Logger logger = LoggerFactory.getLogger(CarriageController.class);

    @Autowired
    private MemberInfoManager memberInfoManager;

    @Autowired
    private ControllerUtils controllerUtils;

    @PostConstruct
    public void init() {
	  this.autoEntityManager = memberInfoManager;
    }


    @ResponseBody
    @GetMapping(value = "query")
    @ApiOperation(value = "查询列表", httpMethod = "GET", response = MemberInfo.class)
    public void query(HttpServletRequest request, HttpServletResponse response) throws Exception {
	  queryAutoEntity(request, response);
    }

    @ApiOperation(value = "新增", notes = "保存  新增")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void add(@ApiParam(value = "对象", required = true) @Validated @RequestBody MemberInfo memberInfo, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) throws Exception {

	  if (bindingResult.hasErrors()) {
		ResponseUtils.writeErrorResult(response, 400, bindingResult.getFieldError().getDefaultMessage());
	  }
	  // 判断账号是否重复
	  MemberInfo memberInfo1 = memberInfoManager.getMemberByName(memberInfo.getLoginName());
	  if(memberInfo1 == null){
		// 完善账号信息
		memberInfo.setIsActive(1);
		memberInfo.setSalt(MD5.getRandomSalt(5));
		memberInfo.setPassword(MD5.md5(memberInfo.getPassword(), memberInfo.getSalt()));
		controllerUtils.setTenantInfoByCreate(memberInfo);
		//持久化
		addAutoEntity(memberInfo, request, response);
	  }else {
		ResponseUtils.writeErrorResult(response, ExceptionEnum.USER_HAS_EXISTED.getCode(), ExceptionEnum.USER_HAS_EXISTED.getMessage());
	  }

    }

    @ResponseBody
    @PutMapping(value = "update")
    @ApiOperation(value = "修改", httpMethod = "PUT")
    public void update(@ApiParam(value = "对象", required = true) @Validated @RequestBody MemberInfo memberInfo, Errors errors, HttpServletRequest request, HttpServletResponse response) throws Exception {

	  controllerUtils.setTenantInfoByUpdate(memberInfo);
	  updateAutoEntity(memberInfo, response);
    }

    @ResponseBody
    @DeleteMapping(value = "/remove/{id}")
    @ApiOperation(value = "删除", httpMethod = "DELETE")
    public void del(@ApiParam(value = "标识", required = true) @PathVariable(value = "id") String id, HttpServletResponse response) throws Exception {
	  removeAutoEntity(id, response);
    }

    @ResponseBody
    @GetMapping(value = "/get/{id}")
    @ApiOperation(value = "获取单个对象", httpMethod = "GET", response = MemberInfo.class)
    public void get(@ApiParam(value = "标识", required = true) @PathVariable String id, HttpServletResponse response) throws Exception {
	  getAutoEntity(id, response);
    }

    @ResponseBody
    @RequestMapping(value = "/editPassword", method = RequestMethod.POST)
    @ApiOperation(value = "修改", httpMethod = "POST")
    public void editPassword(@RequestParam("id") String id, @RequestParam("password") String password, HttpServletResponse response) throws Exception {

    	if(memberInfoManager.existsById(id)){

    	    MemberInfo memberInfo = memberInfoManager.findById(id);
	    memberInfo.setSalt(MD5.getRandomSalt(5));
	    memberInfo.setPassword(MD5.md5(password, memberInfo.getSalt()));
	    updateAutoEntity(memberInfo, response);

	}else {
    	    ResponseUtils.writeErrorResult(response, 400, "用户不存在！");
	}

    }


}
