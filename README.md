# E-Commerce Microservice Architecture Project

## Proje Genel Bakış
Java ve microservice mimari prensiplerine odaklanan mini bir Spring Boot e-ticaret backend sistemi.

## Temel Tasarım Prensipleri

Domain-Driven Design (DDD)

Domain-Driven Design, yazılım tasarımında, iş problemine odaklanarak yazılımın tüm yapısını bu problemi çözmek üzere inşa etmeyi amaçlayan bir yaklaşımdır. Bu prensip, yazılım geliştirme sürecinde iş alanındaki terimleri ve kavramları doğrudan kodlara entegre etmeyi hedefler.

Separation of Concerns (SoC)

Separation of Concerns, yazılımda her modülün veya bileşenin yalnızca tek bir sorumluluğa sahip olması gerektiğini belirten bir prensiptir. Bu, yazılımın daha modüler ve bakımı daha kolay olmasını sağlar. Örneğin, veri işleme, kullanıcı arayüzü ve iş mantığı farklı katmanlarda yer alır.

SOLID Prensipleri

SOLID, beş temel yazılım tasarımı prensibini ifade eder:

Single Responsibility Principle (SRP): Bir sınıf yalnızca bir sorumluluğa sahip olmalıdır.
Open/Closed Principle (OCP): Bir sınıf genişlemeye açık ancak değişikliğe kapalı olmalıdır.
Liskov Substitution Principle (LSP): Türetilmiş sınıflar, temel sınıflarının yerine kullanılabilmelidir.
Interface Segregation Principle (ISP): Kullanıcılar sadece kullanacakları işlevleri içeren arayüzleri kullanmalıdır.
Dependency Inversion Principle (DIP): Yüksek seviyedeki modüller düşük seviyedeki modüllere bağımlı olmamalıdır, her ikisi de soyutlamalara bağımlı olmalıdır.

## Transactional Integrity
Transactional Integrity, veritabanı işlemlerinin bütünlüğünü korumayı amaçlar. Yani, bir işlem ya tamamen başarılı olmalı ya da tamamen başarısız olmalıdır (ACID özellikleri). Bu, sistemin veri tutarlılığını sağlar.

## Teknik Özellikler
Katmanlı mimari (Entity, Repository, Service, Controller)
Bu tasarımda, yazılım çeşitli katmanlara bölünür:

Entity: Veritabanındaki verileri temsil eden sınıflardır.
Repository: Veriye erişim sağlayan katmandır. CRUD (Create, Read, Update, Delete) işlemlerini burada gerçekleştirirsiniz.
Service: İş mantığının işlendiği katmandır. Genellikle uygulamanın iş süreçleri burada yönetilir.
Controller: Kullanıcıdan gelen istekleri alan ve uygun servislere yönlendiren katmandır.
JPA/Hibernate ORM ile karmaşık ilişkiler
JPA (Java Persistence API) ve Hibernate ORM (Object-Relational Mapping), Java uygulamalarının veritabanı ile iletişim kurmasını sağlayan araçlardır. Karmaşık ilişkiler (One-to-Many, Many-to-One vb.) yönetilmesini sağlar ve SQL kodu yazmadan veritabanı işlemlerini yapabilmemize olanak tanır.

## Robust error handling
Robust error handling, hataların doğru bir şekilde yakalanıp, sistemin çökmeden doğru şekilde işlemeye devam etmesini sağlamak anlamına gelir. Bu, kullanıcı dostu hata mesajları ve loglama ile sağlanır.

## Transaction yönetimi
Transaction yönetimi, veritabanı işlemlerinin güvenli ve tutarlı bir şekilde yönetilmesini sağlar. Transaction, bir işlemdeki tüm adımların başarılı olmasını garanti eder.

## Dinamik fiyatlandırma ve stok takibi
Dinamik fiyatlandırma, ürünlerin fiyatlarını talebe, mevsime veya diğer faktörlere göre otomatik olarak ayarlamayı sağlar. Stok takibi ise, ürünlerin mevcut durumunu ve satış sonrasındaki envanteri izler.

## Soft delete mekanizması
Soft delete, veritabanından silinen verilerin fiziksel olarak silinmemesi, sadece "silindi" olarak işaretlenmesidir. Bu, verinin gelecekte tekrar erişilebilir olmasını sağlar.

## Veritabanı İlişkileri

One-to-One: Customer-Cart
Bir müşterinin yalnızca bir sepeti olabilir ve bir sepet yalnızca bir müşteriye ait olabilir.

