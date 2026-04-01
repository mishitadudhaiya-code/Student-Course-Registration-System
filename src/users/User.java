package src.users;

public class User {
    
    protected String email;
    protected String password;
    
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public abstract void showMenu();
}


