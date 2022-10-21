import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;
public class Battle 
{
	private Player player;
	private Monster monster;
	
	public Battle(Player player, Monster monster)
	{
		this.player = player;
		this.monster = monster;
	}
	
	public void run() throws IOException
	{
		appendToFile("Battle begins: " + player.getName() + " vs " + monster.getName());
		
		while(monster.isAlive() && player.isAlive())
		{
			appendToFile("Players hit points: " + player.getHitPoints() + ". Monster hit points: " + monster.getHitPoints());
			appendToFile("Players turn");
			appendToFile("Do you want to attack (a) or heal (h)");
			
			Scanner sc = new Scanner(System.in);
			char input = sc.next().charAt(0);
			
			/* file = new File("C:\\Users\\monte\\OneDrive\\Documents\\JCreator LE\\MyProjects\\Game\\classes\\GameLog.txt");
			Scanner inputFile = new Scanner("C:\\Users\\monte\\OneDrive\\Documents\\JCreator LE\\MyProjects\\Game\\classes\\GameLog.txt");
			String line = inputFile.nextLine();
			*/
			/*while(input != 'a' || input != 'h')
			{
				appendToFile("this is not a correct command");
				appendToFile("please enter a correct command");
				//String line = inputFile.nextLine();
			}*/
			
			if(input == 'a')
			{
				//appendToFile("a");
				//readLine();
				this.player.attack(monster);
				this.monster.takeDamage(player.getDamage());
			}
			else if(input == 'h')
			{
				//appendToFile("h");
				player.heal();
			}
			
			if(monster.isAlive())
				{
					appendToFile(monster.getName() + "'s turn");
					
					if(monster.canEnrage() == true)
					{
						monster.enrage();
					}
					
					monster.attack(player);
					player.takeDamage(monster.getDamage());
					
					if(!player.isAlive())
					{
						appendToFile("You are dead");
						appendToFile("The End");
					}
				}
				else
				{
					appendToFile("The monster is dead");
				}
		}
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
	
	public String readLine() throws IOException
	{
		String fileName = "C:\\Users\\monte\\OneDrive\\Documents\\JCreator LE\\MyProjects\\Game\\classes\\GameLog.txt";
		String fileContents = "";
		Scanner inputStream = null;
		try
		{
			File theFile = new File(fileName);
			
			inputStream = new Scanner(theFile);
			
			fileContents = inputStream.nextLine();
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("File not found");
		}
		finally
		{
			if(inputStream != null)
			{
				inputStream.close();
			}
			//System.out.println("File closed");
		}
		return fileContents;
	}
}
