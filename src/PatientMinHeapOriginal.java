/**
 * Renamed original PatientMinHeap to avoid conflicts.
 * Students should implement this class by completing the TODO sections.
 */
class PatientMinHeapOriginal {
    protected Patient[] heap;
    protected int size;
    protected int capacity;

    public PatientMinHeapOriginal(int capacity) {
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
    // Returns the minimum patient without removing it
    public Patient getMin() { return size > 0 ? heap[0] : null; }

    // TODO: Students implement this method
    // Inserts a new patient into the heap
    public void insert(Patient patient) {
        if (size == capacity) throw new IllegalStateException("Heap is full");
        heap[size] = patient;
        siftUp(size);
        size++;
    }

    // TODO: Students implement this method
    // Removes and returns the minimum patient
    public Patient extractMin() {
        if (isEmpty()) return null;
        Patient min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);
        return min;
    }

    // TODO: Students implement this method
    // Sifts a patient down from index i to maintain the min-heap property
    private void siftDown(int i) {
        int minIndex = i;
        int left = leftChild(i);
        if (left < size && heap[left].getSeverityScore() < heap[minIndex].getSeverityScore()) {
            minIndex = left;
        }
        int right = rightChild(i);
        if (right < size && heap[right].getSeverityScore() < heap[minIndex].getSeverityScore()) {
            minIndex = right;
        }
        if (i != minIndex) {
            swap(i, minIndex);
            siftDown(minIndex);
        }
    }

    // TODO: Students implement this method
    // Sifts a patient up from index i to maintain the min-heap property
    private void siftUp(int i) {
        while (i > 0 && heap[parent(i)].getSeverityScore() > heap[i].getSeverityScore()) {
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