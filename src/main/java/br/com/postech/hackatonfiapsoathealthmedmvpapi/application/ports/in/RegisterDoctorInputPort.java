package br.com.postech.hackatonfiapsoathealthmedmvpapi.application.ports.in;

import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.core.domain.Doctor;

public interface RegisterDoctorInputPort {
  Doctor execute(Doctor doctor);
}
