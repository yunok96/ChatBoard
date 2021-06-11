package com.spring.board2.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.board2.model.MemberVO;
import com.spring.board2.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping("/index")
	public String mainPage() {
		return "main";
	}
	
	@PostMapping("/login")
	@ResponseBody
	public String loginMember(MemberVO memberVO, HttpSession session) throws Exception {
		
		String result;
		MemberVO selectedMember = service.selectMember(memberVO.getEmail());
		if(selectedMember.getPassword().equals(memberVO.getPassword())) {
			System.out.println("비밀번호 일치");
			session.setAttribute("member", selectedMember);
			result = "로그인";
		} else {
			System.out.println("불일치");
			result = "비밀번호 오류";
		}
		
		return result;
	}
	
	@GetMapping("/logout")
	@ResponseBody
	public String logoutMember(HttpSession session) throws Exception {
		String result = "로그아웃 실패";
		if(session.getAttribute("member") != null) {
			session.removeAttribute("member");
			result = "로그아웃 성공";
		}
		return result;
	}
	
	@RequestMapping("/signin")
	public String createMemberPage() throws Exception {
		return "signin";
	}
	
	@PostMapping("/signinresult")
	public String createMemberResultPage(MemberVO memberVO, Model model) throws Exception {
		int result = service.insertMember(memberVO);
		if(result == 1) {
			model.addAttribute("msg", "가입 성공");
		} else {
			model.addAttribute("msg", "오류 발생");
		}
		model.addAttribute("href", "index");
		return "alert";
	}
	
}
