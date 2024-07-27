package br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.out.database.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.Data;

@Entity
@Table(name = "doctor")
@Data
public class DoctorEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<DoctorReviewEntity> doctorReviews;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "speciality")
  private String speciality;

  @Column(name = "crm")
  private String crm;

  @Column(name = "crm_state")
  private String crmState;

  @Column(name = "registration_date", insertable = false, updatable = false)
  private LocalDateTime registrationDate;
}
