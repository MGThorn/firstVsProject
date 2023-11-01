package Praktikum_10_25;

public class Bubblesort{
void swap(int[] nums, int i, int j) {
    assert i >= 0 && i < nums.length;
    assert j >= 0 && j < nums.length;
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp; 
}

boolean bubble(int[] numbers) {
    boolean swapped = false;
    for (int i = 0; i < numbers.length - 1; i++) {
        if (numbers[i] > numbers[i + 1]) {
            swap(numbers, i, i + 1);
            swapped = true;
        }
    }
    return swapped;
}

int[] bubblesort(int... numbers) {
    while (bubble(numbers));
    return numbers;
}
}