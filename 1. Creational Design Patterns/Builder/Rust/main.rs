// Builder Pattern – Rust Example

struct Meal {
    burgers: u8,
    drinks: u8,
}

trait MealBuilder {
    fn add_burger(&mut self);
    fn add_drink(&mut self);
    fn get_result(&self) -> Meal;
}

struct KidsMealBuilder { meal: Meal }
impl KidsMealBuilder {
    fn new() -> Self { Self{ meal: Meal{ burgers:0, drinks:0 } }}
}
impl MealBuilder for KidsMealBuilder {
    fn add_burger(&mut self) { self.meal.burgers += 1; }
    fn add_drink(&mut self) { self.meal.drinks += 1; }
    fn get_result(&self) -> Meal { Meal{ burgers:self.meal.burgers, drinks:self.meal.drinks } }
}

struct Director;
impl Director {
    fn construct<B: MealBuilder>(builder: &mut B) {
        builder.add_burger();
        builder.add_drink();
    }
}

fn main() {
    let mut builder = KidsMealBuilder::new();
    Director::construct(&mut builder);
    let meal = builder.get_result();
    println!("Kids meal => burgers: {}, drinks: {}", meal.burgers, meal.drinks);
}
