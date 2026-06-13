public class DecoratorPatternExample {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsAndEmail = new SMSNotifierDecorator(emailNotifier);
        Notifier allChannels = new SlackNotifierDecorator(smsAndEmail);

        System.out.println("Sending notification via all channels");
        allChannels.send("System Update: Service is up and running.");

        System.out.println(" Sending notification via SMS & Email only ");
        smsAndEmail.send("Important Alert: CPU usage high.");
    }
}
