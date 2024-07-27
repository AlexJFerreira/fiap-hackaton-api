package br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.out.database.repository;

import br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.out.database.entity.DoctorEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {
  DoctorEntity findByCrm(String crm);
  List<DoctorEntity> findBySpeciality(String speciality);

}
