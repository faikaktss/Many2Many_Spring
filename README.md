<h1 align="center" style="color:#4F8A10;">🌟 Java Spring Boot Student Management API 🌟</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Spring%20Boot-2.7.3-brightgreen?style=flat-square&logo=springboot" alt="Spring Boot">
  <img src="https://img.shields.io/badge/Java-17-blue?style=flat-square&logo=java">
  <img src="https://img.shields.io/badge/JPA-Hibernate-yellow?style=flat-square&logo=hibernate">
</p>

---

## 🎯 Proje Hakkında

Bu proje, **Spring Boot** ile hazırlanmış tam anlamıyla gerçek dünyadan bir öğrenci yönetim sistemi API'sidir!  
Projenin temel amacı, farklı ilişkisel veri tabanı bağlantılarını (OneToOne, OneToMany, ManyToOne, ManyToMany) kullanarak, öğrenci ve ilişkili varlıkların (adres, müşteri, çalışan, ev, oda, kurs, departman) yönetimini sağlamaktır.

Yapının tamamı **Layered Architecture** prensibine göre düzenlenmiştir:  
Controller ➡️ Service ➡️ Repository ➡️ Entity

---

## 🗂️ Proje Yapısı

Aşağıdaki gibi temiz ve anlaşılır bir paket yapısı kullanılmıştır:

```
src/
 └── main/
     ├── java/
     │    └── com.faik/
     │         ├── Controller/
     │         │    └── Impl/
     │         ├── Dto/
     │         ├── Entites/
     │         ├── exception/
     │         ├── Repository/
     │         ├── Services/
     │         │    └── Impl/
     │         └── Starter/
     └── resources/
          ├── static/
          └── templates/
```

---

## 🧩 Katmanlar ve Görevleri

| Katman      | Açıklama |
|-------------|----------|
| **Controller** | API endpoint'lerini tanımlar, gelen istekleri Service katmanına iletir. |
| **Service** | İş kurallarını ve business logic'i içerir. |
| **Repository** | JPA kullanarak veritabanı işlemlerini gerçekleştirir. |
| **Entity** | Veritabanı tablolarını temsil eden POJO'lardır. |
| **DTO** | Entity'lerden farklı olarak, dışarıya sunulan veri formatını belirler. |
| **Exception** | Global Exception handling ve hata yönetimi içerir. |

---

## 🔗 İlişkiler (Entity Relationships)

### 🟦 One-to-One

- **Customer** ↔️ **Address**
  - Her müşteri bir adrese sahiptir.
  - `@OneToOne` ve `@JoinColumn` ile tanımlanır.

### 🟩 One-to-Many & Many-to-One

- **Department** ⬅️ **Employee**
  - Bir departmanın birçok çalışanı olabilir.
  - `@ManyToOne` ve `@OneToMany` kullanılır.

- **Home** ⬅️ **Room**
  - Bir evde birden fazla oda olabilir.
  - `@OneToMany` ilişkisiyle tanımlanmış.

### 🟦 Many-to-Many

- **Student** ⬌ **Course**
  - Bir öğrenci birden fazla derse, bir ders birden fazla öğrenciye sahip olabilir.
  - `@ManyToMany` ile ve bir bağlantı tablosu (`student_course`) ile yönetilir.

---

## 📦 DTO Kullanımı

DTO'lar (Data Transfer Object), dış dünyaya entity'lerin karmaşıklığını yansıtmamak için kullanılır.  
Örneğin:

```java
public class DtoStudent {
    private String firstName;
    private String lastName;
    private List<DtoCourse> dtoCourses;
}
```

Validation işlemleri için DTO'larda **javax.validation** anotasyonları kullanılmıştır:
```java
@NotEmpty(message = "First_Name alanı boş bırakılamaz")
private String firstName;
```

---

## 🛡️ Exception Handling

Tüm validation ve business hataları, `GlobalExceptionHandler` ile merkezi olarak yönetilir.  
Hatalar anlamlı bir şekilde `ApiError` nesnesi olarak döner:

```json
{
  "id": "5b3c4f66-12e8-4d1d-bc24-6b5b2c4f66d2",
  "errorTime": "2025-09-25T15:45:00.000+00:00",
  "errors": {
    "firstName": ["First_Name alanı boş bırakılamaz"]
  }
}
```

---

## 🚀 Kullanım (Örnek API Çağrıları)

| Endpoint | Method | Açıklama |
|----------|--------|----------|
| `/rest/api/student/save` | POST | Yeni öğrenci ekler |
| `/rest/api/student/list` | GET | Tüm öğrencileri getirir |
| `/rest/api/student/list/{id}` | GET | ID'ye göre öğrenci getirir |
| `/rest/api/student/delete/{id}` | GET | Öğrenciyi siler |
| `/rest/api/student/update/{id}` | PUT | Öğrenciyi günceller |

> **Not:** Diğer varlıklar için de benzer CRUD endpoint'leri mevcuttur.

---

## 🏗️ Proje Kurulumu

1. **Java 17** ve **Maven** kurulu olmalı.
2. `application.properties` dosyasını veritabanınıza göre güncelleyin.
3. Terminalde:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
4. API'yi Postman veya curl ile test edebilirsiniz.

---

## 👨‍💻 Katkı ve Geliştirme

Katkıda bulunmak isterseniz, lütfen bir **pull request** açın veya issue oluşturun!  
Kendi veritabanınızı kolayca entegre edebilir, yeni varlıklar ve ilişkiler ekleyebilirsiniz.

---



## ❤️ Geliştirici

**Faik Aktaş**  
[GitHub Profilim](https://github.com/faikaktss)

---

## 🎨 Ekstra: Renkli Kod ve Açıklamalar

Aşağıda, ilişkilerin nasıl kurulduğuna dair renkli kod örnekleri bulabilirsiniz:

```java
// Student.java
@ManyToMany
@JoinTable(
  name = "student_course",
  joinColumns = @JoinColumn(name = "student_id"),
  inverseJoinColumns = @JoinColumn(name = "course_id")
)
private List<Course> courses;
```

```java
// Customer.java
@OneToOne
@JoinColumn(name = "address_id")
private Address address;
```

```java
// Emplooye.java
@ManyToOne
private Department department;
```

---

> **Her türlü sorunuz için iletişime geçmekten çekinmeyin!  
> Başarılar ve iyi kodlamalar! 🚀**
