# Faz 1 - AI Log (Creational Patterns)

**AI'a Sorulan Soru (Prompt):** "NotificationService sınıfındaki if-else zincirlerini kırmak ve nesne yaratımını düzenlemek için hangi Creational örüntüyü kullanmalıyım? Bana kodun Factory Method ile refactor edilmiş halini göster."

**AI'ın Yanıtı (Özet):** AI, bu durum için en uygun Creational örüntünün "Factory Method" olduğunu belirtti. Bildirim tipleri için ortak bir `Notification` interface'i açmamı ve yaratım işlemini `NotificationFactory` adında ayrı bir sınıfa devretmemi önerdi.

**Benim Uygulamam ve Kararım:** AI'ın önerdiği mimariyi projeme uyguladım. Kodun okunabilirliği arttı ve if-else zincirlerinden kurtularak Open/Closed prensibine bir adım daha yaklaştık. Nesne yaratımı tamamen izole edildi.
