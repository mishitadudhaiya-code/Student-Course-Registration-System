package src.users;

public class Student extends User{
    public Student(String email, String password) {
        super(email, password);
    }

    @Override
    public void showMenu() {
        System.out.println("Student Menu");
    }
}
