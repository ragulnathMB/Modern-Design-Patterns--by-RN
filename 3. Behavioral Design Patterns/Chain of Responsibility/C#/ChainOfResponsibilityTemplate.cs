// Chain of Responsibility Pattern – C# Template

namespace ChainOfResponsibilityTemplate
{
    abstract class Handler
    {
        protected Handler nextHandler;
        public void SetNext(Handler handler) { nextHandler = handler; }
        public abstract void HandleRequest(Request request);
    }

    class Request { public string Data { get; set; } }

    class ConcreteHandlerA : Handler
    {
        public override void HandleRequest(Request request)
        {
            if (CanHandle(request))
                ProcessRequest(request);
            else if (nextHandler != null)
                nextHandler.HandleRequest(request);
        }
        private bool CanHandle(Request request) { return true; /* condition */ }
        private void ProcessRequest(Request request) { /* handle */ }
    }

    class ConcreteHandlerB : Handler
    {
        public override void HandleRequest(Request request)
        {
            if (CanHandle(request))
                ProcessRequest(request);
            else if (nextHandler != null)
                nextHandler.HandleRequest(request);
        }
        private bool CanHandle(Request request) { return true; /* condition */ }
        private void ProcessRequest(Request request) { /* handle */ }
    }

    class Program
    {
        static void Main()
        {
            var handlerA = new ConcreteHandlerA();
            var handlerB = new ConcreteHandlerB();
            handlerA.SetNext(handlerB);
            handlerA.HandleRequest(new Request());
        }
    }
}
