// Decorator Pattern Example in C#
// Notifier: Basic + Email + SMS + Slack decorators

using System;

namespace DecoratorExample
{
    interface INotifier { void Send(string message); }

    class BasicNotifier : INotifier
    {
        public void Send(string message)
        {
            Console.WriteLine($"Base notify: {message}");
        }
    }

    abstract class NotifierDecorator : INotifier
    {
        protected readonly INotifier wrappee;
        protected NotifierDecorator(INotifier wrappee) { this.wrappee = wrappee; }
        public virtual void Send(string message) { wrappee.Send(message); }
    }

    class EmailDecorator : NotifierDecorator
    {
        public EmailDecorator(INotifier w) : base(w) {}
        public override void Send(string message)
        {
            Console.WriteLine($"Email sent: {message}");
            base.Send(message);
        }
    }

    class SMSDecorator : NotifierDecorator
    {
        public SMSDecorator(INotifier w) : base(w) {}
        public override void Send(string message)
        {
            Console.WriteLine($"SMS sent: {message}");
            base.Send(message);
        }
    }

    class SlackDecorator : NotifierDecorator
    {
        public SlackDecorator(INotifier w) : base(w) {}
        public override void Send(string message)
        {
            Console.WriteLine($"Slack message sent: {message}");
            base.Send(message);
        }
    }

    class Program
    {
        static void Main()
        {
            INotifier notifier = new BasicNotifier();
            notifier = new EmailDecorator(notifier);
            notifier = new SMSDecorator(notifier);
            notifier = new SlackDecorator(notifier);
            notifier.Send("System maintenance at 2 AM");
        }
    }
}
