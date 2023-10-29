package br.com.ti9.ti9workspaceapi.service.execption;

public class AuthenticationException extends RuntimeException {

  public AuthenticationException(String msg) {
    super(msg);
  }

  public AuthenticationException(String msg, Throwable cause) {
    super(msg, cause);
  }

}
