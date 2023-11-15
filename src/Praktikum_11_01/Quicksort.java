package Praktikum_11_1;
public class Quicksort {
    void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }
    
    void shift(int[] numbers, int from, int to) {
        int tmp = numbers[to];
        for (int i = to - 1; i >= from; i--)
            numbers[i + 1] = numbers[i];
        numbers[from] = tmp;
    }
    
    void qs(int[] numbers, int first, int last) {
        if (first >= last) return;
        int i = first - 1;
        for (int j = first; j < last; j++) {
            if (numbers[j] < numbers[last]) {
                i = i + 1;
                swap(numbers, i, j);
            }
        }
        shift(numbers, i + 1, last);
        qs(numbers, first, i);
        qs(numbers, i + 2, last);
    }
    
    int[] quicksort(int ... numbers) {
        qs(numbers, 0, numbers.length - 1);
        return numbers;
    }
}
