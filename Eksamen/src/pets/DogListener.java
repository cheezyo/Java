package pets;

public interface DogListener {
	
	public void dogHungry(DogEvent e);
	public void dogThirsty(DogEvent e);
	public void dogLonley(DogEvent e);
	public void dogSleeps(DogEvent e);

}
