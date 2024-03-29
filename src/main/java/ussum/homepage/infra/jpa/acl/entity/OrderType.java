package ussum.homepage.infra.jpa.acl.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ussum.homepage.global.error.exception.InvalidValueException;

import java.util.Arrays;

import static ussum.homepage.global.error.status.ErrorStatus.INVALID_ORDER;

@RequiredArgsConstructor
@Getter
public enum OrderType {
    TARGET("target"),
    Type("type");
    private final String stringOrder;
    public static OrderType getEnumOrderFromStringOrder(String stringOrder) {
        return Arrays.stream(values())
                .filter(order -> order.stringOrder.equals(stringOrder))
                .findFirst()
                .orElseThrow(() -> new InvalidValueException(INVALID_ORDER));
    }
}
