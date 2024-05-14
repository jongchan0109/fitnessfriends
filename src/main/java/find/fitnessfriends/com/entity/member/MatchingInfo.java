package find.fitnessfriends.com.entity.member;

import find.fitnessfriends.com.entity.member.matching.Ability;
import find.fitnessfriends.com.entity.member.matching.Gender;
import find.fitnessfriends.com.entity.member.matching.PreferredTime;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MatchingInfo {

    Ability ability;
    Gender gender;
    PreferredTime preferredTime;

}
