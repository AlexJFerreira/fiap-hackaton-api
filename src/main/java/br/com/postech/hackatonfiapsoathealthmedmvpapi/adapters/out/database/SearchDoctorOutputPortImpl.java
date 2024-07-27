package br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.out.database;

import br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.out.database.entity.DoctorEntity;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.out.database.repository.DoctorRepository;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.core.domain.Doctor;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.ports.out.SearchDoctorOutputPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SearchDoctorOutputPortImpl implements SearchDoctorOutputPort {

  private final DoctorRepository doctorRepository;
  private final ModelMapper modelMapper;

  @Override
  public List<Doctor> execute(String speciality) {
    List<DoctorEntity> doctors;

    if(speciality != null) {
      doctors = doctorRepository.findBySpeciality(speciality);
    } else {
      doctors = doctorRepository.findAll();
    }

    List<Doctor> doctorsDomainList = doctors.stream()
      .map(doctorEntity -> modelMapper.map(doctorEntity, Doctor.class))
      .toList();

    return doctorsDomainList;
  }
}
