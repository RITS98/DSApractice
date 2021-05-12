class MyStack
{
	private int max_size;
	private  int stack[];
	private int top;

	public MyStack(int s)
	{
		max_size = s;
		stack = new int[max_size];
		top = -1;
	}

	public void push(int element)
	{
		stack[++top] = element;
	}

	public int pop()
	{
		return stack[top--];
	}

	public int peek()
	{
		return stack[top];
	}

	public boolean isEmpty()
	{
		return (top == -1);
	}

	public boolean isFull()
	{
		return (top == max_size - 1);
	}

	public static void main(String[] args) {
      MyStack theStack = new MyStack(10); 
      theStack.push(10);
      theStack.push(20);
      theStack.push(30);
      theStack.push(40);
      theStack.push(50);
      
      while (!theStack.isEmpty()) {
         long value = theStack.pop();
         System.out.print(value);
         System.out.print(" ");
      }
      System.out.println("");
   }
}