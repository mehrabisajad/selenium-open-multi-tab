public class TabData {

    private String url;
    private String username;
    private String password;

    public TabData(String url) {
        this.url = url;
    }
    public TabData(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public TabData setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public TabData setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public TabData setPassword(String password) {
        this.password = password;
        return this;
    }
}
