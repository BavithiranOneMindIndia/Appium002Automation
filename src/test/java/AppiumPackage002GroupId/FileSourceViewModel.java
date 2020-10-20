package AppiumPackage002GroupId;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileSourceViewModel {
    @JsonProperty("id")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;

    @JsonProperty("fileName")
    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    String fileName;

    @JsonProperty("blobUrl")
    public String getBlobUrl() {
        return this.blobUrl;
    }

    public void setBlobUrl(String blobUrl) {
        this.blobUrl = blobUrl;
    }

    String blobUrl;

    @JsonProperty("mimeType")
    public String getMimeType() {
        return this.mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    String mimeType;

    @JsonProperty("fileType")
    public int getFileType() {
        return this.fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    int fileType;
}
