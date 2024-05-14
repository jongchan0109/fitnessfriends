package find.fitnessfriends.com.controller.member;

import find.fitnessfriends.com.entity.member.Member;
import find.fitnessfriends.com.entity.member.matching.Ability;
import find.fitnessfriends.com.entity.member.matching.Gender;
import find.fitnessfriends.com.entity.member.matching.PreferredTime;
import find.fitnessfriends.com.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/matching")
public class MatchingController {

    private final MemberService memberService;

    @ModelAttribute("abilities")
    public Ability[] getAbilities() {
        return Ability.values();
    }

    @ModelAttribute("genders")
    public Gender[] getGenders() {
        return Gender.values();
    }

    @ModelAttribute("preferredTimes")
    public PreferredTime[] getPreferredTimes() {
        return PreferredTime.values();
    }


    @GetMapping("/matchingInfoForm/{id}")
    public String matchingInfoForm(@PathVariable Long id, Model model) {
        Member member = memberService.findById(id);

        model.addAttribute("matchingInfo", member.getMatchingInfo());
        model.addAttribute("oppMatchingInfo", member.getOppMatchingInfo());
        model.addAttribute("member", member);

        return "/member/matching/matchingInfoForm";
    }

    @PostMapping("/matchingInfo/{id}")
    public String matchingInfo(@PathVariable Long id,
                               @RequestParam String ability,
                               @RequestParam String gender,
                               @RequestParam String preferredTime,
                               @RequestParam String oppAbility,
                               @RequestParam String oppGender,
                               @RequestParam String oppPreferredTime) {
        memberService.matchingInfoUpdateProcess(id,
                Ability.fromValue(ability),
                Gender.fromValue(gender),
                PreferredTime.fromValue(preferredTime),
                Ability.fromValue(oppAbility),
                Gender.fromValue(oppGender),
                PreferredTime.fromValue(oppPreferredTime));
        return "redirect:/";
    }


}
