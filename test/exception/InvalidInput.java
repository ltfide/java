package exception;

import java.util.InputMismatchException;

public class InvalidInput extends RuntimeException {
  public InvalidInput(String message, Throwable e) {
    super(message, e);
  }
}