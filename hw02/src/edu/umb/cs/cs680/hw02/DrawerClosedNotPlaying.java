package edu.umb.cs.cs680.hw02;

/**
 * @author Karthik.Prasad001
 *
 */
public class DrawerClosedNotPlaying implements State {
	
private static DrawerClosedNotPlaying instance;
	
	public static DrawerClosedNotPlaying getInstance()
	{
	if(instance==null)
		instance = new DrawerClosedNotPlaying();
	return instance;
	}
	
	DVDPlayer playerState;

	public DrawerClosedNotPlaying() {}

	@Override
	public void openCloseButtonPushed() 
	{

		playerState.open();
		playerState.changeState(DrawerOpen.getInstance());
	}
		

	@Override
	public void playButtonPushed() 
	{
	
		playerState.play();
		playerState.changeState(DrawerClosedPlaying.getInstance());
	}
	


	@Override
	public void stopButtonPushed() {
		System.out.println("NO CHANGE");

	}

}
