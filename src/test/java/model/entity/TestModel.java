package model.entity;

import model.repository.MusicBandRepo;
import model.repository.RepoInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestModel {
    RepoInterface<MusicBand> musicBandRepo;

    @BeforeEach
    void setUp(){
        musicBandRepo = new MusicBandRepo();
    }

    @Test
    void testRepository(){
        MusicBand mb = MusicBand.builder().
                name("BeerHunters").
                coordinates(new Coordinates(10., 10)).
                genre(MusicGenre.BLUES).
                numberOfParticipants(7).
                bestAlbum(new Album("zapoy", 599999)).
                build();
        musicBandRepo.add(mb);
        MusicBand returned = musicBandRepo.getAll().stream().findFirst().orElse(null);
        Assertions.assertEquals(returned, mb);

        MusicBand newM = mb.toBuilder().name("blues").build();
        musicBandRepo.update(newM);
        MusicBand returnedUpd = musicBandRepo.getAll().stream().findFirst().orElse(null);
        Assertions.assertNotEquals(mb, newM);
        Assertions.assertEquals(returnedUpd, newM);

        Assertions.assertEquals(1, musicBandRepo.getAll().size());
        musicBandRepo.sumParticipants();
        Assertions.assertEquals(7,musicBandRepo.sumParticipants());


        musicBandRepo.findByNamePattern("Beer");
//        Assertions.assertEquals([],musicBandRepo.findByNamePattern("Beer"));

        musicBandRepo.clear();
        Assertions.assertEquals(0, musicBandRepo.getAll().size());
    }
}
