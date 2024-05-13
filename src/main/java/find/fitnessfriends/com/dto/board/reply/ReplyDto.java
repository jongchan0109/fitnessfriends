package find.fitnessfriends.com.dto.board.reply;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyDto {

    @NotBlank(message = "내용을 입력해주세요")
    private String content;
}
