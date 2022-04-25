package guru.qa;

import static org.assertj.core.api.Assertions.assertThat;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JsonParseTest {
    ClassLoader classLoader =getClass().getClassLoader();
    @Test
    void parsingJsonTest() throws Exception{
        Gson gson = new Gson();
        try (InputStream is = classLoader.getResourceAsStream("json/Example.json")){
            String json = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            JsonObject jsonObject = gson.fromJson(json,JsonObject.class);
            assertThat(jsonObject.get("fruit").getAsString()).isEqualTo("Apple");
            assertThat(jsonObject.get("taste").getAsJsonObject().get("taste").getAsString()).isEqualTo("sweet");
        }
    }
}
