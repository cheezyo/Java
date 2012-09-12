package janegil;

//UNIT ONE CLASS
public class UnitOne implements UnitListener {

	private String info;

	public UnitOne(String info) {
		this.info = info;
	}

	public void actionPerformed(UnitEvent event) {
		System.out.println(info + ": Action was performed: "
				+ event.getSource().toString());
		System.out.println("Action generated random number: "
				+ event.getRandomNumber());
	}
}
