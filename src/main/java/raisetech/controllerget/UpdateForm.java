package raisetech.controllerget;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UpdateForm {

    @NotBlank
    @Pattern(regexp = "^[0-9]{16}$")
    private String myNumber;

    public String getMyNumber() {
        return myNumber;
    }

    public void setMyNumber(String myNumber) {
        this.myNumber = myNumber;
    }
}
