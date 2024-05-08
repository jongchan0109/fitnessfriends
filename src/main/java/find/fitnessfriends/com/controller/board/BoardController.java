package find.fitnessfriends.com.controller.board;

import find.fitnessfriends.com.dto.board.WriteDto;
import find.fitnessfriends.com.entity.board.Board;
import find.fitnessfriends.com.entity.member.Member;
import find.fitnessfriends.com.service.board.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/write")
    public String write(@ModelAttribute WriteDto writeDto, BindingResult bindingResult, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "board/writeForm";
        }

        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("loginMember");

        Board board = boardService.write(writeDto.getTitle(), writeDto.getContent(), member);

        return "redirect:/board";
    }


}
