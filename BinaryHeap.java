public class BinaryHeap{
	public int[] arr;
	int size;

	public BinaryHeap()
	{
		arr = new int[3];
		size = 0;
	}

	public void add(int item){
		if(size == arr.length-1)
			grow();
		arr[size++] = item;
		int current = size-1;
		int parent = (current-1)/2;
		while((arr[current] < arr[parent]) && parent < current){
			swap(arr, current, parent);
			current = parent;
			parent = (current-1)/2;
		}
	}

	public int remove(){
            if(size <= 0)
            	throw new ArrayIndexOutOfBoundsException("Heap is empty");
            else{
            	int popped = arr[0];
            	swap(arr,0,size-1);
            	size--;
            	if(size!=0)
            		shiftdown(0);
            	return arr[size];
            }

      }

	public void shiftdown(int nodeIndex) {
            int leftChildIndex, rightChildIndex, minIndex, tmp;
            leftChildIndex = (nodeIndex*2+1);
            rightChildIndex = (nodeIndex*2+2);
            if(rightChildIndex >= size){
            	if (leftChildIndex >= size)
            		return;
            	else
            		minIndex = leftChildIndex;
            }else{
            	if (arr[leftChildIndex] <= arr[rightChildIndex])
            		minIndex = leftChildIndex;
            	else
            		minIndex = rightChildIndex;
            }
            if (arr[nodeIndex] > arr[minIndex]) {
            	tmp = arr[minIndex];
            	arr[minIndex] = arr[nodeIndex];
            	arr[nodeIndex] = tmp;
            	shiftdown(minIndex);
            }
      }

	public static final void swap (int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	void grow(){
		int[] temp = new int[arr.length * 2]; //Create array double size
		System.arraycopy(arr,0,temp,0,arr.length-1);// copy all elements
		arr = temp;
	}

	public void print() 
    {
    	for (int i = 0; i <= size / 2; i++){
    		System.out.print(" PARENT : " + arr[i] 
                     + " LEFT CHILD : " + arr[i * 2 + 1] 
                   + " RIGHT CHILD :" + arr[i*2+2]);
            System.out.println();
        } 
    }

	public static void main(String[] args){
		BinaryHeap heap = new BinaryHeap();
		heap.add(3);
		heap.add(11);
		heap.add(52);
		heap.add(18);
		heap.add(2);
		heap.add(23);
		heap.print();
		heap.remove();
		heap.print();
	}

}