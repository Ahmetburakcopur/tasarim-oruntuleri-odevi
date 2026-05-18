public class SlackNotificationAdapter implements Notification {
    private ThirdPartySlackApi slackApi;

    public SlackNotificationAdapter(ThirdPartySlackApi slackApi) {
        this.slackApi = slackApi;
    }

    @Override
    public void send(String recipient, String message) {
        // Bizim anladığımız "send" metodunu, Slack in anladığı "sendSlackMessage" metoduna çeviriyoruz.
        slackApi.sendSlackMessage(recipient, message);
    }
}
