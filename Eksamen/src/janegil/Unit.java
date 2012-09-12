package janegil;

import java.util.Vector;

public class Unit {

	private Vector<UnitListener> units;
	private String type;

	public Unit(String type) {
		this.type = type;
		units = new Vector<UnitListener>();
	}

	public void addUnit(UnitListener unit) {
		units.add(unit);
	}

	public void removeUnit(UnitListener unit) {
		units.removeElement(unit);
	}

	public void performAction() {
		fireActionPerformed();
	}

	private void fireActionPerformed() {

		for (UnitListener unit : units) {
			UnitEvent event = new UnitEvent(this);
			unit.actionPerformed(event);
		}
	}

	public String toString() {
		return "Type: " + type;
	}
}
