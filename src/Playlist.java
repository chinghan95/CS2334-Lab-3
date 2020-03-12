/**
 * Each Playlist stores a reference to an ArrayList of Songs.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Playlist {
	
	/**
	 * Field : an ArrayList<Song> object
	 */
	private ArrayList<Song> songs;	
	/**
	 * Constructor initializing the empty Playlist 
	 */
	public Playlist()
	{
		this.songs = new ArrayList<Song>();
	}
	/**
	 * Constructor initializing Playlist from a file of info Strings.
	 * The Playlist should contain a Song for every line of the file, 
	 * and order of the Songs should match the file.
	 * @param filename
	 * @throws IOException
	 */
	public Playlist(String filename) throws IOException
	{
		this.songs = new ArrayList<Song>();
		
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line = reader.readLine();
		while (line != null) {
			//System.out.println(line);
			Song song = new Song(line);
			songs.add(song);
			line = reader.readLine();
		}
		reader.close();
	}
	/**
	 * Read a file of info Strings with the given name.
	 * For each line of the file, create a Song and add it to 
	 * the end of the Playlist. This method is intended to be
	 * a helper method for Playlist(String filename)
	 * and addSongs(String filename).
	 */
	private void load (String filename) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line = reader.readLine();
		while(line != null) {
			Song song = new Song(line);
			songs.add(song);
			line = reader.readLine();
		}
		reader.close();	
	}
	/**
	 * Save the output of toString() to a file with the given name.
	 */
	public void save (String filename) throws IOException
	{
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		
		for (int i = 0; i < songs.size(); ++i) {
			Song song = new Song(songs.get(i));
			writer.write(song.toString());
			writer.write("\n");
		}
		writer.close();
	}
	/**
	 * Add a copy of the given Song to the end of the Playlist.
	 */
	public void addSong (Song song)
	{
		Song newSong = new Song(song);
		songs.add(newSong);
	}
	/**
	 * Add a copy of the given Song to the Playlist at the given index.
	 */
	public void addSong (int index, Song song)
	{
		Song newSong = new Song(song);
		songs.add(index, newSong);
	}
	/**
	 * A public version of the method Load(String filename).
	 */
	public void addSongs (String filename) throws IOException
	{
		load(filename);
	}
	/**
	 * Return a copy of the Song with the given index.
	 */
	public Song getSong (int index)
	{
		Song song = songs.get(index);
		return song;
	}
	/**
	 * Return the number of Songs in the Playlist.
	 */
	public int numSongs()
	{
		return this.songs.size();
	}
	/**
	 * Increment the number of plays of the Song with the given index.
	 */
	public void playSong (int index)
	{
		Song song = songs.get(index);
		song.incrementPlays();		
	}
	/**
	 * Remove and return the Song with the given index.
	 */
	public Song removeSong (int index)
	{
		Song song = songs.get(index);
		songs.remove(index);
		return song;
	}
	/**
	 * Return a String with the values of the fields of every Song in the 
	 * Playlist. Create the String by calling toString() on each Song and 
	 * joining the output with newline characters.
	 */
	public String toString()
	{
		StringBuilder songInfo = new StringBuilder();
		
		// For each song, append its info and a newline character.
		for (int i = 0; i < songs.size(); ++i) {
			Song song = songs.get(i);
			songInfo.append(song.toString());
			songInfo.append("\n");
		}
		
		// Remove the final newline character so an extra line is not printed
		// to the console when printing the String with Systen.out.println.
		if (songInfo.length() > 0) {
			songInfo.deleteCharAt(songInfo.length() - 1);
		}
		
		return songInfo.toString();
	}
	/**
	 * Return the artist that appears most frequently in the Playlist.
	 * if the Playlist is empty, return null.
	 */
	public String favoriteArtist()
	{
		if (songs.size() != 0) {
			String favArtist = "";
			String tempArtist = "";
			int favArtistCount = 1;
			int tempCount = 1;
			
			for (int i = 0; i < (songs.size()-1); ++i) {
				tempArtist = songs.get(i).getArtist();
				
				for (int j = (i+1); j < songs.size(); ++j) {
					if (tempArtist.equals(songs.get(j).getArtist())){
						tempCount++;
					}
				}
				
				if (tempCount > favArtistCount) {
					favArtist = tempArtist;
					favArtistCount = tempCount;
				}	
				tempCount = 1;
			}
			return favArtist;
		}
		else {
			return null;
		}
	}
	/**
	 * Return the total length of all the Songs in the following format:
	 * "<hours>:<minutes>:<seconds>"
	 */
	public String totalPlaytime()
	{
		int totalHours = 0;
		int totalMinutes = 0;
		int totalSeconds = 0;
		
		for (int i = 0; i < songs.size(); ++i) {
			totalMinutes = totalMinutes + songs.get(i).getMinutes();
			totalSeconds = totalSeconds + songs.get(i).getSeconds();
		}
		/*
		 * The number of minutes and seconds should each be a number between
		 * 0 and 59. If the number of hours is 0, use this format instead: "<minutes>:<seconds>"
		 * Pad the number of seconds with a leading zero if it is less than 10. 
		 * If the number of hours is greater than 0, pad the number of minutes as well.
		 */
		if (totalSeconds > 59) {
			totalMinutes = totalMinutes + totalSeconds / 60;
			totalSeconds = totalSeconds % 60;
		}
		
		if (totalMinutes > 59) {
			totalHours = totalHours + totalMinutes / 60;
			totalMinutes = totalMinutes % 60;
		}
		
		if (totalHours > 0) {
			return String.format("%d", totalHours) + ":" + String.format("%02d", totalMinutes) + ":" + String.format("%02d", totalSeconds);
		}
		else {
			return String.format("%d", totalMinutes) + ":" + String.format("%02d", totalSeconds);
		}
		
	}
}
