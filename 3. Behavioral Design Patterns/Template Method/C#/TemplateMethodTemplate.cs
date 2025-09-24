// Template Method Pattern – C# Template

using System;

namespace TemplateMethodTemplate
{
    abstract class AbstractClass
    {
        public void TemplateMethod()
        {
            StepOne();
            StepTwo();
            Hook();
        }
        protected abstract void StepOne();
        protected abstract void StepTwo();
        protected virtual void Hook() { /* optional override */ }
    }

    class ConcreteClassA : AbstractClass
    {
        protected override void StepOne() => Console.WriteLine("A: Step 1");
        protected override void StepTwo() => Console.WriteLine("A: Step 2");
    }

    class ConcreteClassB : AbstractClass
    {
        protected override void StepOne() => Console.WriteLine("B: Step 1");
        protected override void StepTwo() => Console.WriteLine("B: Step 2");
        protected override void Hook() => Console.WriteLine("B: Hook");
    }

    class Program { static void Main() { new ConcreteClassA().TemplateMethod(); new ConcreteClassB().TemplateMethod(); } }
}
