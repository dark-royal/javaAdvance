package data.models;

public class Diary {


    private  String username;
    private  String password;
    private boolean logStatus;

    public boolean isLogStatus() {
        return logStatus;
    }

    public boolean setLogStatus(boolean logStatus) {
        this.logStatus = logStatus;
        return logStatus;
    }

    public Diary() {


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

    public String getUsername() {
        return username;
    }
}
