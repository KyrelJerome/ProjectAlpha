package alphaStates;

import Main.GameState;
import Main.StateManager;
import alphaMain.AlphaStateManager;
public class OpeningState  extends GameState{
	long openingDuration = 3300;
	long startingTime;
	long currentTime;
	boolean started;
	public OpeningState(StateManager manager) {
		super(manager);
	}
	@Override
	public void stateUpdate() {
		if(!started) {
		startingTime = System.currentTimeMillis();
		started = true;
		}

		currentTime = System.currentTimeMillis();
		if (started && startingTime  + openingDuration < currentTime) {

			System.out.println("Swapping to Loading");
			manager.swap(AlphaStateManager.LOADING);
		}
	}

	@Override
	public void updateInputs(boolean[] keys) {
		// TODO Auto-generated method stub
	}

	@Override
	public void init() {
		started = false;
	}

	@Override
	public void kill() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateRender() {
		// TODO Auto-generated method stub
		
	}

}