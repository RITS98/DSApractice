class MyQueue
{
	private int capacity;
	int front;
	int rear;
	int queueArr[];
	int currentSize;

	public MyQueue(int size)
	{
		this.capacity = size;
		front = 0;
		rear = -1;
		queueArr = new int[this.capacity];
	}

	public boolean isFull()
	{
		if(currentSize == capacity)
			return true;
		return false;
	}

	public boolean isEmpty()
	{
		return (currentSize == 0);
	}

	public void enqueue(int data)
	{
		if(isFull())
		{
			System.out.println("The Queue is full");
			return;
		}

		rear++;
		if(rear == capacity -1)
			rear = 0;
		queueArr[rear] = data;
		currentSize++;
		System.out.println(data + " is enqueued");
	}

	public void dequeue()
	{
		if(isEmpty())
		{
			System.out.println("The Queue is empty");
			return;
		}

		front++;
		if(front == capacity -1)
		{
			System.out.println(queueArr[front - 1] + " is dequeued");
			front = 0;
		}
		else
		{
			System.out.println(queueArr[front - 1] + " is dequeued");
		}
		currentSize --;
	}

	public static void main(String a[]) {
 
        MyQueue queue = new MyQueue(5);
        queue.enqueue(6);
        queue.dequeue();
        queue.enqueue(3);
        queue.enqueue(99);
        queue.enqueue(56);
        queue.dequeue();
        queue.enqueue(43);
        queue.dequeue();
        queue.enqueue(89);
        queue.enqueue(77);
        queue.dequeue();
        queue.enqueue(32);
        queue.enqueue(232);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(5);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }
}