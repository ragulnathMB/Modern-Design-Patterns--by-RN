// Factory Method – Rust Template
trait Product{}
struct ConcreteProduct; impl Product for ConcreteProduct{}
trait Creator{ fn factory_method(&self)->Box<dyn Product>; }
struct ConcreteCreator; impl Creator for ConcreteCreator{ fn factory_method(&self)->Box<dyn Product>{ Box::new(ConcreteProduct) } }
fn main(){ let creator = ConcreteCreator; creator.factory_method(); }
