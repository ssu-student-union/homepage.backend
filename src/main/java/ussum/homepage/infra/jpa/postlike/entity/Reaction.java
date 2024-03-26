package ussum.homepage.infra.jpa.postlike.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ussum.homepage.infra.jpa.user.entity.MajorCode;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Reaction {
    LIKE("like"),
    UNLIKE("unlike");
    private final String stringReaction;
    public static Reaction getEnumRactionFromStringReaction(String stringReaction) {
        return Arrays.stream(values())
                .filter(reaction -> reaction.stringReaction.equals(stringReaction))
                .findFirst()
                .orElseThrow(() -> new InvalidValueException(INVALID_REACTION));
    }
}
