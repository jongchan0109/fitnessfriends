package find.fitnessfriends.com.repository;

import find.fitnessfriends.com.entity.member.Member;
import find.fitnessfriends.com.entity.member.matching.Ability;
import find.fitnessfriends.com.entity.member.matching.Gender;
import find.fitnessfriends.com.entity.member.matching.PreferredTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByLoginId(String loginId);
    boolean existsByLoginId(String loginId);

    List<Member> findByOppMatchingInfo_AbilityAndOppMatchingInfo_GenderAndOppMatchingInfo_PreferredTime(
            Ability ability, Gender gender, PreferredTime preferredTime);
}
