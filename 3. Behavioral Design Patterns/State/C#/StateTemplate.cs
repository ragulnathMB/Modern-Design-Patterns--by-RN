// State Pattern – C# Template

namespace StateTemplate
{
    interface IState { void Handle(Context context); }

    class Context
    {
        private IState _state;
        public Context(IState initialState) { _state = initialState; }
        public void SetState(IState state) { _state = state; }
        public void Request() { _state.Handle(this); }
    }

    class ConcreteStateA : IState { public void Handle(Context context) { /* work */ context.SetState(new ConcreteStateB()); } }
    class ConcreteStateB : IState { public void Handle(Context context) { /* work */ context.SetState(new ConcreteStateA()); } }

    class Program { static void Main() { var ctx = new Context(new ConcreteStateA()); ctx.Request(); ctx.Request(); } }
}
