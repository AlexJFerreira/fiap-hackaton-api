package br.com.postech.hackatonfiapsoathealthmedmvpapi.application.ports.out;

import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.core.domain.Doctor;

public interface RegisterDoctorOutputPort {
    Doctor execute(Doctor doctor);
}
