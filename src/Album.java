import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    private Song findSong(String searchedTitle){
        for(Song song : songs){
            if(song.getTitle().equals(searchedTitle)){
                return song;
            }
        }
        return null;
    }

    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    public boolean addSongToPlayList(int trackNumber, List<Song> playList){
        int songIndex = trackNumber - 1;
        if(songIndex >= 0 && songIndex <= this.songs.size()){
            playList.add(this.songs.get(songIndex));
            return true;
        }
        return false;
    }
}
