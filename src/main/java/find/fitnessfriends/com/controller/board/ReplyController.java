package find.fitnessfriends.com.controller.board;

import find.fitnessfriends.com.dto.board.reply.ReplyDto;
import find.fitnessfriends.com.entity.board.Board;
import find.fitnessfriends.com.entity.member.Member;
import find.fitnessfriends.com.service.board.BoardService;
import find.fitnessfriends.com.service.board.reply.ReplyService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class ReplyController {

    private final BoardService boardService;
    private final ReplyService replyService;

    @PostMapping("/{id}/reply")
    public String reply(@PathVariable Long id, @Validated @ModelAttribute ReplyDto replyDto, BindingResult bindingResult, Model model, HttpServletRequest request) {

        Board board = boardService.findById(id);
        model.addAttribute("board", board);
        HttpSession session = request.getSession();
        Member loginMember = (Member)session.getAttribute("loginMember");

        model.addAttribute("loginMember", loginMember);

        if (bindingResult.hasErrors()) {
            System.out.println("replyDto = " + replyDto.getContent());
            return "redirect:/board/detail/" + board.getId();
        }

        replyService.writeProcess(board.getId(),loginMember.getId(), replyDto.getContent());

        return "redirect:/board/detail/" + board.getId();
    }

    @PostMapping("/{id}/reply/delete/{replyId}")
    public String delete(@PathVariable Long id, @PathVariable Long replyId, HttpServletRequest request, Model model) {

        Board board = boardService.findById(id);
        model.addAttribute("board", board);
        HttpSession session = request.getSession();
        Member loginMember = (Member)session.getAttribute("loginMember");

        model.addAttribute("loginMember", loginMember);

        replyService.deleteProcess(replyId);

        return "redirect:/board/detail/" + board.getId();
    }

}
