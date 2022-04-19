import model.MySpotify;

import java.io.FileNotFoundException;


public class Main {


    public static void main(String[] args) throws FileNotFoundException {
//        MusicBandRepo musicBandRepo = new ReadFromFile();

        MySpotify mySpotify = new MySpotify();
        mySpotify.Start();

    }
}