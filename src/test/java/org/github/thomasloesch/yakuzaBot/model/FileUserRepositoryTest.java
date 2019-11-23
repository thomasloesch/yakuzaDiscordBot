package org.github.thomasloesch.yakuzaBot.model;

import org.junit.Test;

import java.io.File;
import org.mockito.Mockito;

public class FileUserRepositoryTest {

    @Test
    public void getUser() {
        File testFile = Mockito.spy(new File("src/test/resources/testRepo.json"));

        FileUserRepository repo = new FileUserRepository(testFile);

        User retval = repo.getUser(0);

        assert(retval != null);
        assert(retval.getDiscordID() == 0);
    }

    @Test
    public void saveUser() {
        File testFile = Mockito.spy(new File("src/test/resources/testRepo.json"));

        FileUserRepository repo = new FileUserRepository(testFile);

        boolean retval = repo.saveUser(0, "boss", 15);

        assert(retval);
    }

    @Test
    public void updateJob() {
        File testFile = Mockito.spy(new File("src/test/resources/testRepo.json"));

        FileUserRepository repo = new FileUserRepository(testFile);

        boolean retval = repo.updateJob(0, "boss");

        assert(retval);
    }

    @Test
    public void updateBalance() {
        File testFile = Mockito.spy(new File("src/test/resources/testRepo.json"));

        FileUserRepository repo = new FileUserRepository(testFile);

        boolean retval = repo.updateBalance(0, 60);

        assert(retval);
    }
}