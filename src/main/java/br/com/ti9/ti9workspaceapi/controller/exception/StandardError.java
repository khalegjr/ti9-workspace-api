package br.com.ti9.ti9workspaceapi.controller.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StandardError implements Serializable {

  private LocalDateTime timestamp;
  private Integer status;
  private String error;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String message;
  private String path;

}
