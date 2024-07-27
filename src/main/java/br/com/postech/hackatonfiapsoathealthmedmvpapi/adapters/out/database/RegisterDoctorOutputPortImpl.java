package br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.out.database;

import br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.out.database.entity.DoctorEntity;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.out.database.repository.DoctorRepository;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.core.domain.Doctor;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.ports.out.RegisterDoctorOutputPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterDoctorOutputPortImpl implements RegisterDoctorOutputPort {

  private final DoctorRepository doctorRepository;
  private final ModelMapper modelMapper;
  private final PasswordEncoder passwordEncoder;

  @Override
  public Doctor execute(Doctor doctor) {
    doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
    var doctorEntity = modelMapper.map(doctor, DoctorEntity.class);
    return modelMapper.map(doctorRepository.save(doctorEntity), Doctor.class);  }
}
