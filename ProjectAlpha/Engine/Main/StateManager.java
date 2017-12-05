package dataStructures;

import java.util.ArrayList;
import States.GameState;

public abstract class StateManager {

	public ArrayList<GameState> gameStates;
	private int currentState;
	private int newState;
	private int defaultState;
	private boolean isInitialized;
	private String intermediateData; 
	public StateManager (int defaultState, int currentState, boolean isInitialized){
		gameStates.get(defaultState).init(); 
		this.isInitialized = isInitialized;
		this.defaultState = defaultState;
		this.currentState = currentState;
	}
	
	public abstract boolean init();
	
	
	/**
    Update the current state if isInitialized == true and isRunning == true.
	 */
	public  void update() {
		
		if(isInitialized){
			gameStates.get(currentState).update();
		}
		else {
			gameStates.get(defaultState).update();
		}
	}
	
	/**
	 Calls StateManager.engineRender() iff isInitialized = True 
	 */
	public void render() {
		if(isInitialized){
			gameStates.get(currentState).render();
		}
		else {
			gameStates.get(defaultState).render();
		}
	}
	
	
	/**
	 Changes the state to new index, showing defaultIndex as an intermediate.
	 @param newIndex Index value of the state to be switched to.
	 */
	public void Swap(int newIndex) {
		
		newState= newIndex;
		
		isInitialized = false;
		gameStates.get(defaultState).render();
		gameStates.get(currentState).kill();
		gameStates.get(newState).init();
		currentState = newState;
		isInitialized = true;
	}
	
	/**
	 Changes the state to new index, showing loadingIndex as an intermediate
	 @param newIndex Index value of the state to be switched to.
	 @param	loadingIndex Index value of the state to be used as intermediate.
	 */
	public void Swap(int newIndex, int loadingIndex) {

		newState= newIndex;
		
		isInitialized = false;
		gameStates.get(loadingIndex).init();
		gameStates.get(loadingIndex).render();
		gameStates.get(currentState).kill();
		gameStates.get(newState).init();
		gameStates.get(loadingIndex).kill();
		currentState = newState;
		isInitialized = true;
	}
	
	/**
	 Feeds memory to the current state.
	 */
	public void updateInputs(int keys[])
	{
		if (isInitialized) {
			gameStates.get(currentState).updateInputs(keys);
		}
	}
	
	/**
	 Frees all memory used by all states.
	 */
	public void killAll() {
		for(int x = 0; x < gameStates.size(); x++)
		{
		gameStates.get(x).kill();
		}
		while (gameStates.size() > 0) {
			gameStates.remove(0);
		}
	}
	
	public String getData() {
		return intermediateData;
	}
	
	public void updateIntermediateData(String intermediateData) {
		this.intermediateData = intermediateData;
	}
}
