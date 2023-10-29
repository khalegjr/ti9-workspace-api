package br.com.ti9.ti9workspaceapi.service.execption;

public class AlreadyExistsException extends RuntimeException {

  public AlreadyExistsException(String msg) {
    super(msg);
  }

  public AlreadyExistsException(String msg, Throwable cause) {
    super(msg, cause);
  }

}
