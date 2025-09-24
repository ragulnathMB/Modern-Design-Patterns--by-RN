// Chain of Responsibility Pattern – Java Template

abstract class Handler {
    protected Handler nextHandler;
    public void setNext(Handler handler) { nextHandler = handler; }
    public abstract void handleRequest(Request request);
}

class Request { private String data; public String getData() { return data; } public void setData(String data) { this.data = data; } }

class ConcreteHandlerA extends Handler {
    public void handleRequest(Request request) {
        if (canHandle(request)) processRequest(request);
        else if (nextHandler != null) nextHandler.handleRequest(request);
    }
    private boolean canHandle(Request request) { return true; /* condition */ }
    private void processRequest(Request request) { /* handle */ }
}

class ConcreteHandlerB extends Handler {
    public void handleRequest(Request request) {
        if (canHandle(request)) processRequest(request);
        else if (nextHandler != null) nextHandler.handleRequest(request);
    }
    private boolean canHandle(Request request) { return true; /* condition */ }
    private void processRequest(Request request) { /* handle */ }
}

public class ChainOfResponsibilityTemplate {
    public static void main(String[] args) {
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        handlerA.setNext(handlerB);
        handlerA.handleRequest(new Request());
    }
}
