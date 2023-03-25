package project.chrtt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import project.chrtt.domain.Mem;
import project.chrtt.repository.mybatis.MemberMapper;
import project.chrtt.service.MemberService;

@Controller
public class HomeController {

    private final MemberMapper memberMapper;

    public HomeController(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    //@GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/")
    public String homeLogin(@CookieValue(name = "memberId", required = false) String memberId, Model model) {
        if (memberId == null) {
            return "home";
        }

        Mem loginMember = memberMapper.findById(String.valueOf(memberId));

        //로그인 했어도 해당 사용자가 없으면 home으로 보내기
        if (loginMember == null) {
            return "home";
        }
        model.addAttribute("member", loginMember);
        return "signInHome";
    }

}
