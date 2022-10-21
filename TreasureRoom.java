import java.io.*;
import java.io.FileNotFoundException;
public class TreasureRoom extends Room
{
	private String treasure;
	
	public TreasureRoom(String description, Monster monster, String treasure)
	{
		super(description,monster);
		this.treasure = treasure;
	}
	
	public void enter(Player player) throws IOException
	{
		appendToFile("This room is " + super.getDescription() + " and has " + super.getMonster().getName());
		
		if(!super.getMonster().isAlive())
		{
			
		}
	}
	
	public String getTreasure()
	{
		return this.treasure;
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
