package ManegeCandidate;

import Normal.User;

import java.util.ArrayList;
import java.util.List;

public class ManegeUser {
    List<User>userList=new ArrayList<>();

    public ManegeUser() {
    }

    public ManegeUser(List<User> userList) {
        this.userList = userList;
    }
    public void add(User user) {
        userList.add(user);
        System.out.println("Bạn đã đăng kí thành công ");
    }

    public int find(String username,int pass) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getName()) && (userList.get(i).getPass()==pass)) {
                return i;
            }
        }
        return -1;
    }
    public String display(String username,int pass){
        String str = "username : ";
        for (User user : userList) {
            if (username.equals(user.getName())&&(user.getPass()==pass))
                str += user.getName();
        }
        return str;
    }
    public void displayInfor(String username,int pass){
        for (User user : userList) {
            if (username.equals(user.getName())&&(user.getPass()==pass))
                System.out.println(user);;
        }
    }
    public void edit(String name,int pass, User user) {
        int index = find(name, pass);
        userList.set(index, user);
    }

}
