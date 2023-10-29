package br.com.ti9.ti9workspaceapi.service.execption;

public class ValidationException extends RuntimeException {

  public ValidationException(String msg) {
    super(msg);
  }

  public ValidationException(String msg, Throwable cause) {
    super(msg, cause);
  }

}
