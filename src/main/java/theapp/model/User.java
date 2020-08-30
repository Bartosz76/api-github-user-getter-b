package theapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("followers")
    @Expose
    private Integer followers;
    @SerializedName("public_repos")
    @Expose
    private Integer public_repos;
    private int calculations;

    public User(String login, Integer id, String avatarUrl, String type, String name, String createdAt) {
        this.login = login;
        this.id = id;
        this.avatarUrl = avatarUrl;
        this.type = type;
        this.name = name;
        this.createdAt = createdAt;
        this.calculations = 6 / 2 * (2 + 1);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getCalculations() {
        return calculations;
    }

    public void setCalculations(int calculations) {
        this.calculations = calculations;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(Integer public_repos) {
        this.public_repos = public_repos;
    }
}
