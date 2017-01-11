package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Member;
import boot.service.MemberService;



@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/members")
	public String home(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "members";
	}
	
	@GetMapping("/all-members")
	public String allMembers(HttpServletRequest request) {
		request.setAttribute("members", memberService.findAll());
		request.setAttribute("mode", "MODE_MEMBERS");
		return "members";
	}
	
	@GetMapping("/new-member")
	public String newMember(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "members";
	}

	
	@PostMapping("/save-member")
	public String saveMember(@ModelAttribute Member member, 
			BindingResult bindingResult, HttpServletRequest request) {
		memberService.save(member);
		request.setAttribute("members", memberService.findAll());
		request.setAttribute("mode", "MODE_MEMBERS");		
		return "members";
	}
	
	@GetMapping("/update-member")
	public String updateMember(@RequestParam int id, HttpServletRequest request) {
	request.setAttribute("member", memberService.finOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "members";
	}	
	
	
	@GetMapping("/delete-member")
	public String deleteMember(@RequestParam int id, HttpServletRequest request) {
		memberService.delete(id);
	request.setAttribute("members",memberService.findAll());
		request.setAttribute("mode", "MODE_MEMBERS");
		return "members";
	}
}
