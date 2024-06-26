package find.fitnessfriends.com.service.board.reply;

import find.fitnessfriends.com.entity.board.Board;
import find.fitnessfriends.com.entity.board.Reply;
import find.fitnessfriends.com.entity.member.Member;
import find.fitnessfriends.com.repository.ReplyRepository;
import find.fitnessfriends.com.service.board.BoardService;
import find.fitnessfriends.com.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class ReplyService {

    private final BoardService boardService;
    private final MemberService memberService;
    private final ReplyRepository replyRepository;


    public void writeProcess(Long boardId, Long memberId, String content) {
        Board board = boardService.findById(boardId);
        Member member = memberService.findById(memberId);

        Reply reply = new Reply(board, member, content);
        replyRepository.save(reply);

    }

    public void deleteProcess(Long replyId) {
        Reply reply = findById(replyId);
        reply.getBoard().getReplies().remove(reply);
        replyRepository.delete(reply);
    }

    @Transactional(readOnly = true)
    public Reply findById(Long id) {
        return replyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다."));
    }

}
