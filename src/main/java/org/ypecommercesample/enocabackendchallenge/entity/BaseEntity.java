package org.ypecommercesample.enocabackendchallenge.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter

//BaseEntity classı, tüm entitylerin miras alacağı temek classtır
public abstract class BaseEntity {

    // Benzersiz ve otomatik id atamak için
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;


    // Oluşturulma tarihi otomatik olarak set edilir
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;


    //Son güncelleme tarihi, her güncellmede otomatik olarak set edilir
    @LastModifiedDate
    private LocalDateTime updatedAt;

    // Aktif/Pasif durumu
    private Boolean isActive = true;
}
