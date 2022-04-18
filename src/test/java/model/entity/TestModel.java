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
//                bestAlbum("zapoy", )
                build();
        musicBandRepo.add(mb);
        MusicBand returned = musicBandRepo.getAll().stream().findFirst().orElse(null);
        Assertions.assertEquals(returned, mb, "not equal");

        MusicBand newM = mb.toBuilder().name("blues").build();
        musicBandRepo.update(newM);
        MusicBand returned1 = musicBandRepo.getAll().stream().findFirst().orElse(null);
        Assertions.assertNotEquals(mb, newM);
        Assertions.assertEquals(returned1, newM,"not equal");

    }
}
