package org.github.thomasloesch.yakuzaBot.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUserRepository implements IUserRepository {
    private File repoFile;

    public FileUserRepository(File repoFile) {
        this.repoFile = repoFile;
    }

    @Override
    public User getUser(long id) {
        ArrayList<User> users = getUsersFromFile();

        for (User u :
                users) {
            if (u.getDiscordID() == id)
                return u;
        }

        return null;
    }

    @Override
    public boolean saveUser(long id, String jobName, int balance) {
        ArrayList<User> users = getUsersFromFile();
        users.add(new User(jobName, id, balance));
        return writeRepoFile(users);
    }

    @Override
    public boolean updateJob(long id, String jobName) {
        ArrayList<User> users = getUsersFromFile();

        for (User u :
                users) {
            if (u.getDiscordID() == id)
                u.setJobName(jobName);
        }

        return writeRepoFile(users);
    }

    @Override
    public boolean updateBalance(long id, int balance) {
        ArrayList<User> users = getUsersFromFile();

        for (User u :
                users) {
            if (u.getDiscordID() == id)
                u.setBalance(balance);
        }

        return writeRepoFile(users);
    }

    private ArrayList<User> getUsersFromFile() {
        Scanner scan = readRepoFile();
        char[] content = new char[0];
        ArrayList<User> users = new ArrayList<>();

        try {
            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] entities = line.split(",");

                long discordId = Long.parseLong(entities[0]);
                String jobName = entities[1];
                int balance = Integer.parseInt(entities[2]);

                User newUser = new User(jobName, discordId, balance);
                users.add(newUser);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scan.close();
        }

        return users;
    }

    private boolean writeRepoFile(ArrayList<User> users) {
        try {
            FileWriter myWriter = new FileWriter(repoFile);
            myWriter.write(getUserArrayString(users));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return false;
    }

    private String getUserArrayString(ArrayList<User> users) {
        String retval = "";

        for (User u :
                users) {
            retval += u.toString() + "\n";
        }

        return retval;
    }

    private Scanner readRepoFile() {
        try {
            Scanner scanner = new Scanner(repoFile);
            return scanner;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Repo file not found.");
        }
        return null;
    }

}
