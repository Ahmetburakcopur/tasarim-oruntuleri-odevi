public class SystemLogObserver implements NotificationObserver {
    @Override
    public void update(String notificationType, String message) {
        System.out.println("[SİSTEM LOG] Yeni bildirim gönderildi -> Tipi: " + notificationType + " | İçerik: " + message);
    }
}
