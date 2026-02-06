package tspSolver;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;

public class InputHandler {

    private String fileName;
    private Scanner scanner;
    private ArrayList<String> rowList;
    private String line;

    public InputHandler(String fileName) {
        this.fileName = fileName;
        rowList = new ArrayList<>();
        readFile();
    }

    private void readFile(){
    try {
        scanner = new Scanner(new File(fileName));
    } catch (FileNotFoundException e) {
        System.out.println("Full path name should be provided. FileNotFoundException.\n");
        exit(0); // exit method if file not found
    }
    
    // add null check here
    if (scanner != null) {
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (!(line.charAt(0) == '#')) {
                rowList.add(line);
            }
        }
    }
}

    public void printRowList(){
        for (String s : rowList) {
            System.out.println(s);
        }
    }

    public ArrayList<String> getRowList() {
        return rowList;
    }

    public void setRowList(ArrayList<String> rowList) {
        this.rowList = rowList;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}

