package core;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ArrayListTest {

	@Test
	public void testRetainAll() throws Exception {
		ArrayList<Integer> values = new ArrayList<Integer>();
		values.add(1);
		values.add(2);
		values.add(3);
		
		ArrayList<Integer> values2 = new ArrayList<Integer>();
		values2.add(3);
		values2.add(4);
		
		boolean result = values2.retainAll(values);
		System.out.println(result + " " + values2.size());
	}
	
	@Test
	public void testRetainAllWhen() throws Exception {
		ArrayList<Integer> values = new ArrayList<Integer>();
		values.add(1);
		values.add(2);
		values.add(3);
		
		ArrayList<Integer> values2 = new ArrayList<Integer>();
		values2.add(4);
		
		boolean result = values2.retainAll(values);
		System.out.println(result + " " + values2.size());
	}

}
