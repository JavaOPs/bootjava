package ru.javaops.bootjava.to;

import lombok.EqualsAndHashCode;
import lombok.Value;
import ru.javaops.bootjava.HasIdAndEmail;
import ru.javaops.bootjava.util.validation.NoHtml;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Value
@EqualsAndHashCode(callSuper = true)
public class UserTo extends NamedTo implements HasIdAndEmail {
    @Email
    @NotBlank
    @Size(max = 128)
    @NoHtml  // https://stackoverflow.com/questions/17480809
    String email;

    @NotBlank
    @Size(min = 5, max = 32)
    String password;

    public UserTo(Integer id, String name, String email, String password) {
        super(id, name);
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserTo:" + id + '[' + email + ']';
    }
}
