package pl.jojczykp.crypto.lambda;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.function.aws.runtime.AbstractMicronautLambdaRuntime;
import io.micronaut.logging.LogLevel;
import pl.jojczykp.crypto.io.Input;
import pl.jojczykp.crypto.io.Output;

import java.net.MalformedURLException;

public class LambdaRuntime extends AbstractMicronautLambdaRuntime<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent, Input, Output> {

    public static void main(String[] args) {
        try {
            new LambdaRuntime().run(args);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected LogLevel getLogLevel() {
        String logLevelStr = System.getenv("LOG_LEVEL");
        return  logLevelStr == null ? LogLevel.INFO : LogLevel.valueOf(logLevelStr);
    }

    @Override
    @Nullable
    protected RequestHandler createRequestHandler(String... args) {
        return new RequestHandler();
    }
}
