// Prototype Pattern – Java Template
interface Prototype<T> { T cloneProto(); }
class ConcretePrototype implements Prototype<ConcretePrototype> {
    int data;
    ConcretePrototype(int d){ data=d; }
    public ConcretePrototype cloneProto(){ return new ConcretePrototype(this.data); }
}
public class PrototypeTemplate { public static void main(String[] args){ ConcretePrototype p1=new ConcretePrototype(42); ConcretePrototype p2=p1.cloneProto(); } }
