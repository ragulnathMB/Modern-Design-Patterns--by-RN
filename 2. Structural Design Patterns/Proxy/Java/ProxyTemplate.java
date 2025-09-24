// Proxy Pattern – Java Template

interface Subject { void request(); }
class RealSubject implements Subject { public void request(){ /* heavy work */ } }
class Proxy implements Subject { private RealSubject real; public void request(){ if (real == null) real = new RealSubject(); /* checks/logging */ real.request(); } }
public class ProxyTemplate { public static void main(String[] args){ Subject s = new Proxy(); s.request(); } }
