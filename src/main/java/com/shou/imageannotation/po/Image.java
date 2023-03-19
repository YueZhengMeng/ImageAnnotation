package com.shou.imageannotation.po;

public class Image {
    private int imageID;
    private int uploaderID;
    private String description;
    private String path;
    private String uploadDate;
    private int status;

    public Image() {
    }

    public Image(int imageID, int uploaderID, String description, String path, String uploadDate, int status) {
        this.imageID = imageID;
        this.uploaderID = uploaderID;
        this.description = description;
        this.path = path;
        this.uploadDate = uploadDate;
        this.status = status;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public int getUploaderID() {
        return uploaderID;
    }

    public void setUploaderID(int uploaderID) {
        this.uploaderID = uploaderID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
