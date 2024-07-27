package br.com.postech.hackatonfiapsoathealthmedmvpapi.application.core.usecase;

import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.core.domain.Doctor;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.ports.in.RegisterDoctorInputPort;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.ports.out.RegisterDoctorOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterDoctorUseCase implements RegisterDoctorInputPort {

  private final RegisterDoctorOutputPort registerDoctorOutputPort;

  @Override
  public Doctor execute(Doctor doctor) {
    return registerDoctorOutputPort.execute(doctor);
  }
}
