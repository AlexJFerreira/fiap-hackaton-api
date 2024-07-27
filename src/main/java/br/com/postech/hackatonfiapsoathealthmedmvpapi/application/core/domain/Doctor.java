package br.com.postech.hackatonfiapsoathealthmedmvpapi.application.core.domain;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Doctor {
  private Integer id;
  private String name;
  private String email;
  private String password;
  private String crm;
  private String crmState;
  private String speciality;
  private LocalDateTime registrationDate;
}
