package pets;

public class Child {
	
	private DogAdapter listener = new DogAdapter(){
		public void dogSleeps(DogEvent e){
			System.out.println("- " + name + " slaps " + e.getSource().getName() + " in the head!");
		}
	};
	
	
	private String name;
	
	public Child(String name){
		this.name = name;
		
	}
	
	public DogAdapter getListener(){
		return listener;
	}

	
}
