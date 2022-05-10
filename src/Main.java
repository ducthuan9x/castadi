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
            System.out.println("                                     ");
            System.out.println("2.Đăng kí ");
            System.out.println("                                     ");
            System.out.println("0.Thoát");
            System.out.println("                                     ");
            System.out.print("Nhập lựa chon : ");
            try {
                choice = scanner.nextInt();
//      bắt ngoại lệ1
            } catch (InputMismatchException a) {
                System.err.println("nhập sai , trở lại menu");
                scanner.nextLine();
            }
            switch (choice) {
                case 1:
                    System.out.println("Mời bạn đăng nhập : ");
                    System.out.println("                                     ");
                    System.out.println("Nhập username : ");
                    String name = sc.nextLine();
                    System.out.println("Nhập userpass : ");
                    String pass = sc.nextLine();
                    if (manegeUser.find(name, pass) != -1) {
                        System.out.println("Bạn đăng nhập thành công ");
                        System.out.println("                                      ");
                        System.out.println(manegeUser.display(name, pass));
                        int choice1 = -1;
                        do {
                            System.out.println("1.Vào trang quản lý : ");
                            System.out.println("                                     ");
                            System.out.println("2.Xem thông tin tài khoản : ");
                            System.out.println("                                     ");
                            System.out.println("3.Đăng xuất : ");
                            System.out.println("                                     ");
                            System.out.print("Nhập lựa chọn của bạn : ");
                            System.out.println("                                     ");
                            try {
                                choice1 = scanner.nextInt();
//      bắt ngoại lệ1
                            } catch (InputMismatchException a) {
                                System.err.println("nhập sai , trở lại menu");
                                scanner.nextLine();
                            }
                            switch (choice1) {
                                case 1:
                                    int choice2 = -1;
                                    do {
                                        System.out.println("-----------------MENU-----------------");
                                        System.out.println("1: Thêm thí sinh dự thi");
                                        System.out.println("                                     ");
                                        System.out.println("2: Tìm kiếm theo số báo danh");
                                        System.out.println("                                     ");
                                        System.out.println("3: Đọc thí sinh trên file");
                                        System.out.println("                                     ");
                                        System.out.println("4: Phân loại thí sinh theo khối");
                                        System.out.println("                                     ");
                                        System.out.println("5: Xoá thí sinh dự thi");
                                        System.out.println("                                     ");
                                        System.out.println("6: Sửa thông tin thí sinh dự thi");
                                        System.out.println("                                     ");
                                        System.out.println("7: Sắp xếp thí sinh dự thi theo số báo danh");
                                        System.out.println("                                     ");
                                        System.out.println("8:  -------Exit-------");

                                        try {
                                            choice2 = scanner.nextInt();
//      bắt ngoại lệ1
                                        } catch (InputMismatchException a) {
                                            System.err.println("nhập sai , Nhập số đê!!!!");
                                            scanner.nextLine();
                                        }

                                        if (choice2 == 1) {
                                            System.out.println("nhập số báo danh ");
                                            scanner.nextLine();
                                            int idNumber = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("nhập họ tên ");
                                            String name1 = scanner.nextLine();
                                            System.out.println("nhập địa chỉ ");
                                            String address = scanner.nextLine();
                                            System.out.println("nhập khối thi");
                                            String block = scanner.nextLine();
                                            mc.add(new Candidate(idNumber, name1, address, block));
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
                                            String name1 = scanner.nextLine();
                                            System.out.println("nhập địa chỉ ");
                                            String address = scanner.nextLine();
                                            System.out.println("nhập khối thi");
                                            String block = scanner.nextLine();
                                            mc.edit(idNumber1, new Candidate(idNumber, name1, address, block));
                                        } else if (choice2 == 7) {
                                            mc.sortInId();
                                            mc.display();
                                        }
                                    } while (choice2 != 8);
                                    break;

                                case 2:
                                    System.out.println("Thông tin tài khoản của bạn : ");
                                    manegeUser.displayInfor(name, pass);
                                    int choice3 = -1;
                                    do {
                                        System.out.println("1.Đổi mật khẩu : ");
                                        System.out.println("                                     ");
                                        System.out.println("2.Quay lại : ");
                                        System.out.println("                                     ");
                                        System.out.println("Nhập lựa chọn của bạn : ");
                                        try {
                                            choice3 = scanner.nextInt();
//      bắt ngoại lệ1
                                        } catch (InputMismatchException a) {
                                            System.err.println("nhập sai , trở lại");
                                            scanner.nextLine();
                                        }
                                        switch (choice3) {
                                            case 1:
                                                User user1 = new User();
                                                if (manegeUser.find(name, pass) != -1) {
                                                    user1.setName(name);
                                                    String oldPass = pass;
                                                    System.out.println("Nhập mật khẩu mới : ");
                                                    sc.nextLine();
                                                    pass = sc.nextLine();
                                                    user1.setPass(pass);
                                                    manegeUser.edit(name, oldPass, user1);
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
                                    } while (choice3 != 3);
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
                        System.out.println("                                     ");
                        System.out.println("Nhập username : ");
                        sc.nextLine();
                        name= sc.nextLine();
                        System.out.println("Nhập userpass : ");
                        pass = sc.nextLine();
                        manegeUser.add(new User(name, pass));
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
