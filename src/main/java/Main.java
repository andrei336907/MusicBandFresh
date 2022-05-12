import model.MySpotify;

import java.io.FileNotFoundException;


public class Main {


    public static void main(String[] args) throws FileNotFoundException {

//        String path = "C:\\demo\\demofile.txt";
//        UserInterface userInterface = new FileUserInterface(path);

        MySpotify mySpotify = new MySpotify();
//        MySpotify mySpotify = new MySpotify(userInterface);
        mySpotify.Start();

    }
}