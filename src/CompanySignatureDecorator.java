public class CompanySignatureDecorator extends NotificationDecorator {
    public CompanySignatureDecorator(Notification wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String recipient, String message) {
        String signedMessage = message + "\n\n---\nBu mesaj Kurumsal Sistem tarafından otomatik gönderilmiştir.";
        super.send(recipient, signedMessage);
    }
}
