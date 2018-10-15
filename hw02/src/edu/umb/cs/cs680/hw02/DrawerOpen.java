package edu.umb.cs.cs680.hw02;

/**
 * @author Karthik.Prasad001
 *
 */
public class DrawerOpen implements State {
	
	private static DrawerOpen instance = null;
	
	public static DrawerOpen getInstance()
	{
	if(instance==null)
		instance = new DrawerOpen();
	return instance;
	}
	
	DVDPlayer playerState;
	
	

	public DrawerOpen() {}

	@Override
	public void openCloseButtonPushed() 
	{
		
		playerState.close();
		playerState.changeState(DrawerClosedNotPlaying.getInstance());

	}

	@Override
	public void playButtonPushed() 
	{
		
		playerState.close();
		playerState.play();
		playerState.changeState(DrawerClosedPlaying.getInstance());

	}

	@Override
	public void stopButtonPushed() 
	{
		System.out.println("NO CHANGE");
	}


}
