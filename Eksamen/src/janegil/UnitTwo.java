package janegil;

//UNIT TWO CLASS
public class UnitTwo implements UnitListener {

	private String info;

	public UnitTwo(String info) {
		this.info = info;
	}

	public void actionPerformed(UnitEvent event) {
		System.out.println(info + ": Action was performed: "
				+ event.getSource().toString());
		System.out.println("Action generated random number: "
				+ event.getRandomNumber());
	}
}