// Flyweight Pattern Example in Java
// Forest: shares TreeType (intrinsic) among many Tree instances (extrinsic position)

import java.util.*;

class TreeType {
    private final String name;
    private final String color;
    private final String texture;
    TreeType(String name, String color, String texture){ this.name = name; this.color = color; this.texture = texture; }
    void draw(int x, int y){ System.out.printf("Draw %s [%s,%s] at (%d,%d)%n", name, color, texture, x, y); }
}

class TreeFactory {
    private static final Map<String, TreeType> cache = new HashMap<>();
    static TreeType getTreeType(String name, String color, String texture){
        String key = name + "-" + color + "-" + texture;
        return cache.computeIfAbsent(key, k -> new TreeType(name, color, texture));
    }
}

class Tree {
    private final int x, y;
    private final TreeType type;
    Tree(int x, int y, TreeType type){ this.x = x; this.y = y; this.type = type; }
    void draw(){ type.draw(x, y); }
}

class Forest {
    private final List<Tree> trees = new ArrayList<>();
    void plant(int x, int y, String name, String color, String texture){ trees.add(new Tree(x, y, TreeFactory.getTreeType(name, color, texture))); }
    void draw(){ for (Tree t : trees) t.draw(); }
}

public class FlyweightExample {
    public static void main(String[] args){
        Forest forest = new Forest();
        for (int i=0;i<5;i++) forest.plant(i, i*2, "Oak", "Green", "Rough");
        for (int i=0;i<3;i++) forest.plant(i+10, i*3, "Pine", "DarkGreen", "Smooth");
        forest.draw();
    }
}
