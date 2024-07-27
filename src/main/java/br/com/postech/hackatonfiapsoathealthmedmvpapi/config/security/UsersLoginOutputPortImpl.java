package br.com.postech.hackatonfiapsoathealthmedmvpapi.config.security;

import br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.out.database.entity.DoctorEntity;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.out.database.entity.PatientEntity;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.out.database.repository.DoctorRepository;
import br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.out.database.repository.PatientRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UsersLoginOutputPortImpl implements UserDetailsService {

  private final DoctorRepository repository;
  private final PatientRepository patientRepository;

  public UsersLoginOutputPortImpl(DoctorRepository repository, PatientRepository patientRepository) {
    this.repository = repository;
    this.patientRepository = patientRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String credential) {
    String password = null;
    String email = null;

    DoctorEntity doctor = repository.findByCrm(credential);

    if (doctor != null) {
      password = doctor.getPassword();
      email = doctor.getEmail();
    } else {
      PatientEntity patient = patientRepository.findByEmail(credential);
        if (patient != null) {
            password = patient.getPassword();
            email = patient.getEmail();
        }
    }

    return org.springframework.security.core.userdetails.User.builder()
        .username(email)
        .password(password)
        .build();
  }
}