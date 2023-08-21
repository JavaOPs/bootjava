package ru.javaops.bootjava.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.javaops.bootjava.util.validation.NoHtml;

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
