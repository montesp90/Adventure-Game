import java.io.*;
import java.io.FileNotFoundException;
public class Player extends Creature
{
	private int healAmount;
	
	public Player(String name, String description, int hitPoints, int damage, int healAmount)
	{
		super(name,description,hitPoints,damage);
			
		this.healAmount = healAmount;
	}
	
	public void heal() throws IOException
	{
		int heal = super.getHitPoints() + this.healAmount;
		super.setHitPoints(heal);
		
		appendToFile(super.getName() + " is healed by " + this.healAmount);
	}
	
	public void appendToFile(String fileContent) throws IOException
	{
		String fileName = "C:\\Users\\monte\\OneDrive\\Documents\\JCreator LE\\MyProjects\\Game\\classes\\GameLog.txt";
		PrintWriter outputFile = null;
		try
		{
			outputFile = new PrintWriter(fileName);
			
			 FileOutputStream fileOut= new FileOutputStream(fileName,true);
			 
			outputFile = new PrintWriter(fileOut);
			outputFile.println(fileContent);
			System.out.println(fileContent);
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("File not found");
		}
		finally
		{
			if(outputFile != null)
			{
				outputFile.close();
			}
			//System.out.println("File closed");
		}
	}
}
