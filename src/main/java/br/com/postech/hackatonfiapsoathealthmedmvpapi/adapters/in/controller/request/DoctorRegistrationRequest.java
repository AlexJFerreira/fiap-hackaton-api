package br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.in.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorRegistrationRequest {
  @NotBlank
  private String name;
  @NotBlank
  @Email(message = "It must be a valid email address")
  private String email;
  @NotBlank
  private String password;
  @NotBlank
  private String crm;
  @NotBlank
  private String crmState;
  @NotBlank
  private String speciality;
}
