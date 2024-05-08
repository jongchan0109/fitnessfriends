package find.fitnessfriends.com.service.board;

import find.fitnessfriends.com.entity.board.Board;
import find.fitnessfriends.com.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public Page<Board> boards(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }
}
