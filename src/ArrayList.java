import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {
    T[] array;
    int size;

    /**
     * Default constructor for ArrayList, it initializes an empty list with a capacity of 10.
     */

    public ArrayList() {
        size = 0;
        array = (T[]) new Object[10];
    }

    /**
     * Retrieves the element at the specified position in the list.
     *
     * @param pos index of the element to return
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */

    public T get(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[pos];
    }

    /**
     * @return the number of elements in the list
     */

    public int size() {
        return size;
    }

    /**
     * Appends the specified element to the end of the list
     *
     * @param item element to be appended t
     * @return true
     */

    public boolean add(T item) {
        if (size == array.length) {
            expandArray();
        }
        array[size++] = item;
        return true;
    }

    /**
     * Inserts the specified element at the specific position in the list
     *
     * @param pos  index at which the specified element is to be inserted
     * @param item element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */

    public void add(int pos, T item) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == array.length) {
            expandArray();
        }
        for (int i = size; i > pos; i--) {
            array[i] = array[i - 1];
        }
        array[pos] = item;
        ++size;
    }

    /**
     * Removes the element at the specific position
     *
     * @param pos the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of range
     */

    public T remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        T temp = array[pos];
        if (pos == size - 1) {
            array[pos] = null;
            size--;
            return temp;
        }
        for (int i = pos; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return temp;
    }

    /**
     * @return an iterator over the elements in this list in proper sequence
     */

    public Iterator<T> iterator() {
        return new ALIterator<T>();
    }

    @Override
    public Iterator<T> Iterator() {
        return null;
    }

    /**
     * Expands the capacity of the internal array when required
     */

    private void expandArray() {
        T[] newArry = (T[]) new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArry[i] = array[i];
        }
        array = newArry;
    }

    /**
     * Iterator implementation for ArrayList
     */

    private class ALIterator<T> implements Iterator<T> {
        private int nextIndex = 0;

        /**
         * @return true if the iterator has more elements, false otherwise
         */

        public boolean hasNext() {
            return nextIndex < size && nextIndex >= 0;
        }

        /**
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (T) array[nextIndex++];
        }
    }
}
