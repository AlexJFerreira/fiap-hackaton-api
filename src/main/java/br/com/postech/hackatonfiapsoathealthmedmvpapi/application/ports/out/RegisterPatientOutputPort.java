package br.com.postech.hackatonfiapsoathealthmedmvpapi.application.ports.out;

import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.core.domain.Patient;

public interface RegisterPatientOutputPort {
  Patient execute(Patient patient);
}
