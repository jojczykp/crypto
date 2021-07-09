package pl.jojczykp.crypto.io;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Introspected
public class Output {
    @NonNull
    @NotBlank
    private String data;
}
