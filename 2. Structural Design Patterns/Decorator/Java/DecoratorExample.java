// Decorator Pattern Example in Java
// Notifier: Basic + Email + SMS + Slack decorators

interface Notifier { void send(String message); }

class BasicNotifier implements Notifier {
    public void send(String message){ System.out.println("Base notify: " + message); }
}

abstract class NotifierDecorator implements Notifier {
    protected final Notifier wrappee;
    protected NotifierDecorator(Notifier wrappee){ this.wrappee = wrappee; }
    public void send(String message){ wrappee.send(message); }
}

class EmailDecorator extends NotifierDecorator {
    public EmailDecorator(Notifier w){ super(w); }
    public void send(String message){ System.out.println("Email sent: " + message); super.send(message); }
}

class SMSDecorator extends NotifierDecorator {
    public SMSDecorator(Notifier w){ super(w); }
    public void send(String message){ System.out.println("SMS sent: " + message); super.send(message); }
}

class SlackDecorator extends NotifierDecorator {
    public SlackDecorator(Notifier w){ super(w); }
    public void send(String message){ System.out.println("Slack message sent: " + message); super.send(message); }
}

public class DecoratorExample {
    public static void main(String[] args){
        Notifier n = new BasicNotifier();
        n = new EmailDecorator(n);
        n = new SMSDecorator(n);
        n = new SlackDecorator(n);
        n.send("System maintenance at 2 AM");
    }
}
