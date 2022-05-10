package File;

import Normal.Candidate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CandidateFile {
        public static List<Candidate>readFromFile() throws FileNotFoundException {

            File candidateFile = new File("candidate.csv");
            List<Candidate> candidateList = new ArrayList<>();
            Scanner scanner = new Scanner(candidateFile);
            scanner.nextLine();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.equals("")) {
                    break;
                } else {
                    String arr[] = line.split(",");
                    Candidate candidate = new Candidate(Integer.parseInt(arr[0]), arr[1], arr[2],arr[3]);
                    candidateList.add(candidate);
                }
            }
            return candidateList;
        }

    public static void writeToFile(List<Candidate> list) throws FileNotFoundException {
        File candidateFile = new File("candidate.csv");
        PrintWriter printWriter = new PrintWriter(candidateFile);
        printWriter.print("idNumber,name,address,block\n");
        for ( int i=0; i< list.size(); i++) {
            printWriter.print(list.get(i));
        }
        printWriter.close();
    }
}
