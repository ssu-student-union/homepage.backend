package ussum.homepage.infra.jpa.acl.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Order {
    TARGET("target"),
    Type("type");
    private final String stringOrder;
    public static Order getEnumOrderFromStringOrder(String stringOrder) {
        return Arrays.stream(values())
                .filter(order -> order.stringOrder.equals(stringOrder))
                .findFirst()
//                .orElseThrow(() -> new InvalidValueException(INVALID_ORDER));
    }
}
