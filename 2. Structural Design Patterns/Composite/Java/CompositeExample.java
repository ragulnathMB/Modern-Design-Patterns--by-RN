// Composite Pattern Example in Java
// File system: File (leaf) and Directory (composite)

import java.util.*;

interface FSItem {
    void display(int depth);
    int getSize();
}

class FSFile implements FSItem {
    private final String name;
    private final int size;
    FSFile(String name, int size) { this.name = name; this.size = size; }
    public void display(int depth) {
        System.out.printf("%sFile: %s (%dKB)%n", " ".repeat(depth*2), name, size);
    }
    public int getSize() { return size; }
}

class Directory implements FSItem {
    private final String name;
    private final List<FSItem> items = new ArrayList<>();
    Directory(String name) { this.name = name; }
    public void add(FSItem item) { items.add(item); }
    public void remove(FSItem item) { items.remove(item); }
    public void display(int depth) {
        System.out.printf("%sDirectory: %s/%n", " ".repeat(depth*2), name);
        for (FSItem it : items) it.display(depth+1);
    }
    public int getSize() {
        int total = 0; for (FSItem it : items) total += it.getSize(); return total;
    }
}

public class CompositeExample {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory docs = new Directory("docs");
        docs.add(new FSFile("readme.txt", 5));
        docs.add(new FSFile("manual.pdf", 150));
        root.add(docs);
        root.add(new FSFile("config.ini", 2));
        root.display(0);
        System.out.printf("Total size: %dKB%n", root.getSize());
    }
}
