// Strategy Pattern – Java Template

import java.util.*;

interface Strategy { List<Integer> execute(List<Integer> data); }
class ConcreteStrategyA implements Strategy { public List<Integer> execute(List<Integer> data){ return data; } }
class ConcreteStrategyB implements Strategy { public List<Integer> execute(List<Integer> data){ return data; } }
class Context { private Strategy s; Context(Strategy s){ this.s = s; } void set(Strategy s){ this.s = s; } List<Integer> doWork(List<Integer> data){ return s.execute(data); } }
public class StrategyTemplate { public static void main(String[] args){ new Context(new ConcreteStrategyA()).doWork(new ArrayList<>()); } }
