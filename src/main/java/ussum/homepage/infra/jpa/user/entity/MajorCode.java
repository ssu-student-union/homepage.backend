package ussum.homepage.infra.jpa.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum MajorCode {
    IT("it"),
    ET("et");
    private final String stringMajorCode;
    public static MajorCode getEnumMajorCodeFromStringMajorCode(String stringMajorCode) {
        return Arrays.stream(values())
                .filter(majorCode -> majorCode.stringMajorCode.equals(stringMajorCode))
                .findFirst()
                .orElseThrow(() -> new InvalidValueException(INVALID_MAJORCODE));
    }
}
