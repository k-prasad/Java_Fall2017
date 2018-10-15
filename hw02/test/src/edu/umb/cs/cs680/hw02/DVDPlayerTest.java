
package edu.umb.cs.cs680.hw02;

//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
//import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Karthik.Prasad001
 *
 */
public class DVDPlayerTest {
	
	@Before
	public void beforeTest()
	{
		System.out.println("\nSONY BLU-RAY DVD Player, Welcome!");
		
	}
	

	@Test
	public void Test1() 
	{
		DVDPlayer playerState = new DVDPlayer();
		
		playerState.open();
		playerState.close();
		playerState.play();
		playerState.stop();
			
		
	}
	
	@Test
	public void Test2() 
	{
		DVDPlayer playerState = new DVDPlayer();
		
	//	Assert.assertSame(playerState.openCloseButtonPushed(),DrawerClosedNotPlaying.getInstance() ) ;
		playerState.close();
		playerState.play();
		playerState.stop();
		playerState.open();
			
		
	}
	

	@After
	public void afterTest()
	{
		System.out.println("\nGood Bye!");
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
	}
	

}
