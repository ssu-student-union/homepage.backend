package ussum.homepage.infra.jpa.acl.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Target {
    EVERYONE("everyone"),
    ANONYMOUS("anonymous");
    private final String stringTarget;
    public static Target getEnumTargetFromStringTarget(String stringTarget) {
        return Arrays.stream(values())
                .filter(target -> target.stringTarget.equals(stringTarget))
                .findFirst()
                .orElseThrow(() -> new InvalidValueException(INVALID_TARGET));
    }
}
