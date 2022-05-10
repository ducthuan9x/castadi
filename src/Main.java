import ManegeCandidate.ManegeCandidate;

import File.CandidateFile;
import Normal.Candidate;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import ManegeCandidate.ManegeUser;
import Normal.User;

public class Main {
    public static void main(String[] args) throws IOException {

        ManegeCandidate mc = new ManegeCandidate();
        Scanner scanner = new Scanner(System.in);
        ManegeUser manegeUser = new ManegeUser();
        String flag;
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1.Đăng Nhập ");
            System.out.println("2.Đăng kí ");
            System.out.println("0.Thoát");
            System.out.print("Nhập lựa chon : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Mời bạn đăng nhập : ");
                    System.out.println("Nhập username : ");
                    String username = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Nhập userpass : ");
                    String pass = sc.nextLine();
                    if (manegeUser.find(username, pass) != -1) {
                        System.out.println("Bạn đăng nhập thành công ");
                        System.out.println("-------------------------- ");
                        System.out.println(manegeUser.display(username, pass));
                        int choice1 = -1;
                        do {
                            System.out.println("1.Vào trang quản lý : ");
                            System.out.println("2.Xem thông tin tài khoản : ");
                            System.out.println("3.Đăng xuất : ");
                            System.out.print("Nhập lựa chọn của bạn : ");
                            choice1 = sc.nextInt();
                            switch (choice1) {
                                case 1:
                                    int choice2 = -1;
                                    do {
                                        System.out.println("---------MENU--------");
                                        System.out.println("1: thêm thí sinh dự thi");
                                        System.out.println("2: tìm kiếm theo số báo danh");
                                        System.out.println("3: đọc thí sinh trên file");
                                        System.out.println("4: phân loại thí sinh theo khối");
                                        System.out.println("5: xoá thí sinh dự thi");
                                        System.out.println("6: sửa thông tin thí sinh dự thi");
                                        System.out.println("7: sắp xếp thí sinh dự thi theo số báo danh");

                                        try {
                                            choice2 = scanner.nextInt();
//      bắt ngoại lệ1
                                        } catch (InputMismatchException a) {
                                            System.out.println("nhập sai , trở lại menu");
                                            scanner.nextLine();
                                        }

                                        if (choice2 == 1) {
                                            System.out.println("nhập số báo danh ");
                                            scanner.nextLine();
                                            int idNumber = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("nhập họ tên ");
                                            String name = scanner.nextLine();
                                            System.out.println("nhập địa chỉ ");
                                            String address = scanner.nextLine();
                                            System.out.println("nhập khối thi");
                                            String block = scanner.nextLine();
                                            mc.add(new Candidate(idNumber, name, address, block));
                                            mc.display();
                                        } else if (choice2 == 2) {
//       tìm kiem theo so bao danh
                                            System.out.println("nhập số báo danh ");
                                            int idNumber = scanner.nextInt();
                                            mc.seachById(idNumber);

                                        } else if (choice2 == 3) {
////      đọc file
                                            System.out.println(CandidateFile.readFromFile());
                                        } else if (choice2 == 4) {
                                            // tìm theo khối
                                            System.out.println("nhập khối thi");
                                            scanner.nextLine();
                                            String block = scanner.nextLine();
                                            mc.seachByBlock(block);
                                        } else if (choice2 == 5) {
                                            //xoá thí sinh
                                            System.out.println("nhập số báo danh ");
                                            int idNumber = scanner.nextInt();
                                            mc.delete(idNumber);
                                        } else if (choice2 == 6) {
                                            System.out.println("nhập số báo danh ");
                                            int idNumber1 = scanner.nextInt();
                                            System.out.println("nhập số báo danh ");
                                            scanner.nextLine();
                                            int idNumber = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("nhập họ tên ");
                                            String name = scanner.nextLine();
                                            System.out.println("nhập địa chỉ ");
                                            String address = scanner.nextLine();
                                            System.out.println("nhập khối thi");
                                            String block = scanner.nextLine();
                                            mc.edit(idNumber1, new Candidate(idNumber, name, address, block));
                                        } else if (choice2 == 7) {
                                            mc.sortInId();
                                        }
                                    } while (choice2 != 8);
                                    break;

                                case 2:
                                    System.out.println("Thông tin tài khoản của bạn : ");
                                    manegeUser.displayInfor(username, pass);
                                    int choice3 = -1;
                                    do {
                                        System.out.println("1.Đổi mật khẩu : ");
                                        System.out.println("2.Quay lại : ");
                                        System.out.println("Nhập lựa chọn của bạn : ");
                                        choice3 = sc.nextInt();
                                        switch (choice3) {
                                            case 1:
                                                User user1 = new User();
                                                if (manegeUser.find(username, pass) != -1) {
                                                    user1.setName(username);
                                                    String oldPass = pass;
                                                    System.out.println("Nhập mật khẩu mới : ");
                                                    pass = sc.nextLine();
                                                    user1.setPass(pass);
                                                    manegeUser.edit(username, oldPass, user1);
                                                    System.out.println("Bạn đã thay đổi mật khẩu thành công :");
                                                }
                                                break;
                                            case 2:
                                                do {
                                                    System.out.println("Bạn muốn quay lại không y/n");
                                                    flag = sc.nextLine();
                                                } while (!flag.equals("y"));
                                                break;
                                        }
                                    } while (choice3 != 2);
                                    break;
                                case 3:
                                    do {
                                        System.out.println("Bạn muốn đăng xuất không y/n");
                                        flag = sc.nextLine();
                                    } while (!flag.equals("y"));
                                    break;
                            }

                        } while (choice1 != 3);
                    } else {
                        System.out.println("Bạn nhập sai tên đăng nhập hoặc mật khẩu ");
                    }
                    break;

                case 2:
                    do {
                        System.out.println("Chào mừng bạn đến với trang đăng kí !");
                        System.out.println("Nhập username : ");
                        username= sc.nextLine();
                        sc.nextLine();
                        System.out.println("Nhập userpass : ");
                        pass = sc.nextLine();
                        manegeUser.add(new User(username, pass));
                        do {
                            System.out.println("Bạn muốn đăng kí tiếp không y/n");
                            flag = sc.nextLine();
                        } while (!flag.equals("y") && !flag.equals("n"));
                    } while (flag.equals("y"));
                    break;
            }

        } while (choice != 0);
    }
}
