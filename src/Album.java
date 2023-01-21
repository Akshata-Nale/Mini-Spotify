import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    // Functionalities
    public boolean findSong(String title){
        for(Song s : songs){
            if(s.getTitle().equals(title))
                return true;
        }
        return false;
    }
    void addSongToAlbum(String name, double duration){
        Song s = new Song(name,duration);
        if(findSong(s.getTitle())==true){
            System.out.println("Song is already present in album");
        }
        else{
            songs.add(s);
        }
        return;
    }

    //Using polymorphism
    public void addToPlaylistFromAlbum(String title, LinkedList<Song> playlist){
        if(findSong(title)==true){
            for(Song song : songs){
                if(song.getTitle().equals(title)){
                    playlist.add(song);
                    System.out.println(title + " has been added to the playlist.");
                    break;
                }
            }
        }
        else{
            System.out.println("Song is not present in the Album.");
        }
        return;
    }

    public void addToPlaylistFromAlbum(int trackNo, LinkedList<Song> playlist){
        int index = trackNo-1;
        if(index>=0 && index<songs.size()){
            playlist.add(songs.get(index));
            System.out.println("Track number: "+ trackNo + " has been added to the playlist.");
        }
        else{
            System.out.println("Invalid track number");
        }
    }

}
