import java.util.ArrayList;

public class SearchAndSort {
    private SearchAndSort(){}

    public static <T extends Comparable> void sort(ArrayList<T> sortArray) {
        sort(sortArray, 0, sortArray.size() - 1, 0);
    }

    private static <T extends Comparable> void sort(ArrayList<T> sortArray, int left, int right, int sortType) {
        if (left >= right) return;

        Comparable pivot = sortArray.get((left + right) / 2);
        int index = partition(sortArray, left, right, pivot, sortType);
        sort(sortArray, left, index - 1, sortType);
        sort(sortArray, index, right, sortType);
    }

    private static <T extends Comparable> int partition(ArrayList<T> sortArray, int left, int right, Comparable pivot, int sortType) {
        while (left <= right) {
            while (sortArray.get(left).compareTo(pivot, sortType) < 0) {
                left++;
            }
            while (sortArray.get(right).compareTo(pivot, sortType) > 0) {
                right--;
            }

            if (left <= right) {
                swap(sortArray, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static <T extends Comparable> void swap(ArrayList<T> sortArray, int left, int right) {
        sortArray.set(left, sortArray.set(right, sortArray.get(left)));
    }
}
