package vfs.com.androidtableviews;

/**
 * Created by Jaxonstevens on 8/9/17.
 */

public class Repository {


    private String  lastUpdated;
    private String  name;
    private String  avatarLink;
    private String  commentsLink;

    public Repository(String lastUpdated, String commentsLink, String avatarLink, String name) {
        this.lastUpdated = lastUpdated;
        this.commentsLink = commentsLink;
        this.avatarLink = avatarLink;
        this.name = name;


    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public String getName() {
        return name;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public String getCommentsLink() {
        return commentsLink;
    }
}

