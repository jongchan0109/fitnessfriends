package find.fitnessfriends.com.entity.board;

import find.fitnessfriends.com.entity.board.Board;
import find.fitnessfriends.com.entity.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "boardId")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    @CreationTimestamp
    private Timestamp createDate;

    public Reply(Board board, Member member, String content) {
        this.content = content;
        this.board = board;
        this.member = member;
        this.board.getReplies().add(this);
    }
}
