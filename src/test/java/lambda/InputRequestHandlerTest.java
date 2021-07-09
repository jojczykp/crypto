package lambda;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.jojczykp.crypto.io.Input;
import pl.jojczykp.crypto.io.Output;
import pl.jojczykp.crypto.lambda.RequestHandler;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InputRequestHandlerTest {

    private static RequestHandler requestHandler;

    @BeforeAll
    public static void setupServer() {
//        requestHandler = new RequestHandler();
    }

    @AfterAll
    public static void stopServer() {
        if (requestHandler != null) {
            requestHandler.getApplicationContext().close();
        }
    }

    @Test
    public void testHandler() {
        Input input = new Input();
        input.setData("Building Microservices");
        Output output = requestHandler.execute(input);
//        assertEquals(output.getName(), input.getName());
//        assertNotNull(output.getIsbn());
    }
}
