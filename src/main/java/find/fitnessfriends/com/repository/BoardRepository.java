package find.fitnessfriends.com.repository;

import find.fitnessfriends.com.entity.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
