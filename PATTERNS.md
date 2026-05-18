# Uygulanan Tasarım Örüntüleri

## 1. Factory Method (Creational Pattern - Faz 1)
* **Nerede Kullanıldı:** Bildirim nesnelerinin yaratılma sürecinde kullanıldı. İşlem `NotificationFactory` sınıfına devredildi.
* **Neden Kullanıldı:** Başlangıç kodunda nesne yaratımı ve iş mantığı `NotificationService` içinde iç içe geçmişti. Yeni bildirim tipi eklemek kodu bozma riski taşıyordu.
* **Ne Kazanıldı:** Nesne yaratma sorumluluğu tek bir merkeze toplandı. Sınıflar arası bağımlılık (coupling) azaltıldı.

### UML Sınıf Diyagramı (Önceki ve Sonraki Durum)

```mermaid
classDiagram
    class NotificationService {
        -NotificationFactory factory
        +sendNotification(type, message, recipient)
    }
    class NotificationFactory {
        +createNotification(type): Notification
    }
    class Notification {
        <<interface>>
        +send(recipient, message)
    }
    
    NotificationService --> NotificationFactory
    NotificationFactory ..> Notification : creates
    Notification <|.. EmailNotification
    Notification <|.. SmsNotification
    Notification <|.. PushNotification
