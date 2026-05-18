public class NotificationService {
    private NotificationFactory factory;

    public NotificationService() {
        this.factory = new NotificationFactory();
    }

    public void sendNotification(String type, String message, String recipient) {
        try {
            // Fabrikadan asıl nesneyi al
            Notification notification = factory.createNotification(type);
            
            // Dekoratör ile nesneyi sarmala (İmza ekle)
            Notification notificationWithSignature = new CompanySignatureDecorator(notification);
            
            // Sarmalanmış haliyle gönder
            notificationWithSignature.send(recipient, message);
        } catch (IllegalArgumentException e) {
            System.out.println("HATA: " + e.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        service.sendNotification("EMAIL", "Tasarım Örüntüleri Faz 2 tamamlanıyor!", "ogrenci@university.edu");
        service.sendNotification("SLACK", "Slack adaptörü ve Dekoratör başarıyla çalışıyor.", "channel_dev_team");
    }
}
