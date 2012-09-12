package janegil;

import java.util.EventObject;

//UNIT EVENT CLASS
public class UnitEvent extends EventObject {

	private int randomNumber;

	public UnitEvent(Unit u) {
		super(u);
		randomNumber = (int) (Math.random() * 100);
	}

	public int getRandomNumber() {
		return randomNumber;
	}

}