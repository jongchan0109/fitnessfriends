package find.fitnessfriends.com.service.member;

import find.fitnessfriends.com.entity.member.MatchingInfo;
import find.fitnessfriends.com.entity.member.Member;
import find.fitnessfriends.com.entity.member.matching.Ability;
import find.fitnessfriends.com.entity.member.matching.Gender;
import find.fitnessfriends.com.entity.member.matching.PreferredTime;
import find.fitnessfriends.com.exception.member.DuplicatedLoginIdException;
import find.fitnessfriends.com.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public Member joinProcess(String loginId, String password, String nickname) {

        boolean exists = memberRepository.existsByLoginId(loginId);

        if (exists) {
            throw new DuplicatedLoginIdException("중복된 사용자입니다.");
        }

        Member member = new Member(loginId, password, nickname);
        return memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public Member loginProcess(String loginId, String password) {

        Member loginMember = memberRepository.findByLoginId(loginId);

        if (loginMember == null) {
            return null;
        }
        if (!loginMember.getPassword().equals(password)) {
            return null;
        }

        return loginMember;
    }

    @Transactional(readOnly = true)
    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("없는 사용자입니다."));
    }

    public Member editProcess(Long id, String loginId, String password, String nickname) {

        boolean exists = memberRepository.existsByLoginId(loginId);

        if (exists) {
            throw new DuplicatedLoginIdException("중복된 사용자입니다.");
        }
        Member member = findById(id);
        member.edit(loginId, password, nickname);
        return member;
    }

    public void matchingInfoUpdateProcess(Long id, Ability ability, Gender gender, PreferredTime preferredTime,
                                          Ability oppAbility, Gender oppGender, PreferredTime oppPreferredTime) {
        Member member = findById(id);
        MatchingInfo matchingInfo = new MatchingInfo(ability, gender, preferredTime);
        MatchingInfo oppMatchingInfo = new MatchingInfo(oppAbility, oppGender, oppPreferredTime);

        member.updateMatchingInfo(matchingInfo, oppMatchingInfo);
    }

}
