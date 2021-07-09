package pl.jojczykp.crypto.lambda;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;
import lombok.extern.slf4j.Slf4j;
import pl.jojczykp.crypto.io.Action;
import pl.jojczykp.crypto.io.Input;
import pl.jojczykp.crypto.io.Output;
import pl.jojczykp.crypto.services.DecryptService;
import pl.jojczykp.crypto.services.EncryptService;

import javax.inject.Inject;

@Slf4j
@Introspected
public class RequestHandler extends MicronautRequestHandler<Input, Output> {

    @Inject
    private EncryptService encryptService;

    @Inject
    private DecryptService decryptService;

    @Override
    public Output execute(Input input) {
        log.debug("Input: {}", input);

        String outcome;

        if (input.getAction() == Action.ENCRYPT) {
            outcome = encryptService.encrypt(input.getData());
        } else {
            outcome = decryptService.decrypt(input.getData());
        }

        Output output = new Output();
        output.setData(outcome);

        return output;
    }
}
