package com.springmvc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.entity.User;
import com.springmvc.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserAction {
	@Autowired
	private UserService userService;
	
	@RequestMapping("add.action")
	public String addUser(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name=request.getParameter("user.name");
		String pwd=request.getParameter("user.pwd");
		String zip=request.getParameter("user.zip");
		String addr=request.getParameter("user.addr");
		String phone=request.getParameter("user.phone");
		String email=request.getParameter("user.email");
		User user=new User();
		user.setName(name);
		user.setAddr(addr);
		user.setEmail(email);
		user.setZip(zip);
		user.setPhone(phone);
		user.setPwd(pwd);
		userService.addUser(user);
		return "redirect:/user/select.action";
	}
	@RequestMapping("addform.action")
	public String addForm(){
		return "addform";
	}
	@RequestMapping("select.action")
	public String selectUser(HttpServletRequest request,HttpServletResponse response){
		List<User> list=userService.findAllUser();
		request.setAttribute("userlist", list);
		return "userlist";
	}
	@RequestMapping("delete.action")
	public String delete(HttpServletRequest request,HttpServletResponse response){
		String ids=request.getParameter("id");
		userService.deleteUser(ids);
		//重定向到用户列表
		return "redirect:/user/select.action";  
	}
}
