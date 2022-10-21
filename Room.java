import java.io.*;
import java.io.FileNotFoundException;
public class Room 
{
	private int roomIndex;
	private String description;
	private Monster monster;
	
	public Room(int roomIndex, String description, Monster monster)
	{
		this.roomIndex = roomIndex;
		this.description = description;
		this.monster = monster;
	}
	
	public Room(String description, Monster monster)
	{
		this.description = description;
		this.monster = monster;
	}
	
	public void enter(Player player) throws IOException
	{	
			if(this.monster.isAlive() == true)
			{
				appendToFile(player.getName() + " This room is " + this.description + " and has " + this.monster.getName());
			}
	}
	
	public boolean isComplete()
	{
		if(!monster.isAlive())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int getRoomIndex()
	{
		return roomIndex;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public Monster getMonster()
	{
		return monster;
	}
	
	public String toString()
	{
		String str = "";
		
		return str;
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
