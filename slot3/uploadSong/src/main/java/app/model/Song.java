package app.model;

import org.springframework.web.multipart.MultipartFile;

public class Song {
    private int id;
    private String name;
    private String singer;
    private String songType;
    private MultipartFile link;
    private String srcLink;

    public Song() {
    }

    public Song(int id, String name, String singer, String songType, MultipartFile link, String srcLink) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.songType = songType;
        this.link = link;
        this.srcLink = srcLink;
    }

    public String getSrcLink() {
        return srcLink;
    }

    public void setSrcLink(String srcLink) {
        this.srcLink = srcLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType;
    }

    public MultipartFile getLink() {
        return link;
    }

    public void setLink(MultipartFile link) {
        this.link = link;
    }
}
