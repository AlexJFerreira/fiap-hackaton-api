package br.com.postech.hackatonfiapsoathealthmedmvpapi.application.core.usecase;

import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.core.domain.Doctor;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.ports.in.DoctorsSearchInputPort;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.ports.out.SearchDoctorOutputPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorsSearchUseCase implements DoctorsSearchInputPort {

  private final SearchDoctorOutputPort searchDoctorOutputPort;


  @Override
  public List<Doctor> execute(String speciality) {
    return searchDoctorOutputPort.execute(speciality);
  }
}
