package find.fitnessfriends.com.controller.board;

import find.fitnessfriends.com.dto.board.UpdateDto;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

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
    public String write(@Validated @ModelAttribute WriteDto writeDto, BindingResult bindingResult, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "board/writeForm";
        }

        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("loginMember");

        Board board = boardService.write(writeDto.getTitle(), writeDto.getContent(), member);

        return "redirect:/board/detail/" + board.getId();
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model, HttpServletRequest request) {

        Board board = boardService.detail(id);
        model.addAttribute("board", board);
        HttpSession session = request.getSession();
        Member loginMember = (Member)session.getAttribute("loginMember");

        model.addAttribute("loginMember", loginMember);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedCreateDate = dateFormat.format(board.getCreatedDate());
        String formattedUpdateDate = dateFormat.format(board.getUpdateDate());

        model.addAttribute("formattedCreateDate", formattedCreateDate);
        model.addAttribute("formattedUpdateDate", formattedUpdateDate);

        return "board/detail";
    }

    @GetMapping("/updateForm/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        Board board = boardService.findById(id);
        model.addAttribute("board", board);
        return "board/updateForm";
    }


    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @Validated @ModelAttribute UpdateDto updateDto, BindingResult bindingResult, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "board/updateForm";
        }

        Board board = boardService.updateProcess(id, updateDto.getTitle(), updateDto.getContent());
        return "redirect:/board/detail/" + board.getId();
    }

}
