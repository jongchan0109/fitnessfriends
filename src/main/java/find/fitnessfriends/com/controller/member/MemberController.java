package find.fitnessfriends.com.controller.member;

import find.fitnessfriends.com.dto.member.JoinDto;
import find.fitnessfriends.com.entity.member.Member;
import find.fitnessfriends.com.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String join(@Validated @ModelAttribute JoinDto joinDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "member/joinForm";
        }

        memberService.joinProcess(joinDto.getLoginId(),joinDto.getPassword(), joinDto.getNickname());

        return "redirect:/";
    }
}
