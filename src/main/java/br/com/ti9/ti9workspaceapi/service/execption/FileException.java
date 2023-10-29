package br.com.ti9.ti9workspaceapi.service.execption;

public class FileException extends RuntimeException {

  public FileException(String msg) {
    super(msg);
  }

  public FileException(String msg, Throwable cause) {
    super(msg, cause);
  }

}
