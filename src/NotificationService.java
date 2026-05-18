public class NotificationService {
    private NotificationFactory factory;

    public NotificationService() {
        this.factory = new NotificationFactory();
    }

    public void sendNotification(String type, String message, String recipient) {
        try {
            // Nesne yaratma sorumluluğu artık Factory de if-else zincirleri yok.
            Notification notification = factory.createNotification(type);
            notification.send(recipient, message);
        } catch (IllegalArgumentException e) {
            System.out.println("HATA: " + e.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        service.sendNotification("EMAIL", "Tasarım Örüntüleri ödevi yapılıyor!", "ogrenci@university.edu");
        service.sendNotification("SMS", "Hesabınıza giriş yapıldı.", "+905551234567");
        service.sendNotification("PUSH", "Yeni bir mesajınız var.", "device_token_x9a8b7");
    }
}
