package com.bit2015.mysite3.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2015.mysite3.service.UserService;
import com.bit2015.mysite3.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/joinform")
	public String joinform(){
		return "user/joinform";
	}
	
	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo userVo){
		userService.join(userVo);
		return "redirect:/user/joinsuccess";

	}
	@RequestMapping("/joinsuccess")
	public String joinSuccess(){
		return "user/joinsuccess";

	}
	@RequestMapping("/loginform")
	public String loginForm(){
		return "user/loginform";

	}
	@RequestMapping("/login")
	public String login(HttpSession session, @ModelAttribute UserVo userVo){
		UserVo vo = userService.login(userVo);
		if(vo==null){
			return "redirect:/user/loginform";
		}
		//로긴처리
		session.setAttribute("authUser", vo);
		return "redirect:/";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}
	@RequestMapping("/modifyform")
	public String modifyform(){
		return "user/modifyform";
	}
	@RequestMapping("/domodify")
	public String domodify(HttpSession session ,@RequestParam String password){
		UserVo vo = (UserVo)session.getAttribute("authUser");
		String pass1 = userService.get(vo);
		System.out.println(pass1);
		if(password.equals(pass1)){
			return "user/domodify";
		}else{
			return "user/modifyform";
		}
		
	}
	@RequestMapping("/modify")
	public String modify(HttpSession session ,@RequestParam String password1, @RequestParam String password2){
		if(password1.equals(password2)){
			UserVo vo = (UserVo)session.getAttribute("authUser");
			userService.update(password1 ,vo);
			return "redirect:/";
		}else{
			return "user/modifyform";
		}
	}
	@RequestMapping("/checkemail")
	@ResponseBody
	public Object checkemail(@RequestParam String email){
		UserVo vo = null;
		vo = userService.getEmail(email);
		Map<String,String> map = new HashMap<String, String>();
		if(vo ==null){
			map.put("result", "not exist");
		}else{
			map.put("result", "exist");
		}
			return map;
	}
}
