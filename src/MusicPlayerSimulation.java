import java.util.ArrayList;
import java.util.LinkedList;

public class MusicPlayerSimulation {

    private static final ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Master of Puppets", "Metallica");
        album.addSong("Battery", 5.12);
        album.addSong("Master of Puppets", 8.35);
        album.addSong("The Thing That Should Not Be", 6.36);
        album.addSong("Welcome Home", 6.27);
        album.addSong("Disposable Heroes", 8.16);
        album.addSong("Leper Messiah", 5.40);
        album.addSong("Orion", 8.27);
        album.addSong("Damage, Inc.", 5.32);
        albums.add(album);

        album = new Album("Warriors of the World", "Manowar");
        album.addSong("Call To Arms", 5.29);
        album.addSong("The Fight For Freedom", 4.24);
        album.addSong("Nessun Dorma", 3.26);
        album.addSong("Valhalla", 0.34);
        album.addSong("Swords In The Wind", 5.13);
        album.addSong("An American Trilogy", 4.16);
        album.addSong("The March", 3.58);
        album.addSong("Warriors Of The World United", 5.48);
        album.addSong("Hand Of Doom", 5.44);
        album.addSong("House Of Death", 4.21);
        album.addSong("Fight Until We Die", 4.00);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addSongToPlayList("Battery", playList);
        albums.get(0).addSongToPlayList("Master of Puppets", playList);
        albums.get(0).addSongToPlayList("Orion", playList);
        albums.get(0).addSongToPlayList("Disposable Heroes", playList);
        albums.get(1).addSongToPlayList(1, playList);
        albums.get(1).addSongToPlayList(3, playList);
        albums.get(1).addSongToPlayList(4, playList);
        albums.get(1).addSongToPlayList(7, playList);

    }
}
