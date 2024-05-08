package find.fitnessfriends.com.service.member;

import find.fitnessfriends.com.entity.member.Member;
import find.fitnessfriends.com.exception.member.DuplicatedLoginIdException;
import find.fitnessfriends.com.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
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
