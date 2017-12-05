package States;

public abstract class  GameState {

	public void render() {
		stateRender();
	}
	public void update() {
		stateUpdate();
	}
	
	public abstract void stateUpdate();
	public abstract void updateInputs(int keys[]);
	public abstract void init();
	public abstract void kill();
	public abstract void stateRender();
}
