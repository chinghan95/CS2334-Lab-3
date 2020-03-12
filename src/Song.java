/**
 * 
 * @author Ching Han Huang
 * Date : 01/30/2020
 *
 */
public class Song {
	
	/**
	 * Each Song has a title, artist, length, and play count.
	 */
	private String title;
	private String artist;
	private int minutes;
	private int seconds;
	private int numPlays;
	private static final int IDX_TITLE = 0;
	private static final int IDX_ARTIST = 1;
	private static final int IDX_LENGTH = 2;
	private static final int IDX_NUM_PLAYS = 3;
	
	public Song(String info)
	{
		/**
		 * Constructor initializing 
		 * title to the first index of info array
		 * artist to the second index of info array
		 * minutes and seconds to the third index of info array 
		 * numPlays to the forth index of info array
		 */
		String[] infoArr = info.split(",");
		this.title = infoArr[IDX_TITLE];
		this.artist = infoArr[IDX_ARTIST];
		
		String[] songLengthArr = infoArr[IDX_LENGTH].split(":");
		this.minutes = Integer.parseInt(songLengthArr[0]);
		this.seconds = Integer.parseInt(songLengthArr[1]);
		
		if (infoArr.length < (IDX_NUM_PLAYS + 1))
		{
			this.numPlays = 0;
		}
		else
		{
			this.numPlays = Integer.parseInt(infoArr[IDX_NUM_PLAYS]);			
		}
		
	}
	/**
	 * This is known as a "copy constructor." It creates a new Song that
	 * is a copy of an existing Song. That is, it initializes the fields
	 * of the new Song to the values stored in the given Song.
	 */
	public Song(Song other)
	{
		this.title = other.getTitle();
		this.artist = other.getArtist();
		this.minutes = other.getMinutes();
		this.seconds = other.getSeconds();
		this.numPlays = other.getNumPlays();
	}
	/**
	 * Return the title of song
	 * @return a String of the title of song
	 */
	public String getTitle()
	{
		return title;
	}
	/**
	 * Return the artist of song
	 * @return a String representing the artist of song
	 */
	public String getArtist()
	{
		return artist;
	}
	/**
	 * Return the length of minutes of song
	 * @return an int value representing the length of minutes of song
	 */
	public int getMinutes()
	{
		return minutes;
	}
	/**
	 * Return the length of seconds of song
	 * @return an int value representing the length of seconds of song
	 */
	public int getSeconds()
	{
		return seconds;
	}
	/** 
	 * Return the song length in the format of an info String
	 * @return an String representing the song length in minutes:seconds
	 */
	public String getLength()
	{
		return String.format("%d", minutes) + ":" + String.format("%02d", seconds);
	}
	/**
	 * Return the number plays of song
	 * @return an int value representing the number plays of song
	 */
	public int getNumPlays()
	{
		return numPlays;
	}
	/**
	 * Increase numPlays by 1
	 */
	public void incrementPlays()
	{
		this.numPlays = this.numPlays + 1;
	}
	/**
	 * Return an info String with the values of the fields.
	 * If numPlays is 0, do not include it in the output
	 */
	public String toString()
	{
		if (this.numPlays != 0)
		{
			return title + "," + artist + "," 
					+ String.format("%d", minutes) + ":" + String.format("%02d", seconds) + "," + numPlays;			
		}
		else
		{
			return title + "," + artist + "," 
					+ String.format("%d", minutes) + ":" + String.format("%02d", seconds);			
		}
	}
	
	
}
