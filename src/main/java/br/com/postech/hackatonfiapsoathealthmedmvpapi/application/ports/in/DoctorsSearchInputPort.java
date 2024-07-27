package br.com.postech.hackatonfiapsoathealthmedmvpapi.application.ports.in;

import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.core.domain.Doctor;
import java.util.List;

public interface DoctorsSearchInputPort {
  List<Doctor> execute(String speciality);
}
