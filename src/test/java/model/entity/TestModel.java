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

        musicBandRepo.findByNamePattern("blues");
        MusicBand musicBand2 = musicBandRepo.getAll().stream().findFirst().orElse(null);
        Assertions.assertEquals(musicBand2, newM);

        musicBandRepo.filterByParts(7);
        MusicBand musicBand1 = musicBandRepo.getAll().stream().findFirst().orElse(null);
        Assertions.assertEquals(musicBand1, newM);

        musicBandRepo.clear();
        Assertions.assertEquals(0, musicBandRepo.getAll().size());


        musicBandRepo.add(mb);
        musicBandRepo.remove(1);
        Assertions.assertEquals(0, musicBandRepo.getAll().size());

        musicBandRepo.add(mb);
        MusicBand mb1 = MusicBand.builder().
                name("BeerHunters2").
                coordinates(new Coordinates(10., 10)).
                genre(MusicGenre.BLUES).
                numberOfParticipants(9).
                bestAlbum(new Album("zapoyscshiki", 999999)).
                build();
        musicBandRepo.add(mb1);
        musicBandRepo.removeGreater(mb1);
        Assertions.assertEquals(2,musicBandRepo.getAll().size());
        musicBandRepo.removeGreater(mb);
        Assertions.assertEquals(1, musicBandRepo.getAll().size());

        MusicBand mb3 = MusicBand.builder().
                name("BeerHunters3").
                coordinates(new Coordinates(10., 10)).
                genre(MusicGenre.BLUES).
                numberOfParticipants(3).
                bestAlbum(new Album("pivasik", 9999)).
                build();
        musicBandRepo.addIfMax(mb3);

        Assertions.assertEquals(1,musicBandRepo.getAll().size());


    }
}
