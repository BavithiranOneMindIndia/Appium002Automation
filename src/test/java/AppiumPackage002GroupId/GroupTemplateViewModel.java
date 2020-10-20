package AppiumPackage002GroupId;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GroupTemplateViewModel {

    @JsonProperty("id")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;


    List<Integer> templates;
    @JsonProperty("templates") 
    public List<Integer> getTemplates() { 
		 return this.templates; }

    public void setTemplates(List<Integer> templates) { 
		 this.templates = templates; } 
   

}
