package find.fitnessfriends.com.controller;

import find.fitnessfriends.com.entity.board.Board;
import find.fitnessfriends.com.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final BoardRepository boardRepository;

    @GetMapping("/")
    public String home(Model model) {
        // 조회수가 높은 순으로 상위 6개의 게시물을 가져옴
        List<Board> boards = boardRepository.findTop6ByOrderByViewDesc();

        model.addAttribute("boards", boards);
        return "index";
    }
}
