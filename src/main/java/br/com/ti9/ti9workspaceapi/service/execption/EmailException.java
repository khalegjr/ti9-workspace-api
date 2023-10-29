package br.com.ti9.ti9workspaceapi.service.execption;

public class EmailException extends RuntimeException {

  public EmailException(String msg) {
    super(msg);
  }

  public EmailException(String msg, Throwable cause) {
    super(msg, cause);
  }

}
