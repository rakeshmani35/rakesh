package com.oracle;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		
		 //3 apple, 2 banana, others 1
        List<String> items =
                Arrays.asList("5", "8", "1",
                        "5", "8", "5", "5");
        List<Integer> items1 =
               Arrays.asList(5, 8, 1,
                        5, 8, 5, 5);

        Map<Integer, Long> result =
                items1.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        System.out.println(result);

	}

}
