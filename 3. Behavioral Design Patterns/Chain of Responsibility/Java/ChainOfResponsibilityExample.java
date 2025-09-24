// Chain of Responsibility Pattern Example in Java
// Support ticket system with different levels of handlers

abstract class SupportHandler {
    protected SupportHandler nextHandler;
    public void setNext(SupportHandler handler) { nextHandler = handler; }
    public abstract void handleRequest(SupportTicket ticket);
}

class SupportTicket {
    private final String issue;
    private final int priority;
    public SupportTicket(String issue, int priority) { this.issue = issue; this.priority = priority; }
    public String getIssue() { return issue; }
    public int getPriority() { return priority; }
}

class Level1Support extends SupportHandler {
    public void handleRequest(SupportTicket ticket) {
        if (ticket.getPriority() <= 1)
            System.out.println("Level 1: Handled '" + ticket.getIssue() + "'");
        else if (nextHandler != null)
            nextHandler.handleRequest(ticket);
        else
            System.out.println("No handler available for '" + ticket.getIssue() + "'");
    }
}

class Level2Support extends SupportHandler {
    public void handleRequest(SupportTicket ticket) {
        if (ticket.getPriority() <= 2)
            System.out.println("Level 2: Handled '" + ticket.getIssue() + "'");
        else if (nextHandler != null)
            nextHandler.handleRequest(ticket);
        else
            System.out.println("No handler available for '" + ticket.getIssue() + "'");
    }
}

class Level3Support extends SupportHandler {
    public void handleRequest(SupportTicket ticket) {
        System.out.println("Level 3: Handled '" + ticket.getIssue() + "'");
    }
}

public class ChainOfResponsibilityExample {
    public static void main(String[] args) {
        SupportHandler level1 = new Level1Support();
        SupportHandler level2 = new Level2Support();
        SupportHandler level3 = new Level3Support();
        level1.setNext(level2);
        level2.setNext(level3);

        level1.handleRequest(new SupportTicket("Password reset", 1));
        level1.handleRequest(new SupportTicket("Software bug", 2));
        level1.handleRequest(new SupportTicket("System crash", 3));
    }
}
