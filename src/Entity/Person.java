package Entity;

public class Person {

    protected int userId;
    protected String name;
    protected String userName;
    protected String email;
    protected String password;
    protected String role;

    public Person(int userId, String name, String userName, String email, String password, String role) {
        this.userId = userId;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

}
