package br.com.ti9.ti9workspaceapi.service.execption;

public class DataNotFoundException extends RuntimeException {

  public DataNotFoundException(String msg) {
    super(msg);
  }

  public DataNotFoundException(String msg, Throwable cause) {
    super(msg, cause);
  }

}
