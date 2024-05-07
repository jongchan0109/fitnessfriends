package find.fitnessfriends.com.repository;

import find.fitnessfriends.com.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
