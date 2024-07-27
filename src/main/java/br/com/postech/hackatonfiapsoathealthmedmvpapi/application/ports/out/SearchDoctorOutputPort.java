package br.com.postech.hackatonfiapsoathealthmedmvpapi.application.ports.out;

import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.core.domain.Doctor;
import java.util.List;

public interface SearchDoctorOutputPort {
    List<Doctor> execute(String speciality);
}
