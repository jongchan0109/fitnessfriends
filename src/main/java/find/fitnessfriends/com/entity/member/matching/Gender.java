package find.fitnessfriends.com.entity.member.matching;

import lombok.Getter;

@Getter
public enum Gender {
    MALE("남성"), FEMALE("여성");

    private final String description;

    Gender(String description) {
        this.description = description;
    }

    public static Gender fromValue(String value) {
        // 클라이언트에서 받은 값을 변환
        return switch (value.toLowerCase()) {
            case "male" -> MALE;
            case "female" -> FEMALE;
            default -> throw new IllegalArgumentException("Invalid value: " + value);
        };
    }
}
