package forelesning2;

public class Client {
	public static void main(String[] args) {
		
		CircularArrayQueue<String> stringQueue = new CircularArrayQueue<String>(200);
		stringQueue.enqueue("hei");
		stringQueue.enqueue("hei1");
		stringQueue.enqueue("hei2");
		stringQueue.enqueue("hei3");
		stringQueue.enqueue("hei4");
		stringQueue.expandCapacity();
		int a = stringQueue.size();
		String s = stringQueue.first();
		System.out.println(stringQueue.isEmpty());
		for(int i = 0; i < a; i++){
			
			System.out.println(stringQueue.dequeue());
		}
	}

}
