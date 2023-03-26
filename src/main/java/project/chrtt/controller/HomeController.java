package project.chrtt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import project.chrtt.domain.Mem;
import project.chrtt.repository.mybatis.MemberMapper;
import project.chrtt.service.MemberService;
import project.chrtt.web.SessionConst;
import project.chrtt.web.SessionManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final MemberMapper memberMapper;
    private final SessionManager sessionManager;

    public HomeController(MemberMapper memberMapper, SessionManager sessionManager) {
        this.memberMapper = memberMapper;
        this.sessionManager = sessionManager;
    }

    //@GetMapping("/")
    public String home() {
        return "home";
    }

    /**
     * @GetMapping("/") public String homeLogin(@CookieValue(name = "memberId", required = false) String memberId, Model model) {
     * if (memberId == null) {
     * return "home";
     * }
     * <p>
     * Mem loginMember = memberMapper.findById(String.valueOf(memberId));
     * <p>
     * //로그인 했어도 해당 사용자가 없으면 home으로 보내기
     * if (loginMember == null) {
     * return "home";
     * }
     * model.addAttribute("member", loginMember);
     * return "signInHome";
     * }
     **/

    /**
     @GetMapping("/") public String homeLoginV2(HttpServletRequest request, Model model) {
     //세션 관리자에 저장된 회원 정보 조회
     Mem member = (Mem) sessionManager.getSession(request);
     if (member == null) {
     return "home";
     }
     //로그인
     model.addAttribute("member", member);
     return "signInHome";
     } **/

    /**
     * @GetMapping("/") public String homeLogin(HttpServletRequest request, Model model) {
     * //세션이 없으면 home
     * HttpSession session = request.getSession(false);
     * <p>
     * if (session == null) {
     * return "home";
     * }
     * <p>
     * Mem loginMember = (Mem)session.getAttribute(SessionConst.LOGIN_MEMBER);
     * //세션에 회원 데이터가 없으면 home
     * if (loginMember == null) {
     * return "home";
     * }
     * <p>
     * //세션이 유지되면 로그인으로 이동
     * model.addAttribute("member", loginMember);
     * return "signInHome";
     * }
     **/

    @GetMapping("/")
    public String homeSignIn( @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)
            Mem signInMember,
            Model model) {
        //세션에 회원 데이터가 없으면 home
        if (signInMember == null) {
            return "home";
        }


        //세션이 유지되면 로그인으로 이동
        model.addAttribute("member", signInMember);
        String isManager = signInMember.getMIsmanager();
        if (isManager.equals("1")){
            return "signInManagerHome";
        }

        return "signInHome";
}
}
