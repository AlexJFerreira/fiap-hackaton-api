package br.com.postech.hackatonfiapsoathealthmedmvpapi.application.core.domain;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Patient {
  private Integer id;
  private String name;
  private String email;
  private String password;
  private String cpf;
  private LocalDateTime registrationDate;
}
