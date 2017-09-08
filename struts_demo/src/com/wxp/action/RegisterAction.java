package com.wxp.action;

import org.apache.struts2.ServletActionContext;

import com.wxp.domain.User;

public class RegisterAction {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() {
		// 为了区分，我们在后面多加了_first这个标记，以表明这是由Action1接收到的数据
		user.setUsername(user.getUsername() + "_first");
		user.setPassword(user.getPassword() + "_first");
		System.out.println(user);
		System.out.println("First User Hashcode = " + user.hashCode());
		// 存入提示信息，用于判断redirect，redirectAction，chain转发请求是否丢失数据
		ServletActionContext.getRequest().setAttribute("message", "注册成功！");
		return "success";
	}
}
