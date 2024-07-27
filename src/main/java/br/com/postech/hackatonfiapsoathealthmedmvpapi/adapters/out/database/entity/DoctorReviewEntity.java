package br.com.postech.hackatonfiapsoathealthmedmvpapi.adapters.out.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "doctor_review")
public class DoctorReviewEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long reviewId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "review_id", nullable = false)
  private DoctorEntity doctor;

  @Column(nullable = false)
  private int rating;

  @Lob
  private String comment;

  @Column(name = "review_date", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime reviewDate;



}
