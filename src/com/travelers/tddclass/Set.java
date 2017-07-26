package com.travelers.tddclass;

import java.util.Arrays;

public class Set <T> {
	
	private int size = 0; 
	
	private Object[] storage; 
	
	public Set() {
		this.size = 0; 
		this.storage = new Object[10];
	}

	public boolean empty() {
		return this.size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public Object get(Object toRetrieve) {
		int location = this.find(toRetrieve);
		return location < 0 ? null : this.storage[location];
	}
	
	public void add(T value) {
		if(find(value) == -1) {
			if (this.size == this.storage.length) {
				doubleSizeOfStorage();
			}
			this.storage[size++] = value;
		}
	}
	
	@SuppressWarnings("unused")
	private void doubleSizeOfStorage() {
		T[] newArray = (T[]) new Object[this.storage.length * 2];
		System.arraycopy(this.storage, 0, newArray, 0, this.storage.length);
		this.storage = newArray; 
	}
	
	/**
	 * If toRemove is in the set then this method removes it from the set. 
	 * @param toRemove - the object to remove - MUST BE NON-NULL
	 */
	public void remove(T toRemove) {
		int locationOfToRemove = find(toRemove);
		if(locationOfToRemove >= 0) {
			this.storage[locationOfToRemove] = null; 
			this.size --;
		}
	}
	
	/**
	 * Returns 'true' if the object is in the set
	 * @param lookingFor - must be non-null. 
	 * @return 'true' if lookingFor is in the set
	 */
	public boolean contains(T lookingFor) {
		return find(lookingFor) >= 0;
	}
	
	/**
	 * Finds stuff
	 * @param lookingFor
	 * @return
	 */
	private int find(Object lookingFor) {
		for (int i = 0; i < size; i++) {
			if (lookingFor.equals(storage[i])) {
				return i; 
			}
		}
		return -1; 
	}
}
