package app.model;

import org.springframework.web.multipart.MultipartFile;

public class UploadFileForm {
    private int id;
    private String name;
    private String singer;
    private String type;
    MultipartFile linkPart;

    public UploadFileForm(MultipartFile linkPart) {
        this.linkPart = linkPart;
    }

    public UploadFileForm(int id, String name, String singer, String type, MultipartFile linkPart) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.linkPart = linkPart;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UploadFileForm() {
    }

    public MultipartFile getLinkPart() {
        return linkPart;
    }

    public void setLinkPart(MultipartFile linkPart) {
        this.linkPart = linkPart;
    }
}
