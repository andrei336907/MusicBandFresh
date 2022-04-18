//package ui;
//
//import model.repository.MusicBandRepo;
//
//import java.io.*;
//import java.nio.charset.StandardCharsets;
//
//public class FileUserInterface<T> implements  UserInterface{
//    File file = new File("C:\\Users\\andre\\IdeaProjects\\andrea\\src\\main\\resources\\data.xml");
//    FileInputStream fileInputStream = new FileInputStream(file);
//    FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\andre\\IdeaProjects\\andrea\\src\\main\\resources\\data/xml");
//    BufferedInputStream inputStream = new BufferedInputStream(fileInputStream);
//    BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream);
//
//    public FileUserInterface() throws FileNotFoundException {
//    }
//    public void write(MusicBandRepo musicBandRepo){
//        try{
//            if (!file.exists()){
//                if (!file.createNewFile()){
//                    System.out.println("Error! Cannot create file");
//                }
//            }
//
//            String toBeWritten = musicBandRepo.toString();
//            fileOutputStream.write(toBeWritten.getBytes(StandardCharsets.UTF_8));
//
//            fileOutputStream.flush();
//            fileOutputStream.close();
//        }
//        catch (IOException e){
//            System.out.println("Error!: " + e.getMessage());
//        }
//
//    }
//}
//
//    @Override
//     public String readStringValue(String message) throws FileNotFoundException {
//         inputStream.; //add music band
//     }
//
//            MusicBandRepo musicBandRepo = fromXmlToObject(filePath);
//            for (MusicBand musicBand1 : musicBandRepo.getAll()) {
//                System.out.println(musicBand1);
//
//
//
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
// }
