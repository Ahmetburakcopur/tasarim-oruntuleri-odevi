public class NotificationService {

    public void sendNotification(String type, String message, String recipient) {
        
        // KÖTÜ TASARIM: Tüm mantık tek bir metodun içine yığılmış ve if-else zincirleri var.
        if (type.equalsIgnoreCase("EMAIL")) {
            System.out.println("-E-posta Gönderiliyor-");
            System.out.println("Alıcı: " + recipient);
            System.out.println("Mesaj: " + message);
            System.out.println("İşlem: SMTP sunucusuna bağlanıldı ve e-posta iletildi.\n");
            
        } else if (type.equalsIgnoreCase("SMS")) {
            System.out.println("-SMS Gönderiliyor-");
            System.out.println("Telefon Numarası: " + recipient);
            System.out.println("Mesaj: " + message);
            System.out.println("İşlem: Telekom operatörü API'sine istek atıldı.\n");
            
        } else if (type.equalsIgnoreCase("PUSH")) {
            System.out.println("-Push Notification Gönderiliyor-");
            System.out.println("Cihaz ID: " + recipient);
            System.out.println("Mesaj: " + message);
            System.out.println("İşlem: Firebase Cloud Messaging servisine iletildi.\n");
            
        } else {
            System.out.println("HATA: Geçersiz bildirim tipi! (" + type + ")\n");
        }
    }

    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        // Sistemi test ediyoruz
        service.sendNotification("EMAIL", "Tasarım Örüntüleri ödev teslimi yaklaşıyor!", "ogrenci@university.edu");
        service.sendNotification("SMS", "Hesabınıza yeni bir cihazdan giriş yapıldı.", "+905551234567");
        service.sendNotification("PUSH", "Yeni bir mesajınız var.", "device_token_x9a8b7");
        service.sendNotification("FAX", "Bu sistem faksı desteklemiyor.", "02121234567");
    }
}
