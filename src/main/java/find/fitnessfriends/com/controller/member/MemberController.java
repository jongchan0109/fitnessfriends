package find.fitnessfriends.com.controller.member;

import find.fitnessfriends.com.dto.member.EditDto;
import find.fitnessfriends.com.dto.member.JoinDto;
import find.fitnessfriends.com.dto.member.LoginDto;
import find.fitnessfriends.com.entity.member.Member;
import find.fitnessfriends.com.exception.member.DuplicatedLoginIdException;
import find.fitnessfriends.com.service.member.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/joinForm")
    public String joinForm() {
        return "member/joinForm";
    }

    @PostMapping("/join")
    public String join(@Validated @ModelAttribute JoinDto joinDto, BindingResult bindingResult, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "member/joinForm";
        }

        Member loginMember;
        try {
            loginMember = memberService.joinProcess(joinDto.getLoginId(), joinDto.getPassword(), joinDto.getNickname());
        } catch (DuplicatedLoginIdException e) {
            bindingResult.reject("loginId.duplicated", "중복된 id 입니다.");
            return "member/joinForm";
        }
        HttpSession session = request.getSession();
        session.setAttribute("loginMember", loginMember);

        return "redirect:/";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "member/loginForm";
    }

    @PostMapping("/login")
    public String login(@Validated @ModelAttribute LoginDto loginDto, BindingResult bindingResult,
                        HttpServletRequest request, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "member/loginForm";
        }

        Member loginMember = memberService.loginProcess(loginDto.getLoginId(), loginDto.getPassword());

        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다");
            return "member/loginForm";
        }

        HttpSession session = request.getSession();
        session.setAttribute("loginMember", loginMember);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

    @GetMapping("/editForm/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        Member member = memberService.findById(id);
        model.addAttribute("member", member);
        return "member/editForm";
    }

    @PostMapping("/editForm/{id}")
    public String edit(@PathVariable("id") Long id, @Validated @ModelAttribute EditDto editDto, BindingResult bindingResult, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "member/editForm";
        }

        Member member;
        try {
            member = memberService.editProcess(id, editDto.getLoginId(), editDto.getPassword(), editDto.getNickname());
        } catch (DuplicatedLoginIdException e) {
            bindingResult.reject("editDto.duplicated", "중복된 id 입니다.");
            return "member/joinForm";
        }
        HttpSession session = request.getSession();
        session.setAttribute("loginMember", member);

        return "redirect:/";
    }

}
