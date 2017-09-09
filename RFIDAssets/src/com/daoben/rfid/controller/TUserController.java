package com.daoben.rfid.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.daoben.rfid.model.TUser;
import com.daoben.rfid.service.TUserService;
import com.daoben.rfid.utils.ResponsePWFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
@Controller
public class TUserController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private TUserService ts;

	@Resource
	private ResponsePWFactory responsePWFactory;

	/**
	 * @author wxp 查询用户信息
	 * 
	 */
	@ResponseBody
	// @RequestMapping("/t_user/QueryAllUserInfo")
	@RequestMapping(value = "/t_user/QueryAllUserInfo", produces = "text/json;charset=UTF-8")
	public String queryAllUserInfo() {
		String responseMap = "";
		try {
			List<TUser> user = ts.findAll();
			responseMap = responsePWFactory.responseMap("true", "查询用户成功", user, null);
		} catch (Exception e) {
			responseMap = responsePWFactory.responseMap("false", "查询用户失败", null, null);
		}
		log.info(responseMap);// 此信息将打印到日志
		log.error("error");
		return responseMap;
	}

	/**
	 * @author wxp 用户登录
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/t_user/Login", produces = "text/json;charset=UTF-8")
	public String login(String account, String password) {
		String responseMap = "";
		try {
			TUser tUser = new TUser();
			tUser.setAccount(account);
			tUser.setPassword(password);
			TUser user = ts.findOnlyUser(tUser);
			if (user == null || user.equals("")) {
				responseMap = responsePWFactory.responseMap("false", "用户登录失败", null, null);
			} else {
				System.out.println(user);
				List<Object> list = new ArrayList<>();
				list.add(user);
				responseMap = responsePWFactory.responseMap("true", "用户登录成功", list, null);
			}
		} catch (Exception e) {
			responseMap = responsePWFactory.responseMap("false", "用户登录失败", null, null);
		}
		log.info(responseMap);// 此信息将打印到日志
		return responseMap;
	}

	/**
	 * @author wxp 用户注册
	 *         url:http://192.168.0.160:8080/RFIDAssets/t_user/RegisterUserInfo
	 */
	@ResponseBody
	@RequestMapping(value = "/t_user/RegisterUserInfo", produces = "text/json;charset=UTF-8")
	public String registeruser(String account, String user_Name, String password, String role, String department,
			String phone, String mail) {
		String responseMap = "";
		int goBack = 0;
		try {
			TUser tUser = new TUser();
			tUser.setAccount(account);
			tUser.setUser_Name(user_Name);
			tUser.setPassword(password);
			tUser.setRole(Integer.parseInt(role));
			tUser.setDepartment(department);
			tUser.setPhone(phone);
			tUser.setMail(mail);
			goBack = ts.AddUserInfo(tUser);
			responseMap = responsePWFactory.responseMap("true", "用户注册成功", goBack, null);
		} catch (Exception e) {
			// TODO: handle exception
			responseMap = responsePWFactory.responseMap("false", "用户注册失败", goBack, null);
		}
		System.out.println(responseMap);
		log.info(responseMap);// 此信息将打印到日志
		return responseMap;
	}

	/**
	 * @author wxp 用户修改信息
	 */
	@ResponseBody
	@RequestMapping(value = "/t_user/UpdateUserInfo", produces = "text/json;charset=UTF-8")
	public String updateUserInfo(String account, String user_Name, String password, String role, String department,
			String phone, String mail) {
		String responseMap = "";
		int goBack = 0;
		try {
			TUser tUser = new TUser();
			tUser.setAccount(account);
			tUser.setUser_Name(user_Name);
			tUser.setPassword(password);
			tUser.setRole(Integer.parseInt(role));
			tUser.setDepartment(department);
			tUser.setPhone(phone);
			tUser.setMail(mail);
			goBack = ts.updateUserInfo(tUser);
			responseMap = responsePWFactory.responseMap("true", "用户修改信息成功", goBack, null);
		} catch (Exception e) {
			// TODO: handle exception
			responseMap = responsePWFactory.responseMap("false", "用户修改信息成功", goBack, null);
		}
		System.out.println(responseMap);
		log.info(responseMap);// 此信息将打印到日志
		return responseMap;
	}

	/**
	 * @author wxp 用户信息删除
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/t_user/deleteUserInfo", produces = "text/json;charset=UTF-8")
	public String deleteUserInfo(String account) {
		String responseMap = "";
		try {
			int goBack = ts.deleteUserInfo(account);
			responseMap = responsePWFactory.responseMap("true", "删除用户成功", goBack, null);
		} catch (Exception e) {
			responseMap = responsePWFactory.responseMap("false", "删除用户失败", null, null);
		}
		log.info(responseMap);// 此信息将打印到日志
		return responseMap;
	}
	
	/**
	 * @author wxp 用户信息删除
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/t_user/deleteUserInfoTest", produces = "text/json;charset=UTF-8")
	public String deleteUserInfoTest(String account) {
		String responseMap = "";
		try {
			responseMap = responsePWFactory.responseMap("true", "删除用户成功", account, null);
		} catch (Exception e) {
			responseMap = responsePWFactory.responseMap("false", "删除用户失败", null, null);
		}
		log.info(responseMap);// 此信息将打印到日志
		return responseMap;
	}


}
