package assinment;

import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int count;

    public Playlist(int capacity) {
        this.songs = new String[capacity];
        this.count = 0;
    }

    public void addSong(String title) {
        if (count < songs.length) {
            songs[count] = title;
            count++;
        } else {
            System.out.println("Playlist is full!");
        }
    }

    // Returns a safe copy so external modifications don't affect internal data
    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        
        String[] copy = p.getSongs();
        copy[0] = "Hacked"; // Mutating the copy
        
        System.out.println("Playlist real content [0]: " + p.getSongs()[0]); // Still "Song A"
        System.out.println("Song Count: " + p.getSongCount()); // 2
    }
}

