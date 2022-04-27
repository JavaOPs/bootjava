package ru.javaops.bootjava.to;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.javaops.bootjava.util.validation.NoHtml;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = true)
public class NamedTo extends BaseTo {
    @NotBlank
    @Size(min = 2, max = 128)
    @NoHtml
    protected String name;

    public NamedTo(Integer id, String name) {
        super(id);
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + '[' + name + ']';
    }
}
