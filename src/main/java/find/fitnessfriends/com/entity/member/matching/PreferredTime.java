package find.fitnessfriends.com.entity.member.matching;

import lombok.Getter;

@Getter
public enum PreferredTime {
    MORNING("아침"), AFTERNOON("점심"), EVENING("저녁");

    private final String description;

    PreferredTime(String description) {
        this.description = description;
    }

    public static PreferredTime fromValue(String value) {
        // 클라이언트에서 받은 값을 변환
        return switch (value.toLowerCase()) {
            case "morning" -> MORNING;
            case "afternoon" -> AFTERNOON;
            case "evening" -> EVENING;
            default -> throw new IllegalArgumentException("Invalid value: " + value);
        };
    }
}
