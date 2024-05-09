package find.fitnessfriends.com.repository;

import find.fitnessfriends.com.entity.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findTop6ByOrderByViewDesc();
}
