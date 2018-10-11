package Main;

public abstract class  GameState {
	protected StateManager manager;
	protected GameState(StateManager manager){
		this.manager = manager;
	}
	public void render() {
		stateRender();
	}
	public void update() {
		stateUpdate();
	}
	
	public abstract void stateUpdate();
	public abstract void updateInputs(boolean keys[]);
	public abstract void init();
	public abstract void kill();
	public abstract void stateRender();
}
