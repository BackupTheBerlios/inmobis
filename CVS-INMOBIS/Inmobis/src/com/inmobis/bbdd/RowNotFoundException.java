package com.inmobis.bbdd;

public class RowNotFoundException extends Exception {
  public RowNotFoundException() {
    super();
  }
  public RowNotFoundException(String message) {
    super(message);
  }
}
