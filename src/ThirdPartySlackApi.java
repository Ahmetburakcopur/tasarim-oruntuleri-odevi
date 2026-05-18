public class ThirdPartySlackApi {
    public void sendSlackMessage(String chatId, String text) {
        System.out.println("--- Slack Mesajı Gönderiliyor ---");
        System.out.println("Chat ID: " + chatId + "\nMesaj: " + text);
        System.out.println("İşlem: Slack Workspace API'sine bağlandı.\n");
    }
}
