// Strategy Pattern Example in JavaScript
// Sorter with BubbleSort and QuickSort strategies

class SortStrategy { sort(data){ return data } }

class BubbleSort extends SortStrategy {
  sort(data){
    const arr = [...data]
    for(let i=0;i<arr.length;i++){
      for(let j=0;j<arr.length-i-1;j++){
        if(arr[j] > arr[j+1]) [arr[j], arr[j+1]] = [arr[j+1], arr[j]]
      }
    }
    console.log('BubbleSort used')
    return arr
  }
}

class QuickSort extends SortStrategy {
  sort(data){
    const arr = [...data].sort((a,b)=>a-b)
    console.log('QuickSort used')
    return arr
  }
}

class Sorter {
  constructor(strategy){ this.strategy = strategy }
  setStrategy(strategy){ this.strategy = strategy }
  sort(data){ return this.strategy.sort(data) }
}

(function main(){
  const data = [5,2,9,1,5,6]
  const sorter = new Sorter(new BubbleSort())
  console.log(sorter.sort(data))
  sorter.setStrategy(new QuickSort())
  console.log(sorter.sort(data))
})()
