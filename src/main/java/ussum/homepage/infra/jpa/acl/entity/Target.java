package ussum.homepage.infra.jpa.acl.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ussum.homepage.global.error.exception.InvalidValueException;
import ussum.homepage.global.error.status.ErrorStatus;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Target {
    EVERYONE("EVERYONE"),
    ANONYMOUS("ANONYMOUS");
    private final String stringTarget;
    public static Target getEnumTargetFromStringTarget(String stringTarget) {
        return Arrays.stream(values())
                .filter(target -> target.stringTarget.equals(stringTarget))
                .findFirst()
                .orElseThrow(() -> new InvalidValueException(ErrorStatus.INVALID_TARGET));
    }
}
