package edu.umb.cs.cs680.hw02;

/**
 * @author Karthik.Prasad001
 *
 */
public class DrawerClosedPlaying implements State {
	
	private static DrawerClosedPlaying instance;
	
	public static DrawerClosedPlaying getInstance()
	{
	if(instance==null)
		instance = new DrawerClosedPlaying();
	return instance;
	}
	
	DVDPlayer playerState;
	

	public DrawerClosedPlaying() {}

	@Override
	public void openCloseButtonPushed() 
	{
		
		playerState.stop();
		playerState.changeState(DrawerOpen.getInstance());
	}

	@Override
	public void playButtonPushed() {
		System.out.println("NO CHANGE");

	}

	@Override
	public void stopButtonPushed()
	{
		
		playerState.stop();
		playerState.changeState(DrawerClosedNotPlaying.getInstance());

	}

}