One-to-Many: Customer-Orders, Order-OrderItems
Bir müşteri birden fazla sipariş verebilir, ve her sipariş birden fazla sipariş kalemi (ürün) içerebilir.

Many-to-One: CartItem-Product, OrderItem-Product
Bir sepet kalemi bir ürüne ait olabilir, ancak aynı ürün birden fazla sepette yer alabilir. Benzer şekilde, bir sipariş kalemi de tek bir ürüne ait olabilir ama aynı ürün farklı siparişlerde yer alabilir.

## Gelişmiş Uygulama Stratejileri

Akıllı stok yönetimi
Stokların, satış tahminleri ve talep analizlerine göre otomatik olarak yönetilmesini sağlayan bir stratejidir. Böylece, talep artışlarına göre stok seviyeleri hızla ayarlanabilir.

## Price preservation for historical order references
Geçmişte yapılmış siparişlerin fiyatlarının korunması, sipariş iptal veya iade işlemleri sırasında önemli olabilir. Bu, fiyat değişimlerinden bağımsız olarak eski siparişlerin tutarlılığını sağlar.

## BaseEntity ile otomatik audit trail
BaseEntity, tüm veritabanı nesnelerinin miras aldığı temel bir sınıftır. Bu sınıf, nesnelerin ne zaman oluşturulduğu, kim tarafından güncellendiği gibi bilgileri otomatik olarak kaydeder ve bu da audit trail (denetim izleme) sağlar.

## Dinamik sipariş durum takibi
Siparişlerin her aşamasındaki durumu (örneğin "Sipariş Alındı", "Kargoya Verildi", "Teslim Edildi") dinamik olarak takip edilmesini sağlar. Bu, kullanıcıların siparişlerinin durumunu her zaman güncel ve doğru bir şekilde görmesini sağlar.

## İş Mantığı Uygulamaları
Product Management (Oluşturma/Güncelleme/Silme)
Ürün yönetimi, ürünlerin eklenmesi, güncellenmesi ve silinmesi işlemlerini içerir. Bu işlemler, veritabanındaki ürün tablosu üzerinde yapılır.

Dinamik sepet toplam fiyat hesaplaması
Sepet içindeki ürünlerin fiyatlarının, kampanyalar veya indirimler gibi dinamik faktörlere göre otomatik olarak hesaplanmasını sağlar.

Stock availability kontrolü
Ürünlerin stokta olup olmadığını kontrol etme işlemi. Bu, müşteri siparişi verirken ürünlerin mevcut olup olmadığını kontrol eder ve kullanıcıya anlık olarak bilgi verir.

Order Processing
Sipariş işleme, müşteri siparişinin alınmasından, ödemesinin yapılmasına ve teslimatına kadar olan tüm süreci kapsar.

Benzersiz order code üretimi
Her sipariş için benzersiz bir sipariş kodu (ID) oluşturulmasını sağlar. Bu, siparişlerin izlenmesi ve yönetilmesi için önemlidir.

## Kullanılan Teknolojiler
Java 17
Java 17, Java programlama dilinin uzun vadeli destek verilen sürümüdür. Java 17, performans iyileştirmeleri ve yeni özellikler sunar.

Spring Boot
Spring Boot, Spring framework'ü üzerinde hızla uygulama geliştirmeyi kolaylaştıran bir araçtır. Konfigürasyonu azaltarak geliştiricilerin odaklanmalarını sağlar.

Spring Data JPA
Spring Data JPA, JPA (Java Persistence API) ile etkileşimde bulunmayı kolaylaştıran bir Spring modülüdür. Veritabanı işlemlerini daha basit hale getirir.

Hibernate
Hibernate, Java için bir ORM (Object-Relational Mapping) aracıdır. Veritabanı işlemlerini nesne yönelimli şekilde yönetmeyi sağlar.

Maven
Maven, Java projeleri için bir yapılandırma ve bağımlılık yönetim aracıdır. Projelerin derlenmesi, test edilmesi ve paketlenmesi için kullanılır.

Lombok
Lombok, Java sınıflarında tekrarlanan kodları (getter, setter, constructor gibi) otomatik olarak oluşturmak için kullanılan bir kütüphanedir.

MySQL/PostgreSQL
MySQL ve PostgreSQL, popüler açık kaynaklı veritabanı yönetim sistemleridir. MySQL genellikle hız ve basitlik açısından tercih edilirken, PostgreSQL daha gelişmiş özellikler ve veri bütünlüğü sağlar.
- Maven
- Lombok
- MySQL/PostgreSQL

