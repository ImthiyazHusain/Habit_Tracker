package Controller;

import Model.User;
import View.UserView;

public class MainController {
    UserController userController = new UserController();
    UserView userView = new UserView();
    public void start() {
        createDummyRecord();
        loginReg();
    }

    private void loginReg() {
        int choice = 0;
        while(choice!=3) {
            choice = userView.displayLoginReg();
            switch (choice) {
                case 1: {
                    authenticateLogin();
                    break;
                }
                case 2: {
                    addNewUser();
                    break;
                }
                case 3: {
                    userView.exit();
                    break;
                }
                default: {
                    userView.invalid();
                }
            }
        }
    }

    private void addNewUser() {
        userView.register();
        String name = userView.getName();
        String email = userView.getEmail();
        if (userController.getUser(email) != null) {
            userView.invalid();
            return;
        }
        String pass = userView.getPass();
        userController.createUser(name, email, pass);
        userView.newUserAdded();

        User user = userController.getUser(email);
        userView.welcomeUser(user.getName());
        userController.login(user);
    }

    private void authenticateLogin() {
        userView.login();

        while (true) {
            String email = userView.getEmail();
            String pass = userView.getPass();

            if (userController.verifyUser(email, pass)) {
                User user = userController.getUser(email);
                userView.welcomeUser(user.getName());
                userController.login(user);
                return;
            } else {
                userView.invalid();
            }
        }
    }

    private void createDummyRecord() {
        userController.createUser("Husain","husain@gmail.com","Husain123");
        userController.createUser("Barath","barath@gmail.com","123");
        userController.createUser("Adhithya","adhi@gmail.com","Adhi123");
        userController.createUser("Deepak","deepak@gmail.com","123");
        userController.createUser("Kavin","kavin@gmail.com","Kavin123");
    }
}
