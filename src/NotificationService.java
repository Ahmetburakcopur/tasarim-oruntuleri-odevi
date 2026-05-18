import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private NotificationFactory factory;
    // Gözlemcileri (Observer) tutacağımız liste
    private List<NotificationObserver> observers;

    public NotificationService() {
        this.factory = new NotificationFactory();
        this.observers = new ArrayList<>();
    }

    // Gözlemci ekleme metodu (Subscribe)
    public void addObserver(NotificationObserver observer) {
        observers.add(observer);
    }

    // Tüm gözlemcilere haber verme metodu (Notify)
    private void notifyObservers(String type, String message) {
        for (NotificationObserver observer : observers) {
            observer.update(type, message);
        }
    }

    public void sendNotification(String type, String message, String recipient) {
        try {
            Notification notification = factory.createNotification(type);
            Notification notificationWithSignature = new CompanySignatureDecorator(notification);
            
            notificationWithSignature.send(recipient, message);
            
            // Bildirim başarıyla gönderildikten sonra gözlemcilere haber ver
            notifyObservers(type, message);
            
        } catch (IllegalArgumentException e) {
            System.out.println("HATA: " + e.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        
        // Sisteme bir log gözlemcisi abone ediyoruz
        service.addObserver(new SystemLogObserver());

        System.out.println("--- BİLDİRİM TESTLERİ BAŞLIYOR ---\n");
        service.sendNotification("EMAIL", "Final projesi başarıyla teslim edildi!", "hoca@university.edu");
        service.sendNotification("PUSH", "Yeni bir güncelleme var.", "device_123");
    }
}
