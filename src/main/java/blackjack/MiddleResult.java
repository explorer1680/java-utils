package blackjack;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MiddleResult {
    private Status status;
    private int sum;
}
