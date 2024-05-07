package find.fitnessfriends.com.service.member;

import find.fitnessfriends.com.entity.member.Member;
import find.fitnessfriends.com.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member joinProcess(String loginId, String password, String nickname) {

        //TODO 예외 처리

        Member member = new Member(loginId, password, nickname);
        return memberRepository.save(member);
    }

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

}
