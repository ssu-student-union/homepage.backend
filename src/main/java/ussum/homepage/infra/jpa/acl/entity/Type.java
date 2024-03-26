package ussum.homepage.infra.jpa.acl.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ussum.homepage.infra.jpa.post.entity.BoardCode;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Type {
    ALLOW("allow"),
    DENY("deny");
    private final String stringType;
    public static Type getEnumTypeFromStringType(String stringType) {
        return Arrays.stream(values())
                .filter(type -> type.stringType.equals(stringType))
                .findFirst()
                .orElseThrow(() -> new InvalidValueException(INVALID_TYPE));
    }
}
