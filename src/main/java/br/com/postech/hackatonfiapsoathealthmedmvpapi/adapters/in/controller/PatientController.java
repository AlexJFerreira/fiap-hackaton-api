package br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.in.controller;

import br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.in.controller.request.DoctorLoginRequest;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.in.controller.request.PatientLoginRequest;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.in.controller.request.PatientRegistrationRequest;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.in.controller.response.LoginResponse;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.in.controller.response.PatientRegistrationResponse;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.core.domain.Patient;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.ports.in.RegisterPatientInputPort;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.config.security.JwtHelper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/healthmed/patients")
public class PatientController {

  private final ModelMapper modelMapper;
  private final RegisterPatientInputPort registerPatientInputPort;
  private final AuthenticationManager manager;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PatientRegistrationResponse patientRegistration(@Valid @RequestBody final PatientRegistrationRequest patientRegistrationRequest) {
    log.info("Patient registration request: {} received", patientRegistrationRequest);
    var patient = modelMapper.map(patientRegistrationRequest, Patient.class);
    return modelMapper.map(registerPatientInputPort.execute(patient), PatientRegistrationResponse.class);
  }

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@RequestBody @Valid PatientLoginRequest patientLoginRequest) {
    manager.authenticate(new UsernamePasswordAuthenticationToken(patientLoginRequest.email(), patientLoginRequest.password()));
    String token = JwtHelper.generateToken(patientLoginRequest.email());
    return ResponseEntity.ok(new LoginResponse(token));
  }



}
