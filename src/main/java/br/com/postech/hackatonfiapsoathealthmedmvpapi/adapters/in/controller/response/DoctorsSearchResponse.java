package br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.in.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoctorsSearchResponse {
  private String name;
  private String speciality;
  private String crm;
  private String rate;
}
