package ui;

import ui.command.ExecuteScriptCommand;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileUserInterface implements UserInterface {
    private File _file;
    private Scanner scanner;
    private String path;

    public static final String defaultFilePath = "C:\\Users\\andre\\IdeaProjects\\andrea\\src\\main\\resources\\script";

    public FileUserInterface(String path) throws Exception {
        if (path.equals("-")) {
            this.path = defaultFilePath;
        } else {
            this.path = path;
        }
        if (ExecuteScriptCommand.pathsInExecute.contains(path)) {
            throw new Exception("if you call ec from this path - you get execute cycle");
        }
        _file = new File(this.path);
        try {
            scanner = new Scanner(_file, StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Scanner getScanner() {
        return scanner;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String readStringValue(String message) {
        System.out.println((char) 27 + "[35mEnter " + message + " >" + (char) 27 + "[0m");
        while (!scanner.hasNext() ) {
            System.out.println((char) 27 + "[35mEnter " + message + " >" + (char) 27 + "[0m");
            try {
                scanner.next();
            }
            catch (Exception ignored) {
                System.out.println("wtf are you doing?");
                return "q";
            }
        }

        return scanner.next();
    }

    @Override
    public long readLongValue(String message) {
        System.out.println((char) 27 + "[35mEnter " + message + " >" + (char) 27 + "[0m");
        while (!scanner.hasNextLong()) {
            System.out.println((char) 27 + "[35mEnter " + message + " >" + (char) 27 + "[0m");
            scanner.next();
        }
        return scanner.nextLong();
    }

    @Override
    public Double readDoubleValue(String message) {
        System.out.println((char) 27 + "[35mEnter " + message + " >" + (char) 27 + "[0m");
        while (!scanner.hasNextDouble()) {
            System.out.println((char) 27 + "[35mEnter " + message + " >" + (char) 27 + "[0m");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    @Override
    public Integer readIntegerValue(String message) {
        System.out.println((char) 27 + "[35mEnter " + message + " >" + (char) 27 + "[0m");
        while (!scanner.hasNextInt()) {
            System.out.println((char) 27 + "[35mEnter " + message + " >" + (char) 27 + "[0m");
            scanner.next();
        }
        return scanner.nextInt();
    }


    @Override
    public void writeMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void writeReturnedValue(String valueName, String value) {
        System.out.println((char) 27 + "[32m" + valueName + ": " + value + (char)27 + "[0m");
    }

    @Override
    public void writeWarning(String message) {
        System.out.println((char) 27 + "[31m" + message + (char)27 + "[0m");
    }
}
