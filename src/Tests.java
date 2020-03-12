import java.io.IOException;

/**
 * Lab 3 Tests template
 * CS 2334 Spring 2020
 * @author Ching Han Huang
 * Date 01/30/20
 */
public class Tests {

	public static void main(String[] args) throws IOException {
		
		String info = "Vital Signs,Rush,4:43";
		Song song2 = new Song(info);
		Song song = new Song(song2);
		
		/**
		 * Test Song class
		 */
		// Check that the fields were initialized correctly.
		if (!song.getTitle().equals("Vital Signs")) {
			System.out.println("Incorrect title");
		}
		if (!song.getArtist().equals("Rush")) {
			System.out.println("Incorrect artist");
		}
		if (song.getMinutes() != 4) {
			System.out.println("Incorrect minutes");
		}
		if (song.getSeconds() != 43) {
			System.out.println("Incorrect seconds");
		}
		if (song.getNumPlays() != 0) {
			System.out.println("Incorrect numPlays");
		}
		if (!song.getLength().equals("4:43")) {
			System.out.println("Incorrect length");
		}

		// If the number of plays is not changed, toString should return a
		// String that is identical to the one used to construct the object.
		if (!song.toString().equals(info)) {
			System.out.println("Incorrect String returned by toString");
		}
		
		// Increment the number of plays a bunch of times.
		for (int count = 0; count < 42; ++count) {
			song.incrementPlays();
		}
		
		// Check that the number of plays changed.
		if (song.getNumPlays() != 42) {
			System.out.println("incrementPlays incorrectly updated numPlays");
		}
		
		// The String output by toString now includes an optional fourth value 
		// that specifies the number of plays.
		String newInfo = "Vital Signs,Rush,4:43,42";
		if (!song.toString().equals(newInfo)) {
			System.out.println("Incorrect String returned by toString");
		}

		/*
		 * Test Playlist class
		 */
		Playlist songList = new Playlist("text.txt");
		// Test getSong method
		System.out.println(songList.getSong(0).getArtist());
		// Test numSongs method
		System.out.println(songList.numSongs());
		// Test removeSong method
		//System.out.println(songList.removeSong(0).getArtist());
		// Test toString method
		System.out.println(songList.toString());
		// Test favoriteArtist method
		System.out.println(songList.favoriteArtist());
		// Test totalPlaytime method
		//System.out.println(songList.totalPlaytime());
		if (songList.totalPlaytime().equals("1:43:07")) {
			System.out.println("Incorrect calculation returned by totalPlayTime() method");
		}
		else {
			System.out.println(songList.totalPlaytime());
		}
	}
}
