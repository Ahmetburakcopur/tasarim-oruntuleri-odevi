public class SmsNotification implements Notification {
    @Override
    public void send(String recipient, String message) {
        System.out.println("--- SMS Gönderiliyor ---");
        System.out.println("Telefon: " + recipient + "\nMesaj: " + message);
        System.out.println("İşlem: Telekom operatörü API'sine istek atıldı.\n");
    }
}
