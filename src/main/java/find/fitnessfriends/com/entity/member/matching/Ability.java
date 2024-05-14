package find.fitnessfriends.com.entity.member.matching;

import lombok.Getter;

@Getter
public enum Ability {
    BEGIN("초급"), MIDDLE("중급"), MASTER("고급");

    private final String description;

    Ability(String description) {
        this.description = description;
    }

    public static Ability fromValue(String value) {
        // 클라이언트에서 받은 값을 변환
        return switch (value.toLowerCase()) {
            case "begin" -> BEGIN;
            case "middle" -> MIDDLE;
            case "master" -> MASTER;
            default -> throw new IllegalArgumentException("Invalid value: " + value);
        };
    }
}
