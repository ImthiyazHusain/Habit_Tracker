package Controller;
import Model.*;
import View.UserView;
import View.UserView.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserController {
    private static Map<String,User> userMap = new HashMap<>();
    private static List<User> users = new ArrayList<>();
    public void createUser(String name,String email,String password){
        int newId = users.isEmpty()?1:users.getLast().getId()+1;
        User newUser = new User(newId,name,email,password);
        users.add(newUser);
        userMap.put(name,newUser);
    }
    public void createUser(String name,String email){
        int newId = users.isEmpty()?1:users.getLast().getId()+1;
        User newUser = new User(newId,name,email,"12345");
        users.add(newUser);
        userMap.put(name,newUser);
    }

    public void displayUsers(){
        UserView u = new UserView();
        u.displayUsers(users);
    }

    public boolean verifyUser(String name, String pass) {
        if(userMap.containsKey(name)){
            User u = userMap.get(name);
            return pass.equals(u.getPassword());
        }
        return false;
    }
}
