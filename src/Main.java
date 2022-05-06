import ManegeCandidate.ManegeCandidate;

import File.CandidateFile;
import Normal.Candidate;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        ManegeCandidate mc=new ManegeCandidate();
//        mc.add(new Candidate(1,"kk","hn"));
//        mc.display();
//        CandidateFile.writeToFile(mc.getCandidateList());
//        CandidateFile.readFromFile();




         ManegeCandidate mc = new ManegeCandidate();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("---------MENU--------");
            System.out.println("1: thêm thí sinh dự thi");
            System.out.println("2: tìm kiếm theo số báo danh");
            System.out.println("3: đọc thí sinh trên file");
            System.out.println("4: phân loại thí sinh theo khối");
            System.out.println("1: thêm thí sinh dự thi");
            System.out.println("1: thêm thí sinh dự thi");
            System.out.println("1: thêm thí sinh dự thi");
                    try {
                        choice = scanner.nextInt();
//      bắt ngoại lệ1
                    } catch (InputMismatchException a) {
                        System.out.println("nhập sai , trở lại menu");
                        scanner.nextLine();
                    }

                    if (choice == 1) {
                        System.out.println("nhập số báo danh ");
                        scanner.nextLine();
                        int idNumber = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("nhập họ tên ");
                        String name = scanner.nextLine();
                        System.out.println("nhập địa chỉ ");
                        String address = scanner.nextLine();
                        System.out.println("nhập khối thi");
                        String block=scanner.nextLine();
                        mc.add(new Candidate(idNumber,name,address,block));
                    } else if (choice == 2) {
//       tìm kiem theo so bao danh
                        System.out.println("nhập số báo danh ");
                        int idNumber= scanner.nextInt();
                        mc.seachById(idNumber);

                    }
                    else if (choice == 3) {
////      đọc file
                        System.out.println(CandidateFile.readFromFile());
                    }
                    else if(choice==4){
        // tìm theo khối
                        System.out.println("nhập khối thi");
                        scanner.nextLine();
                        String block=scanner.nextLine();
                        mc.seachByBlock(block);
                    }

        }while (choice!=0);

    }
}
