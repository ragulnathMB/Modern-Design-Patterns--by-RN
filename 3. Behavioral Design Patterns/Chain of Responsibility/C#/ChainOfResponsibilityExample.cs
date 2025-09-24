// Chain of Responsibility Pattern Example in C#
// Support ticket system with different levels of handlers

using System;

namespace ChainOfResponsibilityExample
{
    abstract class SupportHandler
    {
        protected SupportHandler nextHandler;
        public void SetNext(SupportHandler handler) { nextHandler = handler; }
        public abstract void HandleRequest(SupportTicket ticket);
    }

    class SupportTicket
    {
        public string Issue { get; }
        public int Priority { get; }
        public SupportTicket(string issue, int priority) { Issue = issue; Priority = priority; }
    }

    class Level1Support : SupportHandler
    {
        public override void HandleRequest(SupportTicket ticket)
        {
            if (ticket.Priority <= 1)
                Console.WriteLine($"Level 1: Handled '{ticket.Issue}'");
            else if (nextHandler != null)
                nextHandler.HandleRequest(ticket);
            else
                Console.WriteLine($"No handler available for '{ticket.Issue}'");
        }
    }

    class Level2Support : SupportHandler
    {
        public override void HandleRequest(SupportTicket ticket)
        {
            if (ticket.Priority <= 2)
                Console.WriteLine($"Level 2: Handled '{ticket.Issue}'");
            else if (nextHandler != null)
                nextHandler.HandleRequest(ticket);
            else
                Console.WriteLine($"No handler available for '{ticket.Issue}'");
        }
    }

    class Level3Support : SupportHandler
    {
        public override void HandleRequest(SupportTicket ticket)
        {
            Console.WriteLine($"Level 3: Handled '{ticket.Issue}'");
        }
    }

    class Program
    {
        static void Main()
        {
            var level1 = new Level1Support();
            var level2 = new Level2Support();
            var level3 = new Level3Support();
            level1.SetNext(level2);
            level2.SetNext(level3);

            level1.HandleRequest(new SupportTicket("Password reset", 1));
            level1.HandleRequest(new SupportTicket("Software bug", 2));
            level1.HandleRequest(new SupportTicket("System crash", 3));
        }
    }
}
