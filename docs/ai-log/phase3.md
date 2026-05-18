# Faz 3 - AI Log (Behavioral Patterns)

**AI'a Sorulan Soru (Prompt):** "Sistemde gönderilen her bildirimi dinleyip log tutacak bir yapı kurmak istiyorum. Bunu if-else ile yapmak yerine hangi davranışsal (behavioral) örüntüyü kullanmalıyım? Strategy mi Observer mı?"

**AI'ın Yanıtı (Özet):** AI, bu senaryo için en uygun örüntünün **Observer (Gözlemci)** olduğunu belirtti. Strategy örüntüsünün bir işi yapmanın farklı yollarını seçmek için kullanıldığını, Observer'ın ise bir olay gerçekleştiğinde (bildirim gönderilmesi) abone olan diğer sınıflara (loglayıcı) otomatik haber vermek için tasarlandığını açıkladı.

**Benim Uygulamam ve Kararım:** AI'ın yönlendirmesiyle sisteme `NotificationObserver` arayüzünü ve bunu uygulayan `SystemLogObserver` sınıfını ekledim. `NotificationService` sınıfını yayıncı (publisher) haline getirerek loglama işlemini ana iş mantığından başarıyla ayırdım.
