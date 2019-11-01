package Frucht_p2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class DuplicateCounter {
    private Map<String,Integer> wordCounter;

    public void count(String dataFile) throws IOException {
        String word;
        Integer x;
        wordCounter = new HashMap<>();
        Scanner scnr = new Scanner(new File(dataFile));
        while (scnr.hasNext()) {
            word = scnr.next();
            x = wordCounter.get(word);
            wordCounter.put(word, (x == null)? 1 : x +1);
        }
        scnr.close();   // Closing scanner
    }

    public void write(String outputFile) throws IOException {
        File outFile;
        FileWriter outFileWrite;

        outFile = new File(outputFile);
        if (!outFile.exists()) {
            outFile.createNewFile();
            outFile = new File(outputFile);
        }

        outFileWrite = new FileWriter(outFile,false);
        for (Map.Entry<String,Integer> word : wordCounter.entrySet())
            outFileWrite.write(word.getKey() + " : " + word.getValue()+ "\n");

        outFileWrite.close();   // Closing file
        System.out.println("All Data has been written to the file successfully.");

    }

    public static class Application {
        public static void main(String[] args) {
            DuplicateCounter duplicateCounter = new DuplicateCounter();
            int x = 0;  // Testing which IOException was thrown,
                        // rather than multiple try/catch blocks
            try {
                x = 1;
                duplicateCounter.count("problem2.txt");
                x = 2;
                duplicateCounter.write("unique_word_counts.txt");
            }
            catch (IOException e){
                if (x == 1)
                    System.out.println("Encountered an IOException in the \"count\" method .\nAborting Program.");
                else
                    System.out.println("Encountered an IOException in the \"write\" method.\nAborting Program.");
            }
            }
        }
    }


