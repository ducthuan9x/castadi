package File;


import Normal.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserFile {
    public static List<User> readFromFile() throws FileNotFoundException {
        List<User> userList = new ArrayList<>();
        File userFile = new File("user.csv");
        Scanner scanner = new Scanner(userFile);
        scanner.nextLine();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            } else {
                String arr[] = line.split(",");
                User user = new User(arr[0], arr[1]);
                userList.add(user);
            }
        }
        return userList;
    }

    public static void writeToFile(List<User> list) throws FileNotFoundException {
        File userFile = new File("user.csv");
        PrintWriter printWriter = new PrintWriter(userFile);
        printWriter.print("username,pass\n");
        for ( int i=0; i< list.size(); i++) {
            printWriter.print(list.get(i));
        }
        printWriter.close();
    }
}
