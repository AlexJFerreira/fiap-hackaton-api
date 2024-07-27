package br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRegistrationRequest {
  @NotBlank
  private String name;
  @NotBlank
  private String email;
  @NotBlank
  private String password;
  @NotBlank
  private String cpf;
}
