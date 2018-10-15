package edu.umb.cs.cs680.hw11;

import java.util.Comparator;

/**
 * @author Karthik.Prasad001
 *
 */
public class AlphabeticalComparator implements Comparator<FSElement> {

	@Override
	public int compare(FSElement o1, FSElement o2) {
		// TODO Auto-generated method stub
		return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
	}

}
