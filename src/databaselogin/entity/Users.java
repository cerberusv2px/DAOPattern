package databaselogin.entity;


public class Users {
    private int id;
    private String username;
    private String password;
    private Account account;

    public Users() {
    }

    public Users(int id, String username, String password, Account account) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
    
}
