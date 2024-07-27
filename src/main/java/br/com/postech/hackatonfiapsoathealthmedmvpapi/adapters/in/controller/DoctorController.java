package br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.in.controller;

import br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.in.controller.request.DoctorLoginRequest;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.in.controller.request.DoctorRegistrationRequest;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.in.controller.response.DoctorRegistrationResponse;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.in.controller.response.LoginResponse;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.core.domain.Doctor;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.ports.in.RegisterDoctorInputPort;
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
@RequestMapping("/healthmed/doctors")
public class DoctorController {

  private final ModelMapper modelMapper;
  private final RegisterDoctorInputPort registerDoctorInputPort;
  private final AuthenticationManager manager;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public DoctorRegistrationResponse doctorRegistration(@Valid @RequestBody final DoctorRegistrationRequest doctorRegistrationRequest) {
    log.info("Doctor registration request: {} received", doctorRegistrationRequest);
    var doctor = modelMapper.map(doctorRegistrationRequest, Doctor.class);
    return modelMapper.map(registerDoctorInputPort.execute(doctor), DoctorRegistrationResponse.class);
  }

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@RequestBody @Valid DoctorLoginRequest doctorLoginRequest) {
    manager.authenticate(new UsernamePasswordAuthenticationToken(doctorLoginRequest.crm(), doctorLoginRequest.password()));
    String token = JwtHelper.generateToken(doctorLoginRequest.crm());
    return ResponseEntity.ok(new LoginResponse(token));
  }

}
