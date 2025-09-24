// Adapter Pattern – Java Template
// Target expects request(); Adaptee has specificRequest(); Adapter bridges them.

interface Target { void request(); }
class Adaptee { void specificRequest() { /* ... */ } }
class Adapter implements Target { private final Adaptee a = new Adaptee(); public void request(){ a.specificRequest(); } }
public class AdapterTemplate { public static void main(String[] args){ Target t = new Adapter(); t.request(); } }
