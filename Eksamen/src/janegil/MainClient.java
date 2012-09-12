package janegil;

//MAIN CLIENT CLASS
public class MainClient {

	public static void main(String[] args) {
		Unit unit = new Unit("Box");

		UnitOne one = new UnitOne("One");
		UnitOne two = new UnitOne("Two");
		//UnitTwo two = new UnitTwo("Two");

		unit.addUnit(one);
		unit.addUnit(two);

		unit.performAction();
	}
}

// UNIT CLASS

