package pets;

public class Person implements DogListener{

	private String name;
	
	public Person(String name){
		this.name = name;
	}

	@Override
	public void dogHungry(DogEvent e) {
		System.out.println("-" + name + " feeds "+ e.getSource().getName());
	}

	@Override
	public void dogThirsty(DogEvent e) {
		System.out.println("-" + name + " gives water to "+ e.getSource().getName());
	}

	@Override
	public void dogLonley(DogEvent e) {
		System.out.println("-" + name + " plays with "+ e.getSource().getName());
	}

	@Override
	public void dogSleeps(DogEvent e) {
		System.out.println("-" + name + " watches "+ e.getSource().getName() + " sleep");
	}
}
