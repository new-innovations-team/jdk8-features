package arrays_class;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ArraysDemo {
	
	// dummy data
	private static byte[] byteArrayPrimitiveType = { 10, 5, -44, -99, 47, 19, -35 };
	private static Byte[] byteArrayWrapperType = { 10, 5, -44, -99, 47, 19, -35 };

	private static short[] shortArrayPrimitiveType = { 10, 5, -44, -99, 47, 198, -35 };
	private static Short[] shortArrayWrapperType = { 10, 5, -44, -99, 47, 195, -35 };

	private static int[] intArrayPrimitiveType = { 10, 5, -44, -99, 47, 198, -35 };
	private static Integer[] intArrayWrapperType = { 10, 5, -44, -99, 47, 198, -35 ,5,10};

	private static long[] longArrayPrimitiveType = { 10l, 5, -44l, -99, 47, 198, -35 };
	private static Long[] longArrayWrapperType = { 10l, 5l, -44l, -99l, 47l, 198l, -35l };

	private static float[] floatArrayPrimitiveType = { 10.6f, 5.8f, -44.7f, -99.1f, 47.4f, 198.9f, -35.7f };
	private static Float[] floatArrayWrapperType = { 10.6f, 5.8f, -44.7f, -99.1f, 47.4f, 198.9f, -35.7f };

	private static double[] doubleArrayPrimitiveType = { 10.6d, 5.8d, -44.7d, -99.1d, 47.4d, 198.9d, -35.7f };
	private static Double[] doubleArrayWrapperType = { 10.6d, 5.8d, -44.7d, -99.1d, 47.4d, 198.9d, -35.7d };

	private static char[] charArrayPrimitiveType = { 'A', 'Y', 'p','b' };
	private static Character[] charArrayWrapperType = { 'A', 'Y', 'R','p','b'  };

	private static String[] stringArray = { "punya", "Partha", "Aswini", "punya","Arabind" };
	private static List<String> stringList = Arrays.asList("punya", "Partha", "Aswini", "punya","Arabind");

	public static void main(String[] args) throws IOException {
		
		convertAnyArrayToStream();
		
		largest_smallest_Item_From_any_primitive_Array();
		largest_smallest_Item_From_any_wrapper_Array();
		
		removeDuplicateItemsFromAnyArray();
		
		countNoOfOccurancesOfPerticularItemInAnyArray();
		countNoOfOccurancesOfEachItemInAnyArray();
		countNoOfOccurancesOfEachItemwithRangeInAnyArray();
		
		sortAnyArray();
		parallelSortAnyArray();
		
		convertStringToCharArray();
		
		convertAnyArrayToList();
		convertAnyArrayToSet();
		
		namesStartingWithSpecificCharInStringArray();
		namesStartingWithSpecificCharInStringList();
		sortContentOfFile();
		
	}
	
	private static void largest_smallest_Item_From_any_primitive_Array() {
		
	    int max1 = Arrays.stream(intArrayPrimitiveType).max().getAsInt();
		//int max = Arrays.stream(intArrayWrapperType).max().getAsInt(); //CE
	    System.out.println(max1);
	    
	    int min1 = Arrays.stream(intArrayPrimitiveType).min().getAsInt();
	    // int min1 = Arrays.stream(intArrayWrapperType).min().getAsInt(); //CE
	    System.out.println(min1);
	    
	    long max2 = Arrays.stream(longArrayPrimitiveType).max().getAsLong();
		//long max2 = Arrays.stream(longArrayWrapperType).max().getAsLong(); //CE
	    System.out.println(max2);
	    
	    long min2 = Arrays.stream(longArrayPrimitiveType).min().getAsLong();
	    // long min2 = Arrays.stream(longArrayWrapperType).min().getAsLong(); //CE
	    System.out.println(min2);
	    
	    double max3 = Arrays.stream(doubleArrayPrimitiveType).max().getAsDouble();
		//double max3 = Arrays.stream(doubleArrayWrapperType).max().getAsDouble(); //CE
	    System.out.println(max3);
	    
	    double min3 = Arrays.stream(doubleArrayPrimitiveType).min().getAsDouble();
	    // double min3 = Arrays.stream(doubleArrayWrapperType).min().getAsDouble(); //CE
	    System.out.println(min3);
	}
	
	private static void largest_smallest_Item_From_any_wrapper_Array() {
		
		Comparator<Byte> byteComparator = (Byte num1, Byte num2) -> num1.compareTo(num2); // ascending
		int max1 = Arrays.stream(byteArrayWrapperType).max(byteComparator).get();
		//or
		//int max1 = Arrays.asList(byteArrayWrapperType).stream().max(byteComparator).get();
		System.out.println(max1);
		
		Comparator<Short> shortComparator = (Short num1, Short num2) -> num1.compareTo(num2); // ascending
		int max2 = Arrays.stream(shortArrayWrapperType).max(shortComparator).get();
		//OR
		//int max2 = Arrays.asList(shortArrayWrapperType).stream().max(shortComparator).get();
		System.out.println(max2);

		Comparator<Integer> intComparator = (Integer num1, Integer num2) -> num1.compareTo(num2); // ascending
		int max3 = Arrays.stream(intArrayWrapperType).max(intComparator).get();
		//OR
		//int max3 = Arrays.asList(intArrayWrapperType).stream().max(intComparator).get();
		System.out.println(max3);
		
		Comparator<Long> longComparator = (Long num1, Long num2) -> num1.compareTo(num2); // ascending
		Long max4 = Arrays.stream(longArrayWrapperType).max(longComparator).get();
		//OR
		//Long max4 = Arrays.asList(longArrayWrapperType).stream().max(longComparator).get();
		System.out.println(max4);
		
		Comparator<Float> floatComparator = (Float num1, Float num2) -> num1.compareTo(num2); // ascending
		Float max5 = Arrays.stream(floatArrayWrapperType).max(floatComparator).get();
		//OR
		//Float max5 = Arrays.asList(floatArrayWrapperType).stream().max(floatComparator).get();
		System.out.println(max5);
		
		Comparator<Double> doubleComparator = (Double num1, Double num2) -> num1.compareTo(num2); // ascending
		Double max6 = Arrays.stream(doubleArrayWrapperType).max(doubleComparator).get();
		//OR
		//Double max6 = Arrays.asList(doubleArrayWrapperType).stream().max(doubleComparator).get();
		System.out.println(max6);

	}
	
private static void countNoOfOccurancesOfEachItemInAnyArray() {
		
		// way-01
		List<Integer> list = Arrays.asList(intArrayWrapperType);
		Set<Integer> set = new HashSet<Integer>(list);
		for (Integer item : set)
			System.out.println(item + ": " + Collections.frequency(list, item));

		// way-02
		Map<Integer, Long> counts = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		System.out.println(counts);
	
	}

	private static void countNoOfOccurancesOfPerticularItemInAnyArray() {
		
		//ex-01
		List<Integer> list3 = Arrays.asList(intArrayWrapperType);
		long count = list3.stream().filter(item -> 11 == item).count();
		System.out.println(count);
		
		//ex-02
		List<String> list = Arrays.asList(stringArray);
		count = list.stream().filter(item -> "punya".equalsIgnoreCase(item)).count();
		System.out.println(count);
		
		//count the no items starts with A.
		count = Arrays.stream(stringArray).filter(item -> item.startsWith("A")).count();
	}
	
	private static void countNoOfOccurancesOfEachItemwithRangeInAnyArray() {
		Map<Integer, Long> map = Arrays.stream(intArrayWrapperType).filter(item -> item >=10 && item <=50).collect(Collectors.groupingBy(item -> item, Collectors.counting()));
		System.out.println(map);
		
	}

	private static void removeDuplicateItemsFromAnyArray() {
		
		List<Byte> list1 = Arrays.asList(byteArrayWrapperType);
		Set<Byte> set1 = new HashSet<>(list1);
		System.out.println(set1);
		
		//Byte[] res1 = (Byte[]) Arrays.stream(byteArrayPrimitiveType).distinct().toArray(); //CE
		Byte[] res2 = (Byte[]) Arrays.stream(byteArrayWrapperType).distinct().toArray();
		System.out.println(res2);
		
		List<Short> list2 = Arrays.asList(shortArrayWrapperType);
		Set<Short> set2 = new HashSet<>(list2);
		System.out.println(set2);

		List<Integer> list3 = Arrays.asList(intArrayWrapperType);
		Set<Integer> set3 = new HashSet<>(list3);
		System.out.println(set3);
		
		List<Float> list4 = Arrays.asList(floatArrayWrapperType);
		Set<Float> set4 = new HashSet<>(list4);
		System.out.println(set4);
		
		List<Long> list5 = Arrays.asList(longArrayWrapperType);
		Set<Long> set5 = new HashSet<>(list5);
		System.out.println(set5);
		
		
		List<Double> list6 = Arrays.asList(doubleArrayWrapperType);
		Set<Double> set6 = new HashSet<>(list6);
		System.out.println(set6);
		
		List<String> list7 = Arrays.asList(stringArray);
		Set<String> set7 = new HashSet<>(list7);
		System.out.println(set7);
		
	}



	private static void convertAnyArrayToStream() {
		
		//@@@@@@ way-01

		// Arrays.stream(byteArrayPrimitiveType).forEach(System.out::print);//CE
		// Arrays.stream(shortArrayPrimitiveType).forEach(System.out::print);//CE
		
		IntStream s = Arrays.stream(intArrayPrimitiveType);
		s.forEach(System.out::println);
		//s.forEachOrdered(System.out::println);
		
		Arrays.stream(intArrayPrimitiveType).forEach(System.out::print);
		//Arrays.stream(intArrayPrimitiveType,2,3).forEach(System.out::print);
		
		LongStream s2 = Arrays.stream(longArrayPrimitiveType);
		s2.forEach(System.out::println);
		
		Arrays.stream(longArrayPrimitiveType).forEach(System.out::print);
		//Arrays.stream(longArrayPrimitiveType,2,2).forEach(System.out::print);
		// Arrays.stream(floatArrayPrimitiveType).forEach(System.out::print);//CE
		
		DoubleStream s3 = Arrays.stream(doubleArrayPrimitiveType);
		s3.forEach(System.out::println);
		
		Arrays.stream(doubleArrayPrimitiveType).forEach(System.out::print);
		//Arrays.stream(doubleArrayPrimitiveType,3,2).forEach(System.out::print);
		

		//@@@@@@ way-02
		
		Stream<byte[]> stream01 = Stream.of(byteArrayPrimitiveType);
		stream01.forEach(System.out::println);
		
		Stream<Byte> stream02 = Stream.of(byteArrayWrapperType);
		stream02.forEach(System.out::println);
	
		Stream<short[]> stream03 = Stream.of(shortArrayPrimitiveType);
		stream03.forEach(System.out::println);
		
		Stream<Short> stream04 = Stream.of(shortArrayWrapperType);
		stream04.forEach(System.out::println);
		
		Stream<int[]> stream1 = Stream.of(intArrayPrimitiveType);
		stream1.forEach(System.out::println);
		
		Stream<Integer> stream3 = Stream.of(intArrayWrapperType);
		stream3.forEach(System.out::println);
				
		Stream.of(byteArrayPrimitiveType).forEach(System.out::print);
		Stream.of(byteArrayWrapperType).forEachOrdered(System.out::print);
		
		Stream.of(shortArrayPrimitiveType).forEach(System.out::print);
		Stream.of(shortArrayWrapperType).forEachOrdered(System.out::print);
		
		Stream.of(intArrayPrimitiveType).forEach(System.out::print);
		Stream.of(intArrayWrapperType).forEachOrdered(System.out::print);
		
		Stream.of(longArrayPrimitiveType).forEachOrdered(System.out::print);
		Stream.of(longArrayWrapperType).forEachOrdered(System.out::print);
		
		Stream.of(floatArrayPrimitiveType).forEachOrdered(System.out::print);
		Stream.of(floatArrayWrapperType).forEachOrdered(System.out::print);
		
		Stream.of(doubleArrayPrimitiveType).forEachOrdered(System.out::print);
		Stream.of(doubleArrayWrapperType).forEachOrdered(System.out::print);
		
	}

	private static void convertAnyArrayToList() {

		//List<byte> list001 = Arrays.asList(byteArrayWrapperType);//CE
		List<Byte> list001 = Arrays.asList(byteArrayWrapperType);
		System.out.println("byte array=" + list001.toString());

		//List<short> list002 = Arrays.asList(shortArrayWrapperType); //CE
		List<Short> list002 = Arrays.asList(shortArrayWrapperType);
		System.out.println("short array=" + list002.toString());

		// way-01
		List<Integer> list01 = new ArrayList<>();
		for (Integer i : intArrayPrimitiveType) {
			list01.add(i);
		}
		System.out.println(list01);

		// way-02
		
		List<Integer> list03 = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(list03);

		List<Integer> list3 = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 });
		System.out.println(list3);

		// way-03
		//List<Integer> list02 = Arrays.asList(intArrayPrimitiveType); //CE
		List<Integer> list2 = Arrays.asList(intArrayWrapperType);
		System.out.println(list2);

		// List<float> list4 = Arrays.asList(floatArray1); //CE
		// System.out.println(list4);

		List<Float> list4 = Arrays.asList(floatArrayWrapperType);
		System.out.println(list4);

		// List<long> list5 = Arrays.asList(longArray1); //CE
		// System.out.println(list5);

		// List<double> list6 = Arrays.asList(doubleArray1); //CE
		// System.out.println(list6);

		List<Double> list6 = Arrays.asList(doubleArrayWrapperType);
		System.out.println(list6);

		// List<char> list003 = Arrays.asList(charArray1); //CE
		// System.out.println(list003);

		List<Character> list003 = Arrays.asList(charArrayWrapperType);
		System.out.println(list003);

		// converting string array to string list
		List<String> list7 = Arrays.asList("Jon", "Ajeet", "Steve", "Ajeet", "Jon", "Ajeet");
		System.out.println(list7);

		// converting string array to string list
		List<String> list8 = Arrays.asList(stringArray);
		System.out.println(list8);
	}
	
	
	private static void convertAnyArrayToSet() {
		
		//List<Integer> list = Arrays.asList(intArrayPrimitiveType); //CE
		List<Integer> list = Arrays.asList(intArrayWrapperType);
		Set<Integer> set = new HashSet<>(list);
		System.out.println(set);
	}

	public static void sortAnyArray() {
	
		
		// ***************************************************** with both primitive and wrapper  type ********************************************************

		// way-01 , sorting int array in ascending order

		Arrays.sort(byteArrayPrimitiveType);
		System.out.println("byte arr after sort:" + Arrays.toString(byteArrayPrimitiveType));

		Arrays.sort(byteArrayWrapperType);
		System.out.println("byte arr after sort:" + Arrays.toString(byteArrayWrapperType));

		Arrays.sort(shortArrayPrimitiveType);
		System.out.println(Arrays.toString(shortArrayPrimitiveType));

		Arrays.sort(shortArrayWrapperType);
		System.out.println(Arrays.toString(shortArrayWrapperType));

		Arrays.sort(intArrayPrimitiveType);
		System.out.println(Arrays.toString(intArrayPrimitiveType));

		Arrays.sort(intArrayWrapperType);
		System.out.println(Arrays.toString(intArrayWrapperType));

		Arrays.sort(floatArrayPrimitiveType);
		System.out.println(Arrays.toString(floatArrayPrimitiveType));

		Arrays.sort(floatArrayWrapperType);
		System.out.println(Arrays.toString(floatArrayWrapperType));

		Arrays.sort(longArrayPrimitiveType);
		System.out.println(Arrays.toString(longArrayPrimitiveType));

		Arrays.sort(doubleArrayPrimitiveType);
		System.out.println(Arrays.toString(doubleArrayPrimitiveType));

		Arrays.sort(doubleArrayWrapperType);
		System.out.println(Arrays.toString(doubleArrayWrapperType));

		Arrays.sort(charArrayPrimitiveType);
		System.out.println(Arrays.toString(charArrayPrimitiveType));

		Arrays.sort(charArrayWrapperType);
		System.out.println(Arrays.toString(charArrayWrapperType));

		Arrays.sort(stringArray);
		System.out.println(Arrays.toString(stringArray));

		// ***************************************************** with wrapper type only   ********************************************************

		Comparator<Byte> byteComparator1 = new Comparator<Byte>() {
			@Override
			public int compare(Byte i1, Byte i2) {
				return i2.compareTo(i1);
			}
		};
		
		Comparator<Byte> byteComparator2 = (Byte num1, Byte num2) -> num1.compareTo(num2); // ascending
		Comparator<Byte> byteComparator3 = (Byte num1, Byte num2) -> num2.compareTo(num1); // descending
		
		//way-1
		Arrays.sort(byteArrayPrimitiveType);
		System.out.println("byte arr ===>" + Arrays.toString(byteArrayPrimitiveType));
		
		// Arrays.sort(byteArrayPrimitiveType, byteComparator1); //CE
		Arrays.sort(byteArrayWrapperType, byteComparator1);
		System.out.println("byte arr ===>" + Arrays.toString(byteArrayWrapperType));
		

		//way-2
		//Arrays.stream(byteArrayPrimitiveType).sorted(); //CE
		Arrays.stream(byteArrayWrapperType).sorted().forEach(System.out::println);
		Arrays.stream(byteArrayWrapperType).sorted().distinct().forEach(System.out::println);
		
		Stream.of(byteArrayPrimitiveType).sorted().forEach(System.out::println);;
		Stream.of(byteArrayWrapperType).sorted().forEach(System.out::println);;
		Stream.of(byteArrayWrapperType).sorted(byteComparator1).forEach(System.out::println);;
		Stream.of(byteArrayWrapperType).sorted(byteComparator2).forEach(System.out::println);;
		Stream.of(byteArrayWrapperType).sorted(byteComparator3).forEach(System.out::println);;

		// *****************************************************

		Comparator<Short> shortComparator1 = new Comparator<Short>() {
			@Override
			public int compare(Short i1, Short i2) {
				return i2.compareTo(i1);
			}
		};
		
		Comparator<Short> shortComparator2 = (Short num1, Short num2) -> num1.compareTo(num2); // ascending
		Comparator<Short> shortComparator3 = (Short num1, Short num2) -> num2.compareTo(num1); // descending
		
		
		//way-1
		Arrays.sort(shortArrayPrimitiveType);
		System.out.println("short arr ===>" + Arrays.toString(shortArrayPrimitiveType));
		
		// Arrays.sort(shortArrayPrimitiveType, shortComparator); //CE
		Arrays.sort(shortArrayWrapperType, shortComparator1);
		System.out.println("short arr === "+Arrays.toString(shortArrayWrapperType));
		
		//way-2
		//Arrays.stream(shortArrayPrimitiveType).sorted(); //CE
		Arrays.stream(shortArrayWrapperType).sorted().forEach(System.out::println);;
		Arrays.stream(shortArrayWrapperType).sorted().distinct().forEach(System.out::println);
		
		Stream.of(shortArrayPrimitiveType).sorted().forEach(System.out::println);;
		Stream.of(shortArrayPrimitiveType).sorted().distinct().forEach(System.out::println);;
		Stream.of(shortArrayWrapperType).sorted().forEach(System.out::println);;
		Stream.of(shortArrayWrapperType).sorted().distinct().forEach(System.out::println);;
		Stream.of(shortArrayWrapperType).sorted(shortComparator1).forEach(System.out::println);
		Stream.of(shortArrayWrapperType).sorted(shortComparator2).forEach(System.out::println);;
		Stream.of(shortArrayWrapperType).sorted(shortComparator3).forEach(System.out::println);;
		
	
		// *****************************************************

		Comparator<Integer> intComparator1 = new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				// ascending order
				// return i1.compareTo(i2);
				// descending order
				return i2.compareTo(i1);
			}
		};
		
		Comparator<Integer> intComparator2 = (Integer num1, Integer num2) -> num1.compareTo(num2); // ascending
		Comparator<Integer> intComparator3 = (Integer num1, Integer num2) -> num2.compareTo(num1); // descending
		
		Arrays.sort(intArrayPrimitiveType);
		System.out.println("int array == "+Arrays.toString(intArrayPrimitiveType));
		Arrays.sort(intArrayWrapperType);
		System.out.println("int array == "+Arrays.toString(intArrayWrapperType));
		Arrays.sort(intArrayWrapperType, intComparator1);
		System.out.println("int array == "+Arrays.toString(intArrayWrapperType));
		Arrays.sort(intArrayWrapperType, intComparator2);
		System.out.println("int array == "+Arrays.toString(intArrayWrapperType));
		Arrays.sort(intArrayWrapperType, intComparator3);
		System.out.println("int array == "+Arrays.toString(intArrayWrapperType));
		
		Arrays.stream(intArrayPrimitiveType).sorted().forEach(System.out::println);
		Arrays.stream(intArrayPrimitiveType).sorted().distinct().forEach(System.out::println);
		Arrays.stream(intArrayWrapperType).sorted().forEach(System.out::println);
		Arrays.stream(intArrayWrapperType).sorted().distinct().forEach(System.out::println);
		Arrays.stream(intArrayWrapperType).sorted(intComparator1).distinct().forEach(System.out::println);
		Arrays.stream(intArrayWrapperType).sorted(intComparator2).distinct().forEach(System.out::println);
		Arrays.stream(intArrayWrapperType).sorted(intComparator3).distinct().forEach(System.out::println);
		
		Stream.of(intArrayPrimitiveType).sorted().forEach(System.out::println);
		Stream.of(intArrayWrapperType).sorted(intComparator1).forEach(System.out::println);
		Stream.of(intArrayWrapperType).sorted(intComparator2).forEach(System.out::println);
		Stream.of(intArrayWrapperType).sorted(intComparator3).forEach(System.out::println);

		// *****************************************************

		Comparator<Object> longComparator = new Comparator<Object>() {
			@Override
			public int compare(Object i1, Object i2) {
				Long num1 = (Long) i1;
				Long num2 = (Long) i2;
				return num2.compareTo(num1);
			}
		};
		//Arrays.sort(longArray1, longComparator);//CE
		Arrays.sort(longArrayWrapperType, longComparator);
		System.out.println("long arr ====="+Arrays.toString(longArrayWrapperType));

		List<Long> list22 = new ArrayList<>();
		list22.add(12L);
		list22.add(33l);
		Collections.sort(list22, longComparator);
		
		Arrays.stream(longArrayWrapperType).sorted();
		Arrays.stream(longArrayWrapperType).sorted().distinct().forEach(System.out::println);
		
		Stream.of(longArrayWrapperType).sorted();
		Stream.of(longArrayWrapperType).sorted(longComparator);


		// *****************************************************
		
		Comparator<Object> floatComparator = new Comparator<Object>() {
			@Override
			public int compare(Object i1, Object i2) {
				Float num1 = (Float) i1;
				Float num2 = (Float) i2;
				return num2.compareTo(num1);
			}
		};
		//Arrays.sort(longArray1, longComparator);//CE
		Arrays.sort(floatArrayWrapperType, floatComparator);
		System.out.println("float arr ====="+Arrays.toString(floatArrayWrapperType));

		List<Long> list022 = new ArrayList<>();
		list22.add(12L);
		list22.add(33l);
		Collections.sort(list022, longComparator);

		// *****************************************************
		
		Comparator<Object> doubleComparator = new Comparator<Object>() {
			@Override
			public int compare(Object i1, Object i2) {
				Double num1 = (Double) i1;
				Double num2 = (Double) i2;
				return num2.compareTo(num1);
			}
		};
		//Arrays.sort(doubleArray1, longComparator);//CE
		Arrays.sort(doubleArrayWrapperType, doubleComparator);
		System.out.println("double arr ====="+Arrays.toString(doubleArrayWrapperType));

		Arrays.stream(doubleArrayWrapperType).sorted();
		Arrays.stream(doubleArrayWrapperType).sorted().distinct().forEach(System.out::println);
		
		Stream.of(doubleArrayWrapperType).sorted();
		Stream.of(doubleArrayWrapperType).sorted(doubleComparator);


		// *****************************************************

		Comparator<String> strComparator = new Comparator<String>() {
			@Override
			public int compare(String name1, String name2) {
				// return name1.compareTo(name2);
				return name2.compareTo(name1);
			}
		};
		Arrays.sort(stringArray, strComparator);
		System.out.println("str arr === "+Arrays.toString(stringArray));
		
		
		Arrays.sort(stringArray);
		// OR

		Comparator<String> sortByLengthComparator = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str1.compareTo(str2);
			}
		};

		Arrays.sort(stringArray, sortByLengthComparator);
		
		Arrays.sort(stringArray);
		//OR
		Comparator<String> sortByNameCustomComparator = (String str1, String str2) -> str1.compareTo(str2);
		Arrays.sort(stringArray, sortByNameCustomComparator);
		

	}

	public static void parallelSortAnyArray() {

		Arrays.parallelSort(intArrayPrimitiveType);
		Arrays.stream(intArrayPrimitiveType).forEach(item -> System.out.print(item + " "));

		System.out.println();

		Arrays.parallelSort(floatArrayPrimitiveType);
		// Arrays.parallelSort(floatArr, 1, 4);
		System.out.println(Arrays.toString(floatArrayPrimitiveType));

		// Arrays.stream(floatArray).forEach(n -> System.out.print(n + " ")); //CE

		Arrays.parallelSort(stringArray);
		System.out.println(Arrays.toString(stringArray));

		Arrays.parallelSort(stringArray, Collections.reverseOrder());
		System.out.println(Arrays.toString(stringArray));
	}

	public static void namesStartingWithSpecificCharInStringArray() {
		Arrays.stream(stringArray).filter(str -> str.startsWith("A")).forEach(System.out::println);
		Arrays.stream(stringArray).filter(s -> s.startsWith("A")).sorted().forEach(System.out::println);
		Arrays.stream(stringArray).map(String::toUpperCase).filter(s -> s.startsWith("A")).forEach(System.out::println);
		Arrays.stream(stringArray).map(String::toLowerCase).filter(s -> s.startsWith("p")).forEach(System.out::println);
		Arrays.stream(stringArray).map(String::toLowerCase).filter(s -> s.length() == 5).forEach(System.out::println);
	
	}
	
	public static void namesStartingWithSpecificCharInStringList() {
		
		stringList.stream().filter(str -> str.startsWith("A")).forEach(System.out::println);
		stringList.stream().filter(s -> s.startsWith("A")).sorted().forEach(System.out::println);
		stringList.stream().map(String::toUpperCase).filter(s -> s.startsWith("A")).forEach(System.out::println);
		stringList.stream().map(String::toLowerCase).filter(s -> s.startsWith("p")).forEach(System.out::println);
		stringList.stream().map(String::toLowerCase).filter(s -> s.length() == 5).forEach(System.out::println);
		
	}

	public static void convertStringToCharArray() {
		String str = "password123";
		char[] charArray = str.toCharArray();
		for (char ch : charArray) {
			System.out.print(ch + " ");
		}
	}

	public static void sortContentOfFile() throws IOException {

		// sorting the content of the file.
		Stream<String> names = Files.lines(Paths.get("states.txt"));
		names.sorted().filter(x -> x.length() > 30).forEach(System.out::println);
		names.close();

		Stream<String> names2 = Files.lines(Paths.get("names.txt"));
		names2.sorted().filter(x -> x.contains("punya")).collect(Collectors.toList()).forEach(System.out::println);
		names2.close();

		Stream<String> names3 = Files.lines(Paths.get("csvfile.txt"));
		int count = (int) names3.map(x -> x.split(",")).filter(x -> x.length == 3).count();
		System.out.println(count);
		names3.close();

	}
}
