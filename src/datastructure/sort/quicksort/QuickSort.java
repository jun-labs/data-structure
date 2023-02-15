package datastructure.sort.quicksort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSort {

    public List<Integer> quickSort(List<Integer> numbers) {
        if (Objects.isNull(numbers))
            throw new IllegalArgumentException("올바르지 않은 값입니다.");
        if (numbers.size() <= 1) {
            return numbers;
        }

        // 가운데 수 찾기
        int pivot = numbers.get(numbers.size() / 2);

        // 가운데 수를 기준으로 분류
        List<Integer> lowerThanPivot = new ArrayList<>();
        List<Integer> equalToPivot = new ArrayList<>();
        List<Integer> bigerThenPivot = new ArrayList<>();

        for (Integer number : numbers) {
            if (number < pivot) lowerThanPivot.add(number);
            else if (number == pivot) equalToPivot.add(number);
            else bigerThenPivot.add(number);
        }

        List<Integer> test = new ArrayList();
        test.addAll(lowerThanPivot);
        test.addAll(equalToPivot);
        test.addAll(bigerThenPivot);

        // 합치기
        return Stream.of(quickSort(lowerThanPivot), equalToPivot, quickSort(bigerThenPivot))
                .flatMap(Collection::stream)
                .collect(Collectors.toUnmodifiableList());
    }

    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(2);
        QuickSort quickSort = new QuickSort();
        ///quickSort.quickSort(list);
        System.out.println(quickSort.quickSort(list));
    }
}
