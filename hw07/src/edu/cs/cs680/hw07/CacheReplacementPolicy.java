/**
 * 
 */
package edu.cs.cs680.hw07;

import java.io.File;
import java.util.HashMap;

/**
 * @author Karthik.Prasad001
 * @param <K>
 * @param <V>
 *
 */
public interface CacheReplacementPolicy 
{
	public void replace(HashMap<String, Integer> h, File f);

}
