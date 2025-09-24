// Builder Pattern – Java Template
interface Builder {
    void buildPartA();
    void buildPartB();
    Product getResult();
}
class Product {}
class ConcreteBuilder implements Builder {
    private final Product product = new Product();
    public void buildPartA(){}
    public void buildPartB(){}
    public Product getResult(){return product;}
}
class Director {
    void construct(Builder b){
        b.buildPartA();
        b.buildPartB();
    }
}
public class BuilderTemplate {
    public static void main(String[] args){
        Builder builder = new ConcreteBuilder();
        new Director().construct(builder);
    }
}
