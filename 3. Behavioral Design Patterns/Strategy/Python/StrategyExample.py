# Strategy Pattern Example in Python
# Sorter context with BubbleSort and QuickSort strategies

from abc import ABC, abstractmethod

class SortStrategy(ABC):
    @abstractmethod
    def sort(self, data):
        pass

class BubbleSort(SortStrategy):
    def sort(self, data):
        arr = data.copy()
        n = len(arr)
        for i in range(n):
            for j in range(0, n - i - 1):
                if arr[j] > arr[j + 1]:
                    arr[j], arr[j + 1] = arr[j + 1], arr[j]
        print("BubbleSort used")
        return arr

class QuickSort(SortStrategy):
    def sort(self, data):
        arr = data.copy()
        arr.sort()  # use built-in for brevity
        print("QuickSort used")
        return arr

class Sorter:
    def __init__(self, strategy):
        self.strategy = strategy
    
    def set_strategy(self, strategy):
        self.strategy = strategy
    
    def sort(self, data):
        return self.strategy.sort(data)

def main():
    data = [5, 2, 9, 1, 5, 6]
    sorter = Sorter(BubbleSort())
    print(sorter.sort(data))
    sorter.set_strategy(QuickSort())
    print(sorter.sort(data))

if __name__ == "__main__":
    main()
