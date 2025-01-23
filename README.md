## E-Commerce Microservice Architecture Project

**Proje Genel Bakışı**

Bu proje, Java ve microservice mimarisi kullanarak mini bir Spring Boot e-ticaret backend sistemi geliştirmeyi amaçlar. Temelde, iş mantığını modüler bir şekilde yönetmeye odaklanır.

**Temel Tasarım Prensipleri**

Domain-Driven Design (DDD): İş problemini çözmek için yazılımı iş alanına göre tasarlama.

Separation of Concerns (SoC): Yazılımda her modülün yalnızca bir sorumluluğa sahip olması gerektiği prensip.

SOLID Prensipleri: Modüler ve bakımı kolay yazılım için beş temel prensip.

Transactional Integrity: Veritabanı işlemlerinin tutarlılığını sağlama.

**Teknik Özellikler**

Katmanlı Mimari: Entity, Repository, Service ve Controller katmanları.

JPA/Hibernate ORM: Veritabanı işlemlerini nesne tabanlı şekilde yönetme.

Error Handling ve Transaction Yönetimi: Hata yönetimi ve güvenli işlem yönetimi.

Dinamik Fiyatlandırma ve Stok Takibi: Fiyatları ve stok seviyelerini otomatik olarak ayarlama.

Soft Delete: Verilerin fiziksel olarak silinmemesi, sadece "silindi" olarak işaretlenmesi.

**Veritabanı İlişkileri**

One-to-One: Customer-Cart

One-to-Many: Customer-Orders, Order-OrderItems

Many-to-One: CartItem-Product, OrderItem-Product

**Gelişmiş Uygulama Stratejileri**

Akıllı Stok Yönetimi: Talep analizlerine göre stokları yönetme.

Price Preservation: Geçmiş siparişlerin fiyatlarını koruma.

BaseEntity ile Audit Trail: Veritabanı nesnelerinin değişim geçmişini otomatik kaydetme.

Dinamik Sipariş Durum Takibi: Siparişlerin her aşamasını takip etme.

**İş Mantığı Uygulamaları**

Product Management: Ürünlerin oluşturulması, güncellenmesi ve silinmesi.

Dinamik Fiyat Hesaplaması: Sepet içindeki fiyatların otomatik hesaplanması.

Stock Availability: Ürünlerin stokta olup olmadığını kontrol etme.

Order Processing: Siparişlerin alınması ve teslimat süreci.

Benzersiz Sipariş Kodu: Her sipariş için benzersiz ID üretme.

**Kullanılan Teknolojiler**

Java 17, Spring Boot, Spring Data JPA, Hibernate

Maven, Lombok

MySQL/PostgreSQL
