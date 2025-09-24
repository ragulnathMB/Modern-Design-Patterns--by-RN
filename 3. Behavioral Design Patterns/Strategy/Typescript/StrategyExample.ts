// Strategy Pattern Example in TypeScript
// Sorter with BubbleSort and QuickSort strategies

interface SortStrategy { sort(data: number[]): number[] }

class BubbleSort implements SortStrategy {
  sort(data: number[]): number[] {
    const arr = [...data]
    for (let i = 0; i < arr.length; i++) {
      for (let j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]]
      }
    }
    console.log('BubbleSort used')
    return arr
  }
}

class QuickSort implements SortStrategy {
  sort(data: number[]): number[] {
    const arr = [...data].sort((a, b) => a - b)
    console.log('QuickSort used')
    return arr
  }
}

class Sorter {
  constructor(private strategy: SortStrategy) {}
  setStrategy(s: SortStrategy) { this.strategy = s }
  sort(data: number[]): number[] { return this.strategy.sort(data) }
}

;(function main(){
  const data = [5,2,9,1,5,6]
  const sorter = new Sorter(new BubbleSort())
  console.log(sorter.sort(data))
  sorter.setStrategy(new QuickSort())
  console.log(sorter.sort(data))
})()

export {}
