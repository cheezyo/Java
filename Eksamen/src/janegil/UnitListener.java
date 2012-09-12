package janegil;

import java.util.EventListener;

//UNIT LISTENER INTERFACE
public interface UnitListener extends EventListener {
	public void actionPerformed(UnitEvent event);
}