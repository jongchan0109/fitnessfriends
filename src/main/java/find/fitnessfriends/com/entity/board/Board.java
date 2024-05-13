package find.fitnessfriends.com.entity.board;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import find.fitnessfriends.com.entity.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Lob
    private String content;

    private Long view;

    @CreationTimestamp
    private Timestamp createdDate;

    @CreationTimestamp
    private Timestamp updateDate;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"board"})
    @OrderBy("id asc")
    private final List<Reply> replies = new ArrayList<>();

    public Board(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
        this.view = 0L;
    }

    public void look() {
        this.view++;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
        this.updateDate = new Timestamp(System.currentTimeMillis());
    }
}
