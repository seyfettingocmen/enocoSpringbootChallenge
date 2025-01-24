package org.ypecommercesample.enocabackendchallenge.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass // Bu sınıfın diğer entity'ler tarafından miras alınacağını belirtir.
@EntityListeners(AuditingEntityListener.class) // Auditing özelliklerini etkinleştirir.
@Getter
@Setter
public abstract class BaseEntity {

    @Id // Bu alanın birincil anahtar (primary key) olduğunu belirtir.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID'nin otomatik olarak artmasını sağlar.
    private Long id;

    @CreatedDate // Entity oluşturulduğunda otomatik olarak tarih atar.
    @Column(updatable = false, nullable = false) // Bu alan güncellenemez ve boş olamaz.
    private LocalDateTime createdAt;

    @LastModifiedDate // Entity her güncellendiğinde otomatik olarak tarih atar.
    @Column(nullable = false) // Bu alan boş olamaz.
    private LocalDateTime updatedAt;

    @Column(nullable = false) // Bu alan boş olamaz.
    private Boolean isActive = true; // Varsayılan değer true olarak atanır.
}