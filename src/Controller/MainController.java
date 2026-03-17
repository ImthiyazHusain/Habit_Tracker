package Controller;

import View.UserView;

public class MainController {
    UserController userController = new UserController();
    UserView userView = new UserView();
    public void start() {
        createDummyRecord();
        loginReg();
        userController.displayUsers();
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
        String pass = userView.getPass();
        userController.createUser(name,email,pass);
        userView.newUserAdded();
        authenticateLogin();
    }

    private void authenticateLogin() {
        userView.Login();
        String name = userView.getName();
        String pass = userView.getPass();
        if(userController.verifyUser(name,pass)){
            userView.welcomeUser(name);
        }else{
            userView.invalid();
        }
    }

    private void createDummyRecord() {
        userController.createUser("Husain","husain@gmail.com","Husain123");
        userController.createUser("Barath","barath@gmail.com");
        userController.createUser("Adhithya","adhi@gmail.com","Adhi123");
        userController.createUser("Deepak","deepak@gmail.com");
        userController.createUser("Kavin","kavin@gmail.com","Kavin123");
    }
}
