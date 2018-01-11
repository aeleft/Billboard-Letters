package billboardletters;

import java.util.HashMap;

/**
 * This class represents a billboard.
 * The field letterCounter contains each letter in the billboard paired with the letter's frequency.
 */
public class Billboard {

	private HashMap<String, Integer> letterCounter = new HashMap<>();
	
	/**
	 * Default Constructor.
	 */
	public Billboard() {}
	
	/**
	 * Adds a letter along with a certain number of occurrences of that letter to the billboard.
	 * @param c the letter to add.
	 * @param i the number of occurrences of that letter.
	 */
	public void put(char c, int i)
	{
		int current;
		if(letterCounter.containsKey(c+""))
		{
			current = letterCounter.get(c+"");
		}	
		else
		{
			current = 0;
		}
		current += i;
		letterCounter.put(c+"",current);
	}
	
	/**
	 * Removes a parameterized number of occurrences of a letter from the billboard.
	 * @param c the letter whose occurrences will be removed.
	 * @param i the number of occurrences that will be removed.
	 */
	public void remove(char c, int i)
	{
		int current = letterCounter.get(c+"");		
		current -= i;
		letterCounter.put(c+"",current);
	}
	
	/**
	 * Prints all the letters with 1 or more occurrences.
	 */
	public void print()
	{		
		for(String s : letterCounter.keySet())
		{
			if(letterCounter.get(s) != 0)
			{
				System.out.println(s+": "+letterCounter.get(s)+" copies");
			}
		}
	}
	
	/**
	 * Registers each letter of the input string onto the billboard.
	 * @param s the string to register.
	 */
	public void register(String s)
	{
		for(int i=0; i<s.length(); i++)
		{
			char c = s.charAt(i);
			put(c, 1);
		}
	}
	
	/**
	 * Helper method to allow the use of containsKey while maintaining the field letterCounter private.
	 * @param s the key to check.
	 * @return true if the billboard contains the key s.
	 */
	public boolean containsKey(String s) 
	{
		return letterCounter.containsKey(s);
	}
	
	/**
	 * Helper method to allow the use of get while maintaining the field letterCounter private.
	 * @param s the key to check.
	 * @return the value matched to key s in the letterCounter.
	 */
	public int get(String s)
	{
		return letterCounter.get(s);
	}
}
