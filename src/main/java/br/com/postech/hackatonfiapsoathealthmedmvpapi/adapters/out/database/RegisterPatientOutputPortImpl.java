package br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.out.database;

import br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.out.database.entity.PatientEntity;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.out.database.repository.PatientRepository;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.core.domain.Patient;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.application.ports.out.RegisterPatientOutputPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterPatientOutputPortImpl implements RegisterPatientOutputPort {

  private final PatientRepository patientRepository;
  private final ModelMapper modelMapper;
  private final PasswordEncoder passwordEncoder;

  @Override
  public Patient execute(Patient patient) {
    patient.setPassword(passwordEncoder.encode(patient.getPassword()));
    var patientEntity = modelMapper.map(patient, PatientEntity.class);
    return modelMapper.map(patientRepository.save(patientEntity), Patient.class);
  }
}
