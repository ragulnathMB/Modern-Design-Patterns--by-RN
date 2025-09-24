// Flyweight Pattern – Java Template

import java.util.*;

class Flyweight {
    // intrinsic, immutable data
}

class FlyweightFactory {
    private static final Map<String, Flyweight> cache = new HashMap<>();
    static Flyweight get(String key){
        return cache.computeIfAbsent(key, k -> new Flyweight());
    }
}

class Context {
    private final Flyweight fw;
    Context(String key){ this.fw = FlyweightFactory.get(key); }
    void operation(/* extrinsic params */){ /* use fw + extrinsic */ }
}

public class FlyweightTemplate {
    public static void main(String[] args){ new Context("key").operation(); }
}
