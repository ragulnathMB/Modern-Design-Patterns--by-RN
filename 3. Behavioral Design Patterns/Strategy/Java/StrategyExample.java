// Strategy Pattern Example in Java
// Sorter with BubbleSort and QuickSort strategies

import java.util.*;

interface SortStrategy { List<Integer> sort(List<Integer> data); }

class BubbleSort implements SortStrategy {
    public List<Integer> sort(List<Integer> data){
        List<Integer> arr = new ArrayList<>(data);
        for (int i=0;i<arr.size();i++)
            for (int j=0;j<arr.size()-i-1;j++)
                if (arr.get(j) > arr.get(j+1)) Collections.swap(arr, j, j+1);
        System.out.println("BubbleSort used");
        return arr;
    }
}

class QuickSort implements SortStrategy {
    public List<Integer> sort(List<Integer> data){
        List<Integer> arr = new ArrayList<>(data);
        Collections.sort(arr); // brevity
        System.out.println("QuickSort used");
        return arr;
    }
}

class Sorter {
    private SortStrategy strategy;
    Sorter(SortStrategy s){ this.strategy = s; }
    void setStrategy(SortStrategy s){ this.strategy = s; }
    List<Integer> sort(List<Integer> data){ return strategy.sort(data); }
}

public class StrategyExample {
    public static void main(String[] args){
        List<Integer> data = Arrays.asList(5,2,9,1,5,6);
        Sorter sorter = new Sorter(new BubbleSort());
        System.out.println(sorter.sort(data));
        sorter.setStrategy(new QuickSort());
        System.out.println(sorter.sort(data));
    }
}
