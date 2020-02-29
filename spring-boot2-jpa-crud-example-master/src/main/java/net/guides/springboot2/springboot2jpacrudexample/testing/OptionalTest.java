package net.guides.springboot2.springboot2jpacrudexample.testing;

import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OptionalTest java8Tester = new OptionalTest();
		Integer value1 = null;
		Integer value2 = new Integer(10);
		
		//Optional.ofNullable - allows passed parameter to be null
		Optional<Integer> a = Optional.ofNullable(value1);
		
		//Optional.of(value) - throws NullPointerException if passed parameter is null
		Optional<Integer> b = Optional.of(value2);
		System.out.println(java8Tester.sum(a,b));
	}

	private Integer sum(Optional<Integer> a, Optional<Integer> b) {
		// TODO Auto-generated method stub
		//Optional.isPresent - checks the value is present or not
		System.out.println("First parameter is present: " + a.isPresent());
		System.out.println("Second parameter is present: " + b.isPresent());
		
		//Optional.orElse - returns thr value if present otherwise return the default value passed 
		Integer value1 = a.orElse(new Integer(0));
		
		//Optional.get - gets the value, value should be present
		Integer value2 = b.get();
		return value1 + value2;
	}
	
	
}
