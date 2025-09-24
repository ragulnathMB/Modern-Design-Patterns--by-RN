// Abstract Factory Pattern – Rust Example
// Build & run: cargo run --example abstract_factory [windows|mac]

pub trait Button {
    fn paint(&self);
}

pub trait Checkbox {
    fn paint(&self);
}

pub struct WindowsButton;
impl Button for WindowsButton {
    fn paint(&self) {
        println!("Render a button in Windows style.");
    }
}

pub struct MacButton;
impl Button for MacButton {
    fn paint(&self) {
        println!("Render a button in macOS style.");
    }
}

pub struct WindowsCheckbox;
impl Checkbox for WindowsCheckbox {
    fn paint(&self) {
        println!("Render a checkbox in Windows style.");
    }
}

pub struct MacCheckbox;
impl Checkbox for MacCheckbox {
    fn paint(&self) {
        println!("Render a checkbox in macOS style.");
    }
}

pub trait GUIFactory {
    fn create_button(&self) -> Box<dyn Button>;
    fn create_checkbox(&self) -> Box<dyn Checkbox>;
}

pub struct WindowsFactory;
impl GUIFactory for WindowsFactory {
    fn create_button(&self) -> Box<dyn Button> { Box::new(WindowsButton) }
    fn create_checkbox(&self) -> Box<dyn Checkbox> { Box::new(WindowsCheckbox) }
}

pub struct MacFactory;
impl GUIFactory for MacFactory {
    fn create_button(&self) -> Box<dyn Button> { Box::new(MacButton) }
    fn create_checkbox(&self) -> Box<dyn Checkbox> { Box::new(MacCheckbox) }
}

fn paint_app(factory: &dyn GUIFactory) {
    let button = factory.create_button();
    let checkbox = factory.create_checkbox();
    button.paint();
    checkbox.paint();
}

fn main() {
    let args: Vec<String> = std::env::args().collect();
    if args.len() > 1 && args[1].eq_ignore_ascii_case("mac") {
        paint_app(&MacFactory);
    } else {
        paint_app(&WindowsFactory);
    }
}
