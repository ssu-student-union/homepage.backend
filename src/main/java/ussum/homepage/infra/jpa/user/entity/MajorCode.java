package ussum.homepage.infra.jpa.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ussum.homepage.global.error.exception.InvalidValueException;

import java.util.Arrays;

import static ussum.homepage.global.error.status.ErrorStatus.INVALID_MAJORCODE;

@RequiredArgsConstructor
@Getter
public enum MajorCode {
    IT("IT"),
    ET("ET");
    private final String stringMajorCode;
    public static MajorCode getEnumMajorCodeFromStringMajorCode(String stringMajorCode) {
        return Arrays.stream(values())
                .filter(majorCode -> majorCode.stringMajorCode.equals(stringMajorCode))
                .findFirst()
                .orElseThrow(() -> new InvalidValueException(INVALID_MAJORCODE));
    }
}
