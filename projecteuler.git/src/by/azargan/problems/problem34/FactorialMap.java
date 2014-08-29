package by.azargan.problems.problem34;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Aliaksei_Vihuro
 */
public class FactorialMap {
    private final Map<Integer, Integer> factorials;

    public FactorialMap() {
        this.factorials = new HashMap<>();
    }

    public Integer getFactorial(Integer number) {
        Integer answer = factorials.get(number);
        if (answer == null) {
            answer = calculateFactorial(number);
        }
        return answer;
    }

    private Integer calculateFactorial(Integer number) {
        Integer factorial = 1;
        int localNumber = number;
        while (localNumber > 1) {
            factorial *= localNumber--;
        }
        factorials.put(number, factorial);
        return factorial;
    }
}
