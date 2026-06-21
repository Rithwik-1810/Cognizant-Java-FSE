public class NotificationService {
    private final ExternalService externalService;

    public NotificationService(ExternalService externalService) {
        this.externalService = externalService;
    }

    public void notifyUser(String user) {
        externalService.send("Hello " + user, user + "@example.com");
    }
}
