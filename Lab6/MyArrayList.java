package Lab6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// creates an array of double-size if the array of elements is full
	public void growSize() {
		if (elements.length == size) {
			int newCapatity = elements.length * 2;
			E[] newElements = (E[]) new Object[newCapatity];
			System.arraycopy(elements, 0, newElements, 0, size);
			elements = newElements;
		}
	}

	// Returns the number of elements in this list.
	public int size() {
		return size;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new ArrayIndexOutOfBoundsException("");
		} else {
			return elements[i];
		}
	}

	// Replaces the element at index i with e, and returns the replaced element.∗/
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new ArrayIndexOutOfBoundsException("");
		} else {
			E replacedElement = elements[i];
			elements[i] = e;
			return replacedElement;
		}
	}

	// It is used to append the specified element at the end of a list.
	public boolean add(E e) {
		elements[size++] = e;
		growSize();
		return true;
	}

	// Inserts element e to be at index i, shifting all subsequent elements later.
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new ArrayIndexOutOfBoundsException("");
		} else {
			growSize();
			E[] data = Arrays.copyOf(elements, elements.length);
			for (int j = size; j > 0; j--) {
				if (j == i) {
					elements[j] = e;
					break;
				} else {
					elements[j] = elements[j - 1];
				}
			}
			size++;
		}
	}

	// Removes and returns the element at index i, shifting subsequent elements
	// earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new ArrayIndexOutOfBoundsException("");
		} else {
			E removedElement = elements[i];
			System.arraycopy(elements, i + 1, elements, i, size - 1 - i);
			elements[--size] = null;
			return removedElement;
		}
	}

	// It is used to clear all elements in the list.
	public void clear() {
		for (int i = 0; i < elements.length; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	/*
	 * It is used to return the index in this list of the last occurrence of the
	 * specified element, or-1 if the list does not contain this element.
	 */
	public int lastIndexOf(Object o) {
		for (int i = size - 1; i >= 0; i--) {
			if (o.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * It is used to return an array containing all of the elements in this list in
	 * the correct order.
	 */
	public E[] toArray() {
		return Arrays.copyOf(elements, size);
	}

	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		MyArrayList<E> clonedList = new MyArrayList<>(size);
		clonedList.size = this.size;
		clonedList.elements = this.toArray();
		return clonedList;
	}

	// It returns true if the list contains the specified element
	public boolean contains(E o) {
		return indexOf(o) >= 0;
	}

	/*
	 * It is used to return the index in this list of the first occurrence of the
	 * specified element, or-1 if the List does not contain this element.
	 */
	public int indexOf(E o) {
		for (int i = 0; i < elements.length; i++) {
			if (o.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	// It is used to remove the first occurrence of the specified element.
	public boolean remove(E e) {
		for (int i = 0; i < size; i++) {
			if (e.equals(elements[i])) {
				remove(i);
				return true;
			}
		}
		return false;
	}

	/*
	 * It is used to sort the elements of the list on the basis of specified
	 * comparator.
	 */
	public void sort(Comparator<E> comparator) {
		Arrays.sort(elements, 0, size, comparator);
	}
}
