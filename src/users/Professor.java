package users;

public class Professor extends User {

    public Professor(String email, String password) {
        super(email, password);
    }

    @Override
    public void showMenu() {
        System.out.println("Professor Menu");
    }
}