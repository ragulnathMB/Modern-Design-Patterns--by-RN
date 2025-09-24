// Decorator Pattern Example in JavaScript
// Notifier: Basic + Email + SMS + Slack decorators

class Notifier {
  send(message) {}
}

class BasicNotifier extends Notifier {
  send(message) {
    console.log(`Base notify: ${message}`);
  }
}

class Decorator extends Notifier {
  constructor(wrap) {
    super();
    this.wrap = wrap;
  }

  send(message) {
    this.wrap.send(message);
  }
}

class EmailDecorator extends Decorator {
  send(message) {
    console.log(`Email sent: ${message}`);
    super.send(message);
  }
}

class SMSDecorator extends Decorator {
  send(message) {
    console.log(`SMS sent: ${message}`);
    super.send(message);
  }
}

class SlackDecorator extends Decorator {
  send(message) {
    console.log(`Slack message sent: ${message}`);
    super.send(message);
  }
}

(function main() {
  let n = new BasicNotifier();
  n = new EmailDecorator(n);
  n = new SMSDecorator(n);
  n = new SlackDecorator(n);
  n.send('System maintenance at 2 AM');
})();
