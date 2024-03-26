package ussum.homepage.infra.jpa.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Role {
    ADMIN("admin"),
    USER("user");
    private final String stringRole;
    public static Role getEnumRoleFromStringRole(String stringRole) {
        return Arrays.stream(values())
                .filter(role -> role.stringRole.equals(stringRole))
                .findFirst()
                .orElseThrow(() -> new InvalidValueException(INVALID_ROLE));
    }
}
