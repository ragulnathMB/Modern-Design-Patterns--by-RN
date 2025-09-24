// Decorator Pattern Example in TypeScript
// Notifier: Basic + Email + SMS + Slack decorators

interface Notifier {
  send(message: string): void;
}

class BasicNotifier implements Notifier {
  send(message: string): void {
    console.log(`Base notify: ${message}`);
  }
}

abstract class Decorator implements Notifier {
  constructor(protected wrap: Notifier) {}

  send(message: string): void {
    this.wrap.send(message);
  }
}

class EmailDecorator extends Decorator {
  send(message: string): void {
    console.log(`Email sent: ${message}`);
    super.send(message);
  }
}

class SMSDecorator extends Decorator {
  send(message: string): void {
    console.log(`SMS sent: ${message}`);
    super.send(message);
  }
}

class SlackDecorator extends Decorator {
  send(message: string): void {
    console.log(`Slack message sent: ${message}`);
    super.send(message);
  }
}

(function main() {
  let n: Notifier = new BasicNotifier();
  n = new EmailDecorator(n);
  n = new SMSDecorator(n);
  n = new SlackDecorator(n);
  n.send('System maintenance at 2 AM');
})();

export {};
