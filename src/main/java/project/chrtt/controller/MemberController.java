package project.chrtt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.chrtt.domain.Mem;
import project.chrtt.service.MemberService;
import project.chrtt.web.SessionConst;
import project.chrtt.web.SessionManager;
import project.chrtt.web.SignInForm;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService, SessionManager sessionManager) {
        this.memberService = memberService;
    }

    // sign up
    @GetMapping("/add")
    public String addForm(@ModelAttribute("member") Mem member) {
        return "members/signUpForm";
    }

    @PostMapping("/add")
    public String signUp(@Valid @ModelAttribute("member") Mem member, BindingResult result) {
        if (result.hasErrors()) {
            return "members/signUpForm";
        }
        memberService.signUp(member);
        return "redirect:/";
    }

    // sign in
    @GetMapping("/signin")
    public String signInForm(@ModelAttribute("signInForm") SignInForm form) {
        return "members/signInForm";
    }

    @PostMapping("/signin")
    public String signIn(@Valid @ModelAttribute("signInForm") SignInForm form, BindingResult bindingResult,
                         HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "members/signInForm";
        }
        Mem signInMember = memberService.signIn(form.getLogId(), form.getLogPw());

        if (signInMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "members/signInForm";
        }

        //로그인 성공 처리
        //쿠키에 시간 정보를 주지 않으면 세션 쿠키(브라우저 종료시 모두 종료)

        /**
        * Cookie idCookie = new Cookie("memberId", signInMember.getLogId());
        * idCookie.setPath("/");
        * response.addCookie(idCookie);
        **/

        //세션 관리자를 통해 세션을 생성하고, 회원 데이터 보관
        /**
        sessionManager.createSession(signInMember, response);
        **/

        //세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
        HttpSession session = request.getSession(); //세션에 로그인 회원 정보 보관
        session.setAttribute(SessionConst.LOGIN_MEMBER, signInMember);

        return "redirect:/";
    }

    @PostMapping("/signout")
    public String signOut(HttpServletRequest request) {
        //세션을 삭제한다.
        HttpSession session = request.getSession(false); if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
