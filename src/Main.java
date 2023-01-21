import java.util.*;

public class Main {
    public static List<Album> albums = new ArrayList<>();
    public static void main(String[] args) {


        Album album1 = new Album("Fearless","Taylor Swift");
        album1.addSongToAlbum("Love Story", 3.55);
        album1.addSongToAlbum("You Belong with Me", 3.51);
        album1.addSongToAlbum("Teardrops on My Guitar", 3.15);

        Album album2 = new Album("Map of the Soul: 7","BTS");
        album2.addSongToAlbum("Boy With Luv", 3.50);
        album2.addSongToAlbum("ON", 4.07);
        album2.addSongToAlbum("Louder than bombs", 3.38);
        album2.addSongToAlbum("Black Swan", 3.18);

        albums.add(album1);
        albums.add(album2);

        LinkedList<Song> myPlaylist = new LinkedList<>();
        album1.addToPlaylistFromAlbum("Love Story", myPlaylist); //added to playlist
        album2.addToPlaylistFromAlbum("Louder than bombs", myPlaylist); // song not present on the album.
        album2.addToPlaylistFromAlbum("Boy With Luv", myPlaylist);
        album1.addToPlaylistFromAlbum("You Belong with Me", myPlaylist);

        play(myPlaylist);



    }

    public static void play(LinkedList<Song> playList) {
        ListIterator<Song> itr = playList.listIterator();
        Scanner sc = new Scanner(System.in);


        boolean isForward = false;

        if(playList.size()>0){
            System.out.print("Currently playing: ");
            System.out.println(itr.next());
        }
        else{
            System.out.println("Playlist is empty");
            return;
        }
        System.out.println("Select your choice:");
        printMenu();

        boolean quit = false;
        while(!quit){
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    if(isForward==false){
                        itr.next();
                        isForward = true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                    }
                    else{
                        System.out.println("You have reached at the end of the playlist");
                        isForward = false;
                    }
                    break;
                case 2:
                    if(isForward==true){
                        itr.previous();
                        isForward = false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }
                    else{
                        System.out.println("You have reached at the start of the playlist");
                        isForward = true;
                    }
                    break;
                case 3:
                    if(isForward==true) {
                        if(itr.hasPrevious()){
                            System.out.println(itr.previous());
                            isForward = false;
                        }
                    }
                    else{
                        if(itr.hasNext()) {
                            System.out.println(itr.next());
                            isForward = true;
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    break;
                case 6:
                    printSongs(playList);
                    break;
                case 7:
                    quit = true;
                    break;



            }
        }
    }

    public static void printSongs( LinkedList <Song> playlist){
        for(Song song: playlist)
            System.out.println(song);
        return;
    }

    public static void printMenu(){

        System.out.println("1 - Play next song");
        System.out.println("2 - Play previous song");
        System.out.println("3 - Repeat the current song");
        System.out.println("4 - Show menu again");
        System.out.println("5 - Delete the current song");
        System.out.println("6 - Print all the songs in the playlist");
        System.out.println("7 - Exit");

        return;

    }

}