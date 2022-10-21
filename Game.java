import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
public class Game 
{
	private static Player player;
	private static ArrayList<Room> dungeon;
	private ArrayList<Monster> monsters = new ArrayList<Monster>(3);
	
	public void createNewFile() throws IOException
	{
		String fileName = "C:\\Users\\monte\\OneDrive\\Documents\\JCreator LE\\MyProjects\\Game\\classes\\GameLog.txt";
		PrintWriter outputFile = null;
		try
		{
			File file = new File("PlayerInfo.txt");
			outputFile = new PrintWriter(fileName);
			System.out.println("File " + fileName + " created");
			
			//outputFile.println("Champion");
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
			System.out.println("File closed");
		}
	}
	
	public void WriteToNewFile(String fileName, String fileContent)
	{
		PrintWriter outputFile = null;
		try
		{
			outputFile = new PrintWriter(fileName);
			
			outputFile.println(fileContent);
			System.out.println("wrote to file");
			
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
			System.out.println("File closed");
		}
	}
	
	public static void appendToFile(String fileName, String fileContent) throws IOException
	{
		PrintWriter outputFile = null;
		try
		{
			outputFile = new PrintWriter(fileName);
			
			 FileOutputStream fileOut= new FileOutputStream(fileName,true);
			 
			outputFile = new PrintWriter(fileOut);
			outputFile.println(fileContent);
			System.out.println("wrote to file");
			
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
			System.out.println("File closed");
		}
	}
	
	public Game()
	{
		try
		{
			String name;
			String description;
			String hitPoints;
			String damage;
			String healAmount;
		
			File file = new File("C:\\Users\\monte\\OneDrive\\Documents\\JCreator LE\\MyProjects\\Game\\classes\\PlayerInfo.txt");
			Scanner inputFile = new Scanner(file);
			
			//while(inputFile.hasNext())
				name = inputFile.nextLine();
				System.out.println(name);
				
				description = inputFile.nextLine();
				System.out.println(description);
				
				hitPoints = inputFile.nextLine();
				int hp = Integer.parseInt(hitPoints);
				System.out.println("Hit Points: " + hitPoints);
				
				damage = inputFile.nextLine();
				int dmg = Integer.parseInt(damage);
				System.out.println("Damage: " + damage);
				
				healAmount = inputFile.nextLine();
				int heal = Integer.parseInt(healAmount);
				System.out.println("Heal: " + healAmount);
				
				player = new Player(name,description,hp,dmg,heal);
				
				if(inputFile != null)
				{
					inputFile.close();
				}
				System.out.println("File closed");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("File not found");
		}
		
		try
		{
			String name;
			String description;
			String hitPoints;
			String damage;
			String enrageThreshold;
			
			//ArrayList<Monster> monsters = new ArrayList<Monster>(3);
			
			File file = new File("C:\\Users\\monte\\OneDrive\\Documents\\JCreator LE\\MyProjects\\Game\\classes\\MonsterInfo.txt");
			Scanner inputFile = new Scanner(file);
			
			//while(inputFile.hasNext())
			for(int i = 0; i < 3; i++)
			{
				name = inputFile.nextLine();
				System.out.println(name);
				
				description = inputFile.nextLine();
				System.out.println(description);
				
				hitPoints = inputFile.nextLine();
				int hp = Integer.parseInt(hitPoints);
				System.out.println("Hit Points: " + hitPoints);
				
				damage = inputFile.nextLine();
				int dmg = Integer.parseInt(damage);
				System.out.println("Damage: " + damage);
				
				enrageThreshold = inputFile.nextLine();
				int enraged = Integer.parseInt(enrageThreshold);
				System.out.println("Heal: " + enrageThreshold);
				
				Monster monster = new Monster(name,description,hp,dmg,enraged);
				monsters.add(monster);
			}
			
			if(inputFile != null)
			{
				inputFile.close();
			}
			System.out.println("File closed");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("File not found");
		}
		
		try
		{
			String roomNum;
			String description;
			String treasure;
			
			dungeon = new ArrayList<Room>(3);
			
			File file = new File("C:\\Users\\monte\\OneDrive\\Documents\\JCreator LE\\MyProjects\\Game\\classes\\RoomInfo.txt");
			Scanner inputFile = new Scanner(file);
			
			for(int i = 0; i < 3; i ++)
			{
				if(i != 2)
				{
					roomNum = inputFile.nextLine();
					int num = Integer.parseInt(roomNum);
					System.out.println("Room number: " + roomNum);
					
					description = inputFile.nextLine();
					System.out.println(description);
					
					Room room = new Room(num,description,monsters.get(i));
					dungeon.add(room);
				}
				else
				{
					description = inputFile.nextLine();
					System.out.println(description);
					
					treasure = inputFile.nextLine();
					System.out.println(treasure);
					
					TreasureRoom goldRoom = new TreasureRoom(description,monsters.get(i),treasure);
					dungeon.add(goldRoom);
				}
				
			}
			
			if(inputFile != null)
			{
				inputFile.close();
			}
			System.out.println("File closed");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("File not found");
		}
	}
	
	public static void play() throws IOException
	{
		String fileName = "C:\\Users\\monte\\OneDrive\\Documents\\JCreator LE\\MyProjects\\Game\\classes\\GameLog.txt";
		appendToFile(fileName,player.getName());
		
		for(int i = 0; i < 3; i++)
		{
			if(dungeon.get(i).isComplete() == false)
			{
				dungeon.get(i).enter(player);
				Battle battle = new Battle(player,dungeon.get(i).getMonster());
				
				if(i == 3)
				{
					appendToFile(dungeon.get(3).getTreasure());
				}
				battle.run();
			}
			else
			{
				System.out.println("The End");
			}
		}
	}
	
	public static void main(String[]args) throws IOException
	{
		Game game = new Game();
		game.play();
	}
}
