package exception;

import java.io.IOException;

public class NegativeBalanceException extends IOException {
    public NegativeBalanceException(String s) {
        super(s);
    }
}
