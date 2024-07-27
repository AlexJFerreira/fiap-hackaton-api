package br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.out.database.repository;

import br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.out.database.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {
    PatientEntity findByEmail(String login);

}
