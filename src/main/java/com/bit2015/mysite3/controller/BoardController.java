package com.bit2015.mysite3.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2015.mysite3.service.BoardService;
import com.bit2015.mysite3.vo.BoardVo;
import com.bit2015.mysite3.vo.ReplyVo;
import com.bit2015.mysite3.vo.UserVo;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/board/list")
	public String list(Model model, @RequestParam(defaultValue="1") long page, @ModelAttribute BoardVo boardVo){
		
		List<BoardVo> list = boardService.getList(page);
		model.addAttribute("list", list);
		long total = list.get(0).getTotcnt();
		int totalBlock = (int) Math.ceil(total/10.);
		model.addAttribute("total", totalBlock);
		model.addAttribute("page", page);
		
		return "/board/boardlistform";
	}
	@RequestMapping("/board/view")
	public String view(Model model, @RequestParam long no){
		BoardVo vo = boardService.getView(no);
		boardService.hit(no);
		model.addAttribute("vo", vo);
		
		List<ReplyVo> list = boardService.replyList(no);
		model.addAttribute("reply", list);

		
		return "/board/boardviewform";
	}
	@RequestMapping("/board/addform")
	public String insert(){
		return "/board/boardform";
		
	}
	@RequestMapping("/board/add")
	public String insert(HttpSession session, @ModelAttribute BoardVo vo, @RequestParam String title, @RequestParam String message){
		UserVo vo1 = (UserVo)session.getAttribute("authUser");
		vo.setName(vo1.getName());
		vo.setUser_no(vo1.getNo());
		vo.setHit(vo.getHit());
		vo.setTitle(title);
		vo.setMessage(message);
		boardService.insert(vo);
		return "redirect:/board/list";
		
	}
	@RequestMapping("/board/delete")
	public String delete(HttpSession session ,@RequestParam long no){
		UserVo vo = (UserVo)session.getAttribute("authUser");
		long user_no = vo.getNo();
		boardService.delete(no, user_no);
		
		return "redirect:/board/list";
	}
	@RequestMapping("/board/modifyform")
	public String modifyFrom(Model model , @RequestParam long no){
		BoardVo vo = boardService.getView(no);
		model.addAttribute("vo", vo);
		
		return "/board/modify";
		
	}
	@RequestMapping("/board/modify")
	public String modify(@RequestParam long no, @RequestParam String title, @RequestParam String message){
		BoardVo vo = boardService.getView(no);
		boardService.modify(title, message, vo.getHit(), vo.getNo(), vo.getUser_no());
		
		return"redirect:/board/list";
	}
	@RequestMapping("/board/search")
	public String search(Model model, @RequestParam(defaultValue="1") long page, @RequestParam String kwd){
		List<BoardVo> list = boardService.search(kwd,page);
		model.addAttribute("list", list);
		long total = list.get(0).getTotcnt();
		int totalBlock = (int) Math.ceil(total/10.);
		System.out.println(totalBlock);
		model.addAttribute("total", totalBlock);
		model.addAttribute("page", page);
		model.addAttribute("kwd", kwd);
		
		
		return "/board/boardlistform";
		
	}
	@RequestMapping("/board/reply")
	public String reply(HttpSession session, @RequestParam String name, @RequestParam String replymessage, @RequestParam long no, @RequestParam long order_no, @RequestParam long depth){
		UserVo vo = (UserVo)session.getAttribute("authUser");
		boardService.insert(no, vo.getNo(), name, replymessage, order_no, depth);
		
		return "redirect:/board/view?no="+no;
		
	}
	@RequestMapping("/board/rereply")
	public String rereply(HttpSession session, @RequestParam String name, @RequestParam String replymessage, @RequestParam long no, @RequestParam long group_no, @RequestParam long order_no, @RequestParam long depth){
		UserVo vo = (UserVo)session.getAttribute("authUser");
		boardService.insert(no, vo.getNo(), name, replymessage, group_no, order_no, depth);
		
		return "redirect:/board/view?no="+no;
	}
	@RequestMapping("/board/replydelete")
	public String replydelete(@RequestParam long no, @RequestParam long group_no, @RequestParam long order_no){
		boardService.replyDelete(no, group_no, order_no);
		return "redirect:/board/view?no="+no;
	}
	

}
