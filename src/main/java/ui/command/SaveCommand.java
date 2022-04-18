package ui.command;

import model.entity.MusicBand;
import model.repository.MusicBandRepo;
import ui.UserInterface;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;

public class SaveCommand extends NonTerminatingCommand {
    private MusicBandRepo musicBandRepo ;
    public SaveCommand(UserInterface ui, MusicBandRepo musicBandRepo) {
        super(ui);
        this.musicBandRepo = musicBandRepo;
    }
    @Override
    public void run() throws FileNotFoundException {
        String filePath = "C:\\Users\\andre\\IdeaProjects\\andrea\\src\\main\\resources\\data.xml";

        convertObjectToXml(musicBandRepo, filePath);
        for (MusicBand musicBand : musicBandRepo.getAll()) {
            System.out.println("Saved last changes: ");
            getUserInterface().writeMessage(musicBand.toString());
        }
    }
//            MusicBandRepo musicBandRepo = fromXmlToObject(filePath);
//            for (MusicBand musicBand1 : musicBandRepo.getAll()) {
//                System.out.println(musicBand1);


//
//        private static MusicBandRepo fromXmlToObject(String filePath) {
//            try {
//                // создаем объект JAXBContext - точку входа для JAXB
//                JAXBContext jaxbContext = JAXBContext.newInstance(MusicBandRepo.class);
//                Unmarshaller un = jaxbContext.createUnmarshaller();
//                return (MusicBandRepo) un.unmarshal(new File(filePath));
//            } catch (JAXBException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }

        // сохраняем объект в XML файл
        private static void convertObjectToXml(MusicBandRepo musicBandRepo, String filePath) {
            try {
                JAXBContext context = JAXBContext.newInstance(MusicBandRepo.class);
                Marshaller marshaller = context.createMarshaller();
                // устанавливаем флаг для читабельного вывода XML в JAXB
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                // маршаллинг объекта в файл
                marshaller.marshal(musicBandRepo, new File(filePath));
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }

