package com.bit2015.mysite3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2015.mysite3.dao.GuestBookDao;
import com.bit2015.mysite3.vo.GuestBookVo;

@Controller

public class GuestBookController {
	@Autowired
	private GuestBookDao guestListDao;
	
	@RequestMapping("/guestbook")
	public String index(Model model){
			List<GuestBookVo> list = guestListDao.getList();
			model.addAttribute("list", list);
			
		return "/guestbook/index";
	}
	
	@RequestMapping("/guestbook/add")
	public String add(@ModelAttribute GuestBookVo guestBookVo){
			guestListDao.insert(guestBookVo);
		return"redirect:/guestbook/";
	}
	
	@RequestMapping("/guestbook/deleteform")
	public String deleteform(){
		return "/guestbook/deleteform";
	}
	@RequestMapping("/guestbook/delete")
	public String delete(@RequestParam long no){
		System.out.println(no);
		guestListDao.delete(no);
		return "redirect:/guestbook/";
	}

}
