package pets;

public class Main {
	public static void main(String[] args) {
		Dog dog1 = new Dog("Huskey");
		Dog dog2 = new Dog("Sam");
		Child child = new Child("Baby");
		Person person = new Person("Cezar");
		dog1.addDogListener(person);
		dog1.addDogListener(child.getListener());
		dog2.addDogListener(person);
		dog2.addDogListener(child.getListener());
		
		
	}

}
