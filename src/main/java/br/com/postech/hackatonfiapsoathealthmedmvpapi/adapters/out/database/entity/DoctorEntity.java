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
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "doctor")
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Set<DoctorReviewEntity> getDoctorReviews() {
    return doctorReviews;
  }

  public void setDoctorReviews(
      Set<DoctorReviewEntity> doctorReviews) {
    this.doctorReviews = doctorReviews;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSpeciality() {
    return speciality;
  }

  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }

  public String getCrm() {
    return crm;
  }

  public void setCrm(String crm) {
    this.crm = crm;
  }

  public String getCrmState() {
    return crmState;
  }

  public void setCrmState(String crmState) {
    this.crmState = crmState;
  }

  public LocalDateTime getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(LocalDateTime registrationDate) {
    this.registrationDate = registrationDate;
  }
}
