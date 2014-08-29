package by.azargan.problems.problem34;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Aliaksei_Vihuro
 */
public class NumberDecomposition {
    public static List<Integer> getDigitList(Integer number) {
        List<Integer> resultList = new ArrayList<>();
        while (number != 0) {
            resultList.add(number % 10);
            number /= 10;
        }
        return resultList;
    }

    public static List<Integer> getDistinctDigitList(Integer number) {
        return getDigitList(number).stream().distinct().collect(Collectors.toList());
    }
}
