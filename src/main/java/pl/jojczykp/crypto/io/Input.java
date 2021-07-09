package pl.jojczykp.crypto.io;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@Introspected
public class Input {
    @NonNull
    @NotBlank
    private Action action;

    @NonNull
    @NotBlank
    private String data;
}
