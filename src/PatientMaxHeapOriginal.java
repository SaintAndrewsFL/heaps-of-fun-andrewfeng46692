import java.lang.IllegalStateException;


class PatientMaxHeapOriginal {
    protected Patient[] heap;
    protected int size;
    protected int capacity;

    public PatientMaxHeapOriginal(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new Patient[capacity];
    }

    // TODO: Students implement this method
    // Returns the index of the parent node
    private int parent(int i) { return (i - 1) / 2; }


    // TODO: Students implement this method
    // Returns the index of the left child
    private int leftChild(int i) { return 2 * i + 1; }


    // TODO: Students implement this method
    // Returns the index of the right child
    private int rightChild(int i) { return 2 * i + 2; }


    // TODO: Students implement this method
    // Checks if the heap is empty
    public boolean isEmpty() { return size == 0; }


    // TODO: Students implement this method
    // Returns the maximum patient without removing it
    public Patient getMax() { return size > 0 ? heap[0] : null; }


    // TODO: Students implement this method
    // Inserts a new patient into the heap
    public void insert(Patient patient) {
        if (size == capacity) throw new IllegalStateException("Heap is full");
        heap[size] = patient;
        siftUp(size);
        size++;
    }

    // TODO: Students implement this method
    // Removes and returns the maximum patient
    public Patient extractMax() {
        if (isEmpty()) return null;
        Patient max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);
        return max;
    }

    // TODO: Students implement this method
    // Sifts a patient down from index i to maintain the max-heap property
    private void siftDown(int i) {
        int maxIndex = i;
        int left = leftChild(i);
        if (left < size && heap[left].getSeverityScore() > heap[maxIndex].getSeverityScore()) {
            maxIndex = left;
        }
        int right = rightChild(i);
        if (right < size && heap[right].getSeverityScore() > heap[maxIndex].getSeverityScore()) {
            maxIndex = right;
        }
        if (i != maxIndex) {
            swap(i, maxIndex);
            siftDown(maxIndex);
        }
    }

    // TODO: Students implement this method
    // Sifts a patient up from index i to maintain the max-heap property
    private void siftUp(int i) {
        while (i > 0 && heap[parent(i)].getSeverityScore() < heap[i].getSeverityScore()) {
            swap(i, parent(i));
            i = parent(i);
        }
    }
    private void swap(int i, int j) {
        Patient temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}