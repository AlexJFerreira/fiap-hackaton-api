package br.com.postech.hackatonfiapsoathealthmedmvpapi.application.ports.in;

import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.core.domain.Patient;

public interface RegisterPatientInputPort {
  Patient execute(Patient patient);
}
