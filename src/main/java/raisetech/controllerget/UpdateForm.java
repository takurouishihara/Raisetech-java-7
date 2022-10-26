package raisetech.controllerget;

import org.intellij.lang.annotations.Pattern;

public class UpdateForm {


    private String name;


    @Pattern(regexp = "^[0-9]{16}$")
    private String mynumber;

    public void setName(String name, String mynumber) {
        this.name = name;
        this.mynumber = mynumber;
    }


    public String getName() {
        return name;
    }

    public String getMynumber() {
        return mynumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMynumber(String mynumber) {
        this.mynumber = mynumber;
    }

}
