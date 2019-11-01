package Frucht_p1;
import java.io.*;
import java.util.HashSet;       // A hash table that implements Set
import java.util.Scanner;
import java.util.Set;           // A collection that contains no dup elements


public class DuplicateRemover {
    private Set<String> uniqueWords;

    public void remove(String dataFile) throws IOException {
        String word;
        uniqueWords = new HashSet<>();
        Scanner scnr = new Scanner(new File(dataFile));
        while (scnr.hasNext()) {
            word = scnr.next();
            uniqueWords.add(word);
        }
        scnr.close();    // Closing scanner

    }

    public void write(String outputFile) throws IOException {
        File outFile;
        FileWriter outFileWrite;

        outFile = new File(outputFile);

        if (outFile.exists() == false)
            outFile.createNewFile();

        outFileWrite = new FileWriter(outFile, false);
        for (String uniqueWord : uniqueWords)
            outFileWrite.write(uniqueWord + "\n");

        outFileWrite.close();   // Closing file
        System.out.println("All Data has been written to the file successfully.");


    }


    public static class Application {
        public static void main(String[] args) throws IOException {
            DuplicateRemover duplicateRemover = new DuplicateRemover();
            int x = 0;  // Testing which IOException was thrown,
                        // rather than multiple try/catch blocks
            try {
                x = 1;
                duplicateRemover.remove("problem1.txt");
                x = 2;
                duplicateRemover.write("unique_words.txt");
            }
            catch (IOException e){
                if (x == 1)
                    System.out.println("Encountered an IOException in the \"remove\" method .\nAborting Program.");
                else
                    System.out.println("Encountered an IOException in the \"write\" method.\nAborting Program.");

            }
        }
    }
}
