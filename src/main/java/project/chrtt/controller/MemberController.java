package project.chrtt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.chrtt.domain.Mem;
import project.chrtt.service.MemberService;

import javax.validation.Valid;

@Controller
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/add")
    public String addForm(@ModelAttribute("member") Mem member){
        return "members/addMemberForm";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("member") Mem member, BindingResult result) {
        if (result.hasErrors()) {
            return "members/addMemberForm";
        }
        memberService.save(member);
        return "redirect:/";
    }
}
