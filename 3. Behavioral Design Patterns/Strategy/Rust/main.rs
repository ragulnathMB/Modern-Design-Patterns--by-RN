// Strategy Pattern Example in Rust
// Sorter with BubbleSort and QuickSort strategies

trait SortStrategy {
    fn sort(&self, data: &[i32]) -> Vec<i32>;
}

struct BubbleSort;
impl SortStrategy for BubbleSort {
    fn sort(&self, data: &[i32]) -> Vec<i32> {
        let mut arr = data.to_vec();
        for i in 0..arr.len() {
            for j in 0..arr.len().saturating_sub(i + 1) {
                if arr[j] > arr[j + 1] {
                    arr.swap(j, j + 1);
                }
            }
        }
        println!("BubbleSort used");
        arr
    }
}

struct QuickSort;
impl SortStrategy for QuickSort {
    fn sort(&self, data: &[i32]) -> Vec<i32> {
        let mut arr = data.to_vec();
        arr.sort(); // brevity
        println!("QuickSort used");
        arr
    }
}

struct Sorter<T: SortStrategy> {
    strategy: T,
}

impl<T: SortStrategy> Sorter<T> {
    fn new(strategy: T) -> Self { Self { strategy } }
    fn with_strategy<U: SortStrategy>(self, strategy: U) -> Sorter<U> { Sorter { strategy } }
    fn sort(&self, data: &[i32]) -> Vec<i32> { self.strategy.sort(data) }
}

fn main() {
    let data = vec![5, 2, 9, 1, 5, 6];
    let sorter = Sorter::new(BubbleSort);
    println!("{:?}", sorter.sort(&data));
    let sorter = sorter.with_strategy(QuickSort);
    println!("{:?}", sorter.sort(&data));
}
