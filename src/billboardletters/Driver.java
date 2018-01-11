package billboardletters;

public class Driver {
	
	/**
	 * Simply change the variables previousMessage and nextMessage to the desired messages and run.
	 * The method first registers the previous message into billboard 1.
	 * It then checks the next message and removes the common letters from billboard 1, 
	 * while registering the extra letters that are required into billboard 2.
	 * billboard 2 now contains the extra letters needed to construct the new message, while
	 * billboard 1 contains the unnecessary letters of the previous message that need to be removed.
	 * @param args Will not use the command line.
	 */
	public static void main(String[] args)
	{
		String previousMessage = "Tom marvolo riddle";
		String nextMessage = "I am lord voldemort";		
		String previousMessage_Trimmed = (previousMessage.replaceAll("\\s+","")).toUpperCase();
		String nextMessage_Trimmed = (nextMessage.replaceAll("\\s+","")).toUpperCase();
		
		Billboard billboard1 = new Billboard();
		Billboard billboard2 = new Billboard();
		
		billboard1.register(previousMessage_Trimmed);
		
		for(int i=0; i<nextMessage_Trimmed.length(); i++)
		{
			char current = nextMessage_Trimmed.charAt(i);
			if(billboard1.containsKey(current+"")
					&& billboard1.get(current+"") != 0)
			{
				billboard1.remove(current, 1);
			}
			else
			{
				billboard2.put(current, 1);
			}
		}
		
		System.out.println("You will need the following letters:");
		billboard2.print();
		System.out.println("You will take down the following letters:");
		billboard1.print();
	}
}
