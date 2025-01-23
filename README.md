# E-Commerce Microservice Architecture Project

## Proje Genel Bakış
Java ve microservice mimari prensiplerine odaklanan kapsamlı bir Spring Boot e-ticaret backend sistemi.

## Teknik Mimari

### Temel Tasarım Prensipleri
- Domain-Driven Design
- Separation of Concerns
- SOLID Prensipleri
- Transactional Integrity

### Teknik Özellikler
- Katmanlı mimari (Entity, Repository, Service, Controller)
- JPA/Hibernate ORM ile karmaşık ilişkiler
- Robust error handling
- Transaction yönetimi
- Dinamik fiyatlandırma ve stok takibi
- Soft delete mekanizması

### Veritabanı İlişkileri
- One-to-One: Customer-Cart
- One-to-Many: Customer-Orders, Order-OrderItems
- Many-to-One: CartItem-Product, OrderItem-Product

### Gelişmiş Uygulama Stratejileri
- Akıllı stok yönetimi
- Price preservation for historical order references
- BaseEntity ile otomatik audit trail
- Dinamik sipariş durum takibi

## İş Mantığı Uygulamaları
- Product Management (Oluşturma/Güncelleme/Silme)
- Dinamik sepet toplam fiyat hesaplaması
- Stock availability kontrolü
- Order Processing
- Benzersiz order code üretimi

## Teknoloji Yığını
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven
- Lombok
- MySQL/PostgreSQL

## Gelecek Geliştirmeler
- Microservice decomposition
- Comprehensive testing
- Caching mekanizmaları
- Advanced security uygulamaları
