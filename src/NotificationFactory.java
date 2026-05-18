public class NotificationFactory {
    public Notification createNotification(String type) {
        if (type.equalsIgnoreCase("EMAIL")) return new EmailNotification();
        if (type.equalsIgnoreCase("SMS")) return new SmsNotification();
        if (type.equalsIgnoreCase("PUSH")) return new PushNotification();
        throw new IllegalArgumentException("Geçersiz bildirim tipi! (" + type + ")");
    }
}
