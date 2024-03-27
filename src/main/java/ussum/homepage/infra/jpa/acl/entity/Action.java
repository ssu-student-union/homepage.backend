package ussum.homepage.infra.jpa.acl.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ussum.homepage.global.error.exception.InvalidValueException;

import java.util.Arrays;

import static ussum.homepage.global.error.status.ErrorStatus.INVALID_ACTION;

@RequiredArgsConstructor
@Getter
public enum Action {
    LIST("list"),
    EDIT("edit"),
    READ("read"),
    EDIT_PROPERTIES("edit_properties"),
    DELETE("delete"),
    COMMENT("comment"),
    REACTION("reaction");
    private final String stringAction;
    public static Action getEnumActionFromStringAction(String stringAction) {
        return Arrays.stream(values())
                .filter(order -> order.stringAction.equals(stringAction))
                .findFirst()
                .orElseThrow(() -> new InvalidValueException(INVALID_ACTION));
    }
}
