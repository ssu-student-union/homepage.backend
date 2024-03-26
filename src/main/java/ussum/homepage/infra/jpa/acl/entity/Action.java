package ussum.homepage.infra.jpa.acl.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

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
//                .orElseThrow(() -> new InvalidValueException(INVALID_ACTION));
    }
}
