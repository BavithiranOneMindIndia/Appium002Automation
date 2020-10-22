package AppiumPackage002GroupId;

import java.util.List;

import javax.print.DocFlavor.STRING;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TemplateViewModel {

    @JsonProperty("id")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    @JsonProperty("text")
    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    String text;

    @JsonProperty("templateName")
    public Object getTemplateName() {
        return this.templateName;
    }

    public void setTemplateName(Object templateName) {
        this.templateName = templateName;
    }

    Object templateName;

    @JsonProperty("messageType")
    public int getMessageType() {
        return this.messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    int messageType;

    @JsonProperty("clusterId")
    public int getclusterId() {
        return this.messageType;
    }

    public void setclusterId(String clusterId) {
        this.clusterId = clusterId;
    }

    String clusterId;

    @JsonProperty("fileSourceViewModels")
    public List<FileSourceViewModel> getFileSourceViewModels() {
        return this.fileSourceViewModels;
    }

    public void setFileSourceViewModels(List<FileSourceViewModel> fileSourceViewModels) {
        this.fileSourceViewModels = fileSourceViewModels;
    }

    List<FileSourceViewModel> fileSourceViewModels;

}
