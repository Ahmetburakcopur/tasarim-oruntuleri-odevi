public class EmailNotification implements Notification {
    @Override
    public void send(String recipient, String message) {
        System.out.println("--- E-posta Gönderiliyor ---");
        System.out.println("Alıcı: " + recipient + "\nMesaj: " + message);
        System.out.println("İşlem: SMTP sunucusuna bağlanıldı ve e-posta iletildi.\n");
    }
}
