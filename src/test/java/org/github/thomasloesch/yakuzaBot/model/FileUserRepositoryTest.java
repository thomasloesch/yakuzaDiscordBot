package org.github.thomasloesch.yakuzaBot.model;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileUserRepositoryTest {

    private static final String TEST_FILE_LOCATION = "src/test/resources/testRepo.csv";
    private static final String FILE_CONTENTS =
            "0,drug dealer,0\n" +
            "1,bouncer,10\n" +
            "2,hitman,10000\n";

    @Test
    public void getUser() {
        resetTestInputFile();

        File testFile = new File(TEST_FILE_LOCATION);
        FileUserRepository repo = Mockito.spy(new FileUserRepository(testFile));

        User retval = repo.getUser(0);

        assert(retval != null);
        assert(retval.getDiscordID() == 0);
        assert(retval.getJobName().equals("drug dealer"));
        assert(retval.getBalance() == 0);
    }

    @Test
    public void saveUser() {
        resetTestInputFile();

        File testFile = new File(TEST_FILE_LOCATION);
        FileUserRepository repo = Mockito.spy(new FileUserRepository(testFile));

        boolean retval = repo.saveUser(0, "boss", 15);

        assert(retval);

    }

    @Test
    public void updateJob() {
        resetTestInputFile();

        File testFile = new File(TEST_FILE_LOCATION);
        FileUserRepository repo = Mockito.spy(new FileUserRepository(testFile));

        boolean retval = repo.updateJob(0, "boss");

        assert(retval);
    }

    @Test
    public void updateBalance() {
        resetTestInputFile();

        File testFile = new File(TEST_FILE_LOCATION);
        FileUserRepository repo = Mockito.spy(new FileUserRepository(testFile));

        boolean retval = repo.updateBalance(0, 60);

        assert(retval);
    }

    private static void resetTestInputFile() {
        File testFile = new File(TEST_FILE_LOCATION);

        if (testFile.exists()) {
            testFile.delete();
        }

        try {
            FileWriter writer = new FileWriter(testFile);
            writer.write(FILE_CONTENTS);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}