package br.com.ti9.ti9workspaceapi.service.execption;

public class AuthorizationException extends RuntimeException {

  public AuthorizationException(String msg) {
    super(msg);
  }

  public AuthorizationException(String msg, Throwable cause) {
    super(msg, cause);
  }

}
