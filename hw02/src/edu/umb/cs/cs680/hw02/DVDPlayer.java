package edu.umb.cs.cs680.hw02;

/**
 * @author Karthik.Prasad001
 *
 */
public class DVDPlayer 
{
	
	static State playerState;
	
	private static DVDPlayer instance = null;

		DVDPlayer()
		{
			
		}
		

		public static DVDPlayer getInstance()
		{
		if(instance==null)
			{
			instance = new DVDPlayer();
			playerState = DrawerClosedNotPlaying.getInstance();
			}
		return instance;
		}
		
		State changeState(State playerState )
		{
			return playerState;
		}
		
		
		public void openCloseButtonPushed()
		{
			playerState.openCloseButtonPushed();
		}
		public  void playButtonPushed()
		{
			playerState.playButtonPushed();
		}
		public  void stopButtonPushed()
		{
			playerState.stopButtonPushed();
		}
		
		public void open()
		{
			System.out.println("\n(*)-------OPEN button Pushed, *EJECTING*---------\n *\n * ");
			System.out.println("Drawer is OPEN \n *\n * ");
		}
		public void close()
		{
			System.out.println("\n(*)-------CLOSE button Pushed, *CLOSING*---------\n *\n * ");
			System.out.println("Drawer is CLOSED \n *\n * ");
		}
		public void play()
		{
			System.out.println("\n(*)-------PLAY button Pushed, *MOVIE*---------\n *\n * ");
			System.out.println("Playing DVD \n *\n * ");
		}
		public void stop()
		{
			System.out.println("\n(*)-------STOP button Pushed, *STOPPED*---------\n *\n * ");
			System.out.println("DVD Playing STOPPED");
		}
		
	/*	public State getDrawerOpenState() { return open; }
		public State getDrawerClosedPlayingState() { return play; }
		public State getDrawerClosedNotPlayingState() { return stop; }
		public State getDrawerClosedState() { return close; }
		
		*/

}
