package alphaMain;

import alphaStates.*;

public class AlphaStateManager extends Main.StateManager{

	public static final int OPENING = 0;
	public static final int LOADING = 2;
	public static final int MENU = 3;
	public static final int BRAWLSELECTION = 4;
	public static final int STORYSELECTION = 5;
	public static final int STORY = 6;
	public static final int VERSUS = 7;
	public static final int ONLINE = 8;
	public static final int PRACTICE = 9;
	public AlphaStateManager() {
		super(0, 0, true);
		gameStates.add(new OpeningState(this));
		//gameStates.add(new LoadingState());
		gameStates.add(new MainMenuState(this));
		gameStates.add(new BrawlSelectionState(this));
		gameStates.add(new StorySelectionState(this));
	}
	@Override
	protected void managerInit() {
		
		gameStates.get(currentState).render();
	}

}
