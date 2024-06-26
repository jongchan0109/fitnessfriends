package find.fitnessfriends.com.entity.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Entity
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "logoinId", length = 20)
    private String loginId;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "nickname", length = 20)
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Role role;

    @CreationTimestamp
    private Timestamp createdDate;

    @Embedded
    private MatchingInfo matchingInfo;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "ability", column = @Column(name = "oppAbility")),
            @AttributeOverride(name = "gender", column = @Column(name = "oppGender")),
            @AttributeOverride(name = "preferredTime", column = @Column(name = "oppPreferredTime"))
    })
    private MatchingInfo oppMatchingInfo;

    public Member(String loginId, String password, String nickname) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.role = Role.MEMBER;
    }

    public void edit(String loginId, String password, String nickname) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
    }

    public void updateMatchingInfo(MatchingInfo matchingInfo, MatchingInfo oppMatchingInfo) {
        this.matchingInfo = matchingInfo;
        this.oppMatchingInfo = oppMatchingInfo;
    }

}
