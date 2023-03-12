import java.util.ArrayList;

public class SearchAndSort {
    private SearchAndSort(){}

    public static void sortStr(ArrayList<String> sortArray) {
        sortStr(sortArray, 0, sortArray.size() - 1);
    }

    public static <T extends Comparable> void sort(ArrayList<T> sortArray) {
        sort(sortArray, 0, sortArray.size() - 1, 0);
    }

    public static <T extends Comparable> void sort(ArrayList<T> sortArray, int sortType) {
        sort(sortArray, 0, sortArray.size() - 1, sortType);
    }

        public static <T extends Comparable> void insert(T insertionObject, ArrayList<T> arrayList) {
            insert(insertionObject, arrayList, 0, arrayList.size() - 1, 0);
        }

    public static <T extends Comparable> void insert(T insertionObject, ArrayList<T> arrayList, int sortType) {
        insert(insertionObject, arrayList, 0, arrayList.size() - 1, sortType);
    }

    public static <T extends Comparable> boolean contains(T target, ArrayList<T> searchArray) {
        return contains(target, searchArray, 0, searchArray.size() - 1, 0);
    }

    public static <T extends Comparable> boolean contains(T target, ArrayList<T> searchArray, int sortType) {
        return contains(target, searchArray, 0, searchArray.size() - 1, sortType);
    }

    /*
    Beginning of private methods:
    */

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

    private static void sortStr(ArrayList<String> sortArray, int left, int right) {
        if (left >= right) return;

        String pivot = sortArray.get((left + right) / 2);
        int index = partitionStr(sortArray, left, right, pivot);
        sortStr(sortArray, left, index - 1);
        sortStr(sortArray, index, right);
    }

    private static int partitionStr(ArrayList<String> sortArray, int left, int right, String pivot) {
        while (left <= right) {
            while (sortArray.get(left).compareTo(pivot) < 0) {
                left++;
            }
            while (sortArray.get(right).compareTo(pivot) > 0) {
                right--;
            }

            if (left <= right) {
                swapStr(sortArray, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swapStr(ArrayList<String> sortArray, int left, int right) {
        sortArray.set(left, sortArray.set(right, sortArray.get(left)));
    }

    private static <T extends Comparable> void insert(T toInsert, ArrayList<T> searchArray, int low, int high, int sortType) {
        if (low == high) {
            searchArray.add(low, toInsert);
            return;
        }

        int mid = (low + high) / 2;

        if (toInsert.compareTo(searchArray.get(mid), sortType) < 0) {
            insert(toInsert, searchArray, low, mid, sortType);
        } else {
            insert(toInsert, searchArray, mid + 1, high, sortType);
        }
    }

    private static <T extends Comparable> boolean contains(T target, ArrayList<T> searchArray, int low, int high, int sortType) {
        if (low == high) {
            return false;
        }

        int mid = (low + high) / 2;
        T check = searchArray.get(mid);

        if (check.equals(target)) return true;

        return (target.compareTo(check, sortType) < 0) ? contains(target, searchArray, low, mid, sortType)
                : contains(target, searchArray, mid + 1, high, sortType);
    }
}
