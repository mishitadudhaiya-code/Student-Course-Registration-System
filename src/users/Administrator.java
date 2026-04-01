package src.users;

public class Administrator extends User {
    public Administrator(String email, String password) {
        super(email, password);
    }

    @Override
    public void showMenu() {
        System.out.println("Admin Menu");
    }
}
