package duringWork;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AlgorithmsForNeed {

    /**
     * find not common elements from two lists
     * @param firstList
     * @param secondList
     * @return
     */
    public static List<Long> findNotCommon(List<Long> firstList, List<Long> secondList) {
        List<Long> list = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        List<Long> otherList = Arrays.asList(2L, 3L, 5L);

        List<Long> result = list.stream()
                .distinct()
                .filter(Predicate.not(otherList::contains)).toList();
        return result;
    }

}
