# Faz 2 - AI Log (Structural Patterns)

**AI'a Sorulan Soru (Prompt):** "Sisteme dışarıdan hazır bir Slack API'si entegre etmek istiyorum. Adapter pattern burada uygun mu, yoksa Facade mı kullanmalıyım? Farkını açıkla."

**AI'ın Yanıtı (Özet):** AI, bu senaryo için kesinlikle **Adapter** kullanmam gerektiğini belirtti. Facade örüntüsünün karmaşık bir alt sistemi basitleştirmek için kullanıldığını, Adapter'ın ise birbiriyle uyumsuz iki arayüzü (bizim `Notification` interface'imiz ile Slack'in `ThirdPartySlackApi` sınıfı) birbiriyle konuşturmak için tasarlandığını açıkladı. 

**Benim Uygulamam ve Kararım:** AI'ın Adapter önerisi mantıklıydı ve sisteme `SlackNotificationAdapter` olarak uyguladım. Ek olarak, mesajlara otomatik imza eklemek için **Decorator** örüntüsünü kullanma fikrini AI ile tartışarak projeye dahil ettim. AI ilk başta dekoratörü doğrudan Service sınıfına gömmemi önerdi, ancak ben bağımsız bir sarmalayıcı sınıf oluşturarak hiyerarşiyi daha doğru kurdum.
