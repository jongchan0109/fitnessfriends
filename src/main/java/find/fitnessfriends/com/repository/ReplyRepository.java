package find.fitnessfriends.com.repository;

import find.fitnessfriends.com.entity.board.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
