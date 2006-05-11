package com.inmobis.bbdd;

public class RowExistsException extends Exception {
  public RowExistsException() {
    super();
  }
  public RowExistsException(String message) {
    super(message);
  }
}