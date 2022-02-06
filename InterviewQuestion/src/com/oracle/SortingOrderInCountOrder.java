package com.oracle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// (5,8,1,5,8,5) -> (5,5,5,8,8,1)
public class SortingOrderInCountOrder {

	public static void sortBeforeJava8(int[] arr) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		/*
		 * for(int i = 0; i < arr.length; i++){
		 * 
		 * if(map.containsKey(arr[i])){
		 * 
		 * map.put(arr[i], map.get(arr[i])+1);
		 * 
		 * 
		 * 
		 * }else { map.put(arr[i],1);
		 * 
		 * } }
		 */

		Arrays.stream(arr).forEach(x -> {

			if (map.containsKey(x)) {
				map.put(x, map.get(x) + 1);
			} else {
				map.put(x, 1);
			}
		});

		List<Integer> list = new ArrayList();
		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(x -> {
			int v = x.getValue();
			while (v > 0) {
				list.add(x.getKey());
				v--;
			}
		});

		System.out.println(list);

	}

	public static void sortWithJava8(int[] arr) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		Arrays.stream(arr).forEach(x -> {

			if (map.containsKey(x)) {
				map.put(x, map.get(x) + 1);
			} else {
				map.put(x, 1);
			}
		});

		List<Integer> list = new ArrayList();
		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(x -> {
			int v = x.getValue();
			while (v > 0) {
				list.add(x.getKey());
				v--;
			}
		});

		System.out.println(list);

	}

	public static void sortWithJava8_new(int[] arr) {

		// this is only one way to convert int arr to list of integer
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

		// convert list to map
		Map<Integer, Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		// sort map by value
		Map<Integer, Long> collectMap = map.entrySet().stream()
					  .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		              .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
		            		  (oldValue, newValue) -> oldValue,LinkedHashMap::new));
		
		// sort map by value
				Map<Integer, Long> collect = map.entrySet().stream()
							  .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				              .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
					 
	
		List<Integer> result = new ArrayList();
		collectMap.entrySet().forEach(x -> {
			int v = x.getValue().intValue();
			while (v > 0) {
				result.add(x.getKey());
				v--;
			}
		});


		System.out.println(result);

	}

	public static void main(String[] args) {
		int[] arr = { 5, 8, 1, 5, 8, 5, 8, 5 };

		sortWithJava8(arr);
		
		System.out.println();
		
		sortWithJava8_new(arr);

	}

}
