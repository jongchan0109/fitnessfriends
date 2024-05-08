package find.fitnessfriends.com.controller.board;

import find.fitnessfriends.com.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("")
    public String boardHome(Model model, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("boards", boardService.boards(pageable));
        return "board/boardHome";
    }

    @GetMapping("/writeForm")
    public String writeForm() {
        return "board/writeForm";
    }


}
