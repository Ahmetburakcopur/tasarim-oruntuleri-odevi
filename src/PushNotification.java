public class PushNotification implements Notification {
    @Override
    public void send(String recipient, String message) {
        System.out.println("--- Push Gönderiliyor ---");
        System.out.println("Cihaz ID: " + recipient + "\nMesaj: " + message);
        System.out.println("İşlem: Firebase servisine iletildi.\n");
    }
}
