package ui.command;

import model.repository.MusicBandRepo;
import ui.UserInterface;

import java.io.FileNotFoundException;

public class ReadFromFile extends NonTerminatingCommand {
    private MusicBandRepo musicBandRepo;

    public ReadFromFile(UserInterface ui, MusicBandRepo musicBandRepo) {
        super(ui);
        this.musicBandRepo = musicBandRepo;
    }

//    MusicBandRepo musicBandRepo = fromXmlToObject(file.getPath());
//    File file = new File("C:\\Users\\andre\\IdeaProjects\\andrea\\src\\main\\resources\\data.xml");
//    FileInputStream fileInputStream;
//
//    {
//        try {
//            fileInputStream = new FileInputStream(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//    FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\andre\\IdeaProjects\\andrea\\src\\main\\resources\\data/xml");
//    BufferedInputStream inputStream = new BufferedInputStream(fileInputStream);
//    BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream);




//    @Override
//     public String readStringValue(String message) throws FileNotFoundException {
//         inputStream.; //add music band
//     }
//            MusicBandRepo musicBandRepo = fromXmlToObject(filePath);
//            for (
//    MusicBand musicBand1 : musicBandRepo.getAll()) {
//                System.out.println(musicBand1);



//        private static MusicBandRepo fromXmlToObject(String filePath) {
//            try {
//                // создаем объект JAXBContext - точку входа для JAXB
//                JAXBContext jaxbContext = JAXBContext.newInstance(MusicBandRepo.class);
//                Unmarshaller un = jaxbContext.createUnmarshaller();
//                return (MusicBandRepo) un.unmarshal(new File(filePath));
//            }
//            catch (JAXBException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }

    @Override
    public void run() throws FileNotFoundException {

        musicBandRepo.readFromFile();
        getUserInterface("eve").writeMessage("Collection uploaded");
    }
}
