# Bildirim Sistemi - Başlangıç Kodu Sorunları (Faz 0)

1. **Single Responsibility Principle (Tek Sorumluluk Prensibi) İhlali:**
   `NotificationService` sınıfı hem hangi bildirimin gönderileceğine karar veriyor, hem bildirim metinlerini oluşturuyor, hem de gönderim işlemini üstleniyor. Bir sınıfın değişmek için birden fazla nedeni olmamalıdır.

2. **Open/Closed Principle (Açık/Kapalı Prensibi) İhlali:**
   Sisteme yeni bir bildirim türü (örneğin Slack veya WhatsApp) eklemek istediğimizde mevcut `NotificationService` sınıfının içindeki `if-else` yapısını değiştirmek zorundayız. Kod gelişime açık, ancak değişime kapalı olmalıdır.

3. **Nesne Yaratımı ve İş Mantığının Birbirine Girmesi:**
   Farklı bildirim türleri (Email, SMS) kavramsal olarak ayrı nesneler olmalıyken, burada sadece basit `String` parametreler üzerinden ayırt ediliyor. Nesne yaratma sorumluluğu dışarıya alınmamış.

4. **Kod Tekrarı (Duplication) Potansiyeli:**
   Her bir `if` bloğu içinde alıcı ve mesaj yazdırma gibi birbirine çok benzeyen satırlar var. Ortak davranışlar soyutlanmadığı için ileride yapılacak bir format değişikliği her bloğa ayrı ayrı müdahale gerektirecek.

5. **Test Edilebilirlik (Testability) Zayıflığı:**
   Bağımlılıklar sınıf içine sabit kodlandığı (hardcoded) için ve her şey tek bir fonksiyona yığıldığı için, örneğin sadece "SMS gönderme" mantığını izole edip birim (unit) test yazmak imkansızdır.


 
   ## AI Analizi Karşılaştırması

**AI'a Verilen Prompt:** "Bu kodda hangi tasarım sorunlarını görüyorsun? Hangi tasarım örüntüleri bu sorunları çözebilir? Her sorun için kısa bir açıklama yaz."

**AI'ın Gördükleri ve Kendi Gördüklerim Arasındaki Fark:**
AI, listelediğim 5 temel SOLID prensibi ve mimari ihlallerinin birebir aynısını tespit etti. Ek olarak AI, bu sorunların spesifik olarak hangi örüntülerle çözülebileceğini işaret etti (Nesne yaratım sorunu için Factory Method, if-else zincirlerini kırmak için Strategy veya Command örüntüsü gibi). Herhangi bir çelişki yaşanmadı, AI'ın sunduğu çözüm haritası tespit ettiğim sorunlarla tamamen örtüşüyor.
