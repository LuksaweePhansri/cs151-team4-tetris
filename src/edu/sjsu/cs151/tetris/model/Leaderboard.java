package edu.sjsu.cs151.tetris.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Leaderboard 
{
	public Leaderboard()
	{
		playerList = new ArrayList<Player>();
	}
	
	/**
	 * This method reads in all players and adds them to the existed list of players.
	 */
	public void readPlayers()
	{
		ArrayList <String> list = new ArrayList<String>();
		Player tmp = new Player();
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader("src/edu/sjsu/cs151/tetris/model/players.txt")); // /Users/Luksawee/Desktop/
			while (br.ready()) 
			{
				// The output from br.readLine() is string; therefore we need to convert from string to int.
				list.add(br.readLine());
				numberPlayers++;
			}
		//close file
		br.close();
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		String [] table;
		String [] playersName = new String[numberPlayers];
		int [][] playerScore = new int [numberPlayers][6];
		/**
		 * case: there is an existed player name.
		 */
		for (int i = 0; i < numberPlayers; i++)
		{
			table = list.get(i).split(", ");
			playersName[i] = table[0];
			tmp.setName(playersName[i]);
			
			// update player score level 1, 2, 3, 4, 5
			for (int j =1; j < 6; j++)
			{
			playerScore[i][j] = Integer.parseInt(table[j]);
			tmp.setPlayerScore(j, playerScore[i][j]);
			}
			
			tmp.setPlayerHighScore();
			tmp.getPlayerHighScore();
					
			playerList.add(i, tmp);
			tmp = new Player();
		}
	}
	
	/**
	 * This method will re reads in all players and get all the current data.
	 */
	public void getCurrentPlayersData()
	{
		ArrayList <String> list = new ArrayList<String>();
		Player tmp = new Player();
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader("src/edu/sjsu/cs151/tetris/model/players.txt")); // /Users/Luksawee/Desktop/
			while (br.ready()) 
			{
				// The output from br.readLine() is string; therefore we need to convert from string to int.
				list.add(br.readLine());
			}
		//close file
		br.close();
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		String [] table;
		String [] playersName = new String[numberPlayers];
		int [][] playerScore = new int [numberPlayers][6];
		/**
		 * case: there is an existed player name.
		 */
		for (int i = 0; i < numberPlayers; i++)
		{
			table = list.get(i).split(", ");
			playersName[i] = table[0];
			tmp.setName(playersName[i]);
			
			// update player score level 1, 2, 3, 4, 5
			for (int j =1; j < 6; j++)
			{
			playerScore[i][j] = Integer.parseInt(table[j]);
			tmp.setPlayerScore(j, playerScore[i][j]);
			}
			
			tmp.setPlayerHighScore();
			tmp.getPlayerHighScore();
					
			playerList.add(i, tmp);
			tmp = new Player();
		}
	}
	
	
	/**
	 * This method returns the current list of players.
	 * @return The list of players
	 */
	public ArrayList<Player> getPlayer()
	{
		return playerList;
	}
	
	/**
	 * This method return the current number of player in the existed file
	 * @return numberPlayers
	 */
	public int getNumberPlayers()
	{
		return numberPlayers;
	}
	
	
	public int getPlayerIndex(String aName)
	{
		Player tmp = new Player();
		int index = 0;
		for(int i = 0; i < numberPlayers; i++)
		{
			tmp = playerList.get(i);
			if ((aName).equals(tmp.getName()))
				index = i;
		}
			return index;
	}
	
	public Player loadPlayer(String aName)
	{
		int index = getPlayerIndex(aName);
		return playerList.get(index);
	}
	
	/**
	 * This method will check whether not player has already token.
	 * @param newPlayer newPlayer the object in the player
	 * @return true is the 
	 */
	public boolean isValidNewPlayers(Player newPlayer)
	{		
		Player tmp = new Player();
		for (int i = 0; i < numberPlayers; i++)
		{
			tmp = playerList.get(i);
			if ((newPlayer.getName()).equalsIgnoreCase(tmp.getName()))
			{
				//System.out.println("Invalid new username");
				return false;
			}
			tmp = new Player();
		}
		return true;
	}

	/**
	 * This method is used to add new player.
	 * @param aName given new player
	 */
	public void addNewPlayer(Player newPlayer)
	{
		if (isValidNewPlayers(newPlayer) == true)
		{
			try 
			{				
				FileWriter writer = new FileWriter("src/edu/sjsu/cs151/tetris/model/players.txt", true); // /Users/Luksawee/Desktop/
				writer.write(newPlayer.getName());
							
				int [] playerScore = newPlayer.getPlayerScore();
				for(int i = 0; i < 6; i++)
				{
					writer.write(", ");	
					writer.write(Integer.toString(playerScore[i]));
				}
				writer.write("\r\n");
				writer.close();
				//numberPlayers++;
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		else
			System.out.println("The username has already taken");	
	}
	
	/**
	 * This method will save the player score to the player.txt
	 */
	public void savePlayer(String oldData, String newData) 
	{
		String filePath = "src/edu/sjsu/cs151/tetris/model/players.txt";
		File file = new File(filePath);
		String oldContent = "";
		BufferedReader reader = null;
		FileWriter writer = null;

		try {
			reader = new BufferedReader(new FileReader(file));

			// Reading all the lines of input text file into oldContent
			String line = reader.readLine();
			while (line != null) {
				oldContent = oldContent + line + System.lineSeparator();

				line = reader.readLine();
			}
			// Replacing oldString with newString in the oldContent

			String newContent = oldContent.replaceAll(oldData, newData);

			// Rewriting the input text file with newContent

			writer = new FileWriter(file);
			writer.write(newContent);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// Closing the resources

				reader.close();

				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private ArrayList <Player> playerList;
	private int numberPlayers;
}
