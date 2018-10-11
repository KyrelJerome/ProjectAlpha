package alphaMain;

import Controllers.KeyedInput;

public class AlphaGameLoop extends Main.GameLoop{
	AlphaStateManager sm;
	public AlphaGameLoop() {
		super();
		
		
	}
	
	public static void main(String[] args) {
		name = "Alpha";
		System.out.println("Starting Project: " + name);
		AlphaGameLoop loop = new AlphaGameLoop();
		loop.run();
	}

	@Override
	public void gameLoopInit() {
		sm = new AlphaStateManager();		
	}

	@Override
	public void gameLoopUpdate() {
		sm.update();
	}

	@Override
	public void gameLoopRender() {
		sm.render();
	}

	@Override
	public void gameLoopGetInputs() {
		sm.updateInputs(keyboard.getKeys());
	}
}
