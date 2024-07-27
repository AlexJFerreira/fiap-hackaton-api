package br.com.postech.hackatonfiapsoathealthmedmvpapi.application.core.usecase;

import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.core.domain.Patient;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.ports.in.RegisterPatientInputPort;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.ports.out.RegisterPatientOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterPatientUseCase implements RegisterPatientInputPort {

  private final RegisterPatientOutputPort registerPatientOutputPort;

  @Override
  public Patient execute(Patient patient) {
    return registerPatientOutputPort.execute(patient);
  }
}
