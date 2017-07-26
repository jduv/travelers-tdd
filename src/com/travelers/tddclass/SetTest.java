package com.travelers.tddclass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SetTest {
	
	private Set<String> target;
	
	@Before
	public void setup() {
		this.target = new Set<String>(); 
	}
	
	@Test
	public void testSetIsEmpty() {
		assertTrue(this.target.empty());
	}
	
	@Test
	public void testEmptySetHasExpectedSize() {
		assertEquals(0, this.target.size());
	}
	
	@Test
	public void testAddMethodMakesSetNotEmpty() {
		this.target.add("");
		assertFalse(this.target.empty());
	}
	
	@Test
	public void testAddMethodIncrementsSizeByOne() {
		int beforeSize = this.target.size(); 
		this.target.add("");
		assertEquals(1,  this.target.size() - beforeSize);
	}
	
	@Test
	public void testSetContainsValue() {
		this.target.add("MySpecificValue");
		assertTrue(this.target.contains("MySpecificValue"));
//		assertFalse(this.target.contains("SomethingRandom?"));
	}
	
	@Test
	public void testAddMultipleValues() {
		int beforeSize = this.target.size();
		this.target.add("MySpecificValueOne");
		this.target.add("MySpecificValueTwo");
		assertEquals(2, this.target.size() - beforeSize);
	}
	
	@Test
	public void testAddDuplicateDoesNotAddToSet() {
		int valueBefore = this.target.size(); 
		this.target.add("MySpecificValue");
		this.target.add("MySpecificValue");
		assertEquals(1, this.target.size() - valueBefore);
	}
	
	@Test
	public void testRemoveDeletesValue() {
		String testValue = "ValueToRemove";
		this.target.add(testValue);
		this.target.remove(testValue);
		assertFalse(this.target.contains(testValue));
	}
	
	@Test
	public void testRemoveFromAnEmptyList() {
		this.target.remove("objectToRemove");
		assertTrue(this.target.empty());
	}
	
	@Test
	public void testGetMethodReturnsExpectedObject() {
		String testObject = "MySpecialTeestableString";
		this.target.add(testObject);
		assertEquals(testObject, this.target.get(testObject));
	}
	
	@Test
	public void testGetMethodReturnsObjectThatIsNotThere() {
		String testObject = "MySpecialTeestableString";
		this.target.add(testObject);
		assertNull(this.target.get("NotThatSpecialString"));
	}
	
	@Test
	public void testAddThenRemoveThenAddThenRemove() {
		int sizeBefore = this.target.size(); 
		this.target.add("ObjectOne");
		this.target.remove("ObjectOne");
		this.target.add("AnotherObject");
		this.target.remove("ThisObjectIsNotThere");
		assertEquals(1, this.target.size() - sizeBefore);
	}
	
	@Test(expected = ClassCastException.class)
	public void addAnObjectThatIsNotOfTheDeclaredType()  {
		Object genericObject = new ArrayList(); 
		this.target.add((String) genericObject);
	}
	
	@Test
	public void testSetExpandsAsExpected() {
		int targetSize = 30; 
		for (int i = 0; i < targetSize; i++) {
			this.target.add(String.valueOf(i));
		}
		assertEquals(targetSize, this.target.size());
	}
}
