import java.util.*;

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

        play(playList);
    }

    private static void play(LinkedList<Song> playList) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
        }

        displayMenu();
        while (!quit) {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    displayPlayList(playList);
                    break;
                case 5:
                    displayMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        System.out.println(listIterator.next().getTitle() + " removed");
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void displayPlayList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("===============================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
        System.out.println("===============================");
    }

    private static void displayMenu() {
        System.out.println("Select option: ");
        System.out.println("""
                0 - quit
                1 - next song
                2 - previous song
                3 - replay the current song
                4 - display songs in the playlist
                5 - print available actions
                6 - delete current song from playlist""");
    }
}
