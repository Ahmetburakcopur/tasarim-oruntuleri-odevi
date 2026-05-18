# Uygulanan Tasarım Örüntüleri

## 1. Factory Method (Creational Pattern - Faz 1)
* **Nerede Kullanıldı:** Bildirim nesnelerinin yaratılma sürecinde kullanıldı. İşlem `NotificationFactory` sınıfına devredildi.
* **Neden Kullanıldı:** Başlangıç kodunda nesne yaratımı ve iş mantığı `NotificationService` içinde iç içe geçmişti.
* **Ne Kazanıldı:** Nesne yaratma sorumluluğu tek bir merkeze toplandı.

## 2. Adapter (Structural Pattern - Faz 2)
* **Nerede Kullanıldı:** `ThirdPartySlackApi` sınıfını uydurmak için `SlackNotificationAdapter` sınıfında kullanıldı.
* **Neden Kullanıldı:** Dışarıdan gelen hazır Slack kodunun metod yapısı, bizim sistemimizin beklediği yapıya uymuyordu.
* **Ne Kazanıldı:** Slack'in kaynak koduna hiç dokunmadan, kendi sistemimize entegre ettik.

## 3. Decorator (Structural Pattern - Faz 2)
* **Nerede Kullanıldı:** Bildirim mesajlarına otomatik şirket imzası eklemek için `CompanySignatureDecorator` sınıfında kullanıldı.
* **Neden Kullanıldı:** Mesajların içeriğini değiştirmek için asıl bildirim sınıflarını (Email, SMS) değiştirmek istemedik.
* **Ne Kazanıldı:** Alt sınıflar oluşturmaya gerek kalmadan çalışma zamanında nesnelere imza eklendi.

## 4. Observer (Behavioral Pattern - Faz 3)
* **Nerede Kullanıldı:** Bildirim gönderim işlemlerini dinleyip log tutmak için `SystemLogObserver` sınıfında kullanıldı.
* **Neden Kullanıldı:** Loglama işlemini, ana bildirim gönderme mantığının içine gömmek istemedik.
* **Ne Kazanıldı:** Gevşek bağlı (loosely coupled) bir yapı kuruldu. İleride başka dinleyiciler kolayca eklenebilir.

### Final UML Mimari Diyagramı

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
    
    class NotificationObserver {
        <<interface>>
        +update(type, message)
    }
    class SystemLogObserver
    
    class NotificationService {
        -List~NotificationObserver~ observers
        +addObserver(observer)
        -notifyObservers(type, message)
        +sendNotification(type, message, recipient)
    }

    NotificationService o-- NotificationObserver : observes
    NotificationObserver <|.. SystemLogObserver
    
    Notification <|.. EmailNotification
    Notification <|.. SmsNotification
    Notification <|.. SlackNotificationAdapter
    Notification <|.. NotificationDecorator
    NotificationDecorator <|-- CompanySignatureDecorator
    SlackNotificationAdapter --> ThirdPartySlackApi : adapts
    NotificationDecorator --> Notification : wraps
    NotificationService --> Notification : creates
