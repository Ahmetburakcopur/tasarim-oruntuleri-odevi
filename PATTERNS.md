# Uygulanan Tasarım Örüntüleri

## 1. Factory Method (Creational Pattern - Faz 1)
* **Nerede Kullanıldı:** Bildirim nesnelerinin yaratılma sürecinde kullanıldı. İşlem `NotificationFactory` sınıfına devredildi.
* **Neden Kullanıldı:** Başlangıç kodunda nesne yaratımı ve iş mantığı `NotificationService` içinde iç içe geçmişti. Yeni bildirim tipi eklemek kodu bozma riski taşıyordu.
* **Ne Kazanıldı:** Nesne yaratma sorumluluğu tek bir merkeze toplandı. Sınıflar arası bağımlılık (coupling) azaltıldı.

## 2. Adapter (Structural Pattern - Faz 2)
* **Nerede Kullanıldı:** `ThirdPartySlackApi` sınıfını bizim `Notification` arayüzümüze uydurmak için `SlackNotificationAdapter` sınıfında kullanıldı.
* **Neden Kullanıldı:** Dışarıdan gelen hazır Slack kodunun metod yapısı (`sendSlackMessage`), bizim sistemimizin beklediği yapıya (`send`) uymuyordu.
* **Ne Kazanıldı:** Slack'in kaynak koduna hiç dokunmadan, kendi sistemimize sorunsuz bir şekilde entegre ettik.

## 3. Decorator (Structural Pattern - Faz 2)
* **Nerede Kullanıldı:** Bildirim mesajlarına otomatik şirket imzası eklemek için `CompanySignatureDecorator` sınıfında kullanıldı.
* **Neden Kullanıldı:** Mesajların içeriğini değiştirmek için asıl bildirim sınıflarını (Email, SMS) değiştirmek istemedik.
* **Ne Kazanıldı:** Alt sınıflar oluşturmaya gerek kalmadan, çalışma zamanında (runtime) nesnelere yeni özellikler (imza) ekleme esnekliği sağlandı.

### Güncel UML Mimari Diyagramı (Faz 2)

```mermaid
classDiagram
    class Notification {
        <<interface>>
        +send(recipient, message)
    }
    class EmailNotification
    class SmsNotification
    class ThirdPartySlackApi {
        +sendSlackMessage(chatId, text)
    }
    class SlackNotificationAdapter {
        -ThirdPartySlackApi slackApi
    }
    class NotificationDecorator {
        <<abstract>>
        #Notification wrappee
    }
    class CompanySignatureDecorator
    
    Notification <|.. EmailNotification
    Notification <|.. SmsNotification
    Notification <|.. SlackNotificationAdapter
    Notification <|.. NotificationDecorator
    NotificationDecorator <|-- CompanySignatureDecorator
    SlackNotificationAdapter --> ThirdPartySlackApi : adapts
    NotificationDecorator --> Notification : wraps
