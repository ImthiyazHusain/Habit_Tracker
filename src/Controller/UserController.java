package Controller;
import Model.*;
import View.UserView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserController {
    UserView userView = new UserView();
    HabitController habit = new HabitController();
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
        userView.displayUsers(users);
    }

    public boolean verifyUser(String name, String pass) {
        if(userMap.containsKey(name)){
            User u = userMap.get(name);
            return pass.equals(u.getPassword());
        }
        return false;
    }

    public void login(User user) {
        int choice = 0;
        while(choice<4){
            choice = userView.displayMenu();
            switch(choice){
                case 1 : {
                    addNewHabit(user);
                    break;
                }
                case 2 : {
                    editHabit(user);
                    break;
                }
                case 3 : {
                    viewHabits(user);
                    break;
                }
                case 4 : {
                    userView.exit();
                    break;
                }
                default:{
                    userView.invalid();
                }
            }
        }
    }

    private void viewHabits(User user) {
        List<Habit> habits = user.getHabits();
        userView.displayHabits(habits);
    }

    private void editHabit(User user) {
    }

    private void addNewHabit(User user) {
        int newHabitId = user.getHabit().size()+1;
        String habitType = userView.getHabitType();
        String habitName = userView.getHabit();
        String habitDescription = userView.getHabitDescription();
        int goalDays = userView.getGoalDays();
        Habit habit = new Habit(newHabitId,habitType,habitName,habitDescription,0,goalDays);
        user.addHabit(habit);
    }

    public User getUser(String name) {
        return userMap.get(name);
    }
}
