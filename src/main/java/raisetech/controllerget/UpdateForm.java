package raisetech.controllerget;

import org.intellij.lang.annotations.Pattern;

public class UpdateForm {

    private String name;

    @Pattern(regexp = "^[0-9]{16}$")
    private String myNumber;
    public UpdateForm(String name, String myNumber) {
        this.name = name;
        this.myNumber = myNumber;
    }

}
