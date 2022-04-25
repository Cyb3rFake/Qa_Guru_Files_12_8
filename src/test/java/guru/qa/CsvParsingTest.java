package guru.qa;

import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CsvParsingTest {
    @Test
    void parseCsvTest() throws Exception{
        //вызов класс-лоадера
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream is = classLoader.getResourceAsStream("csv/CSV.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(is))){
            List<String[]>content = reader.readAll();
            assertThat(content.get(0)).contains(
                    "Series_reference",
                    "Period", "Data_value",
                    "Suppressed",
                    "STATUS",
                    "UNITS",
                    "Magnitude",
                    "Subject",
                    "Group",
                    "Series_title_1",
                    "Series_title_2",
                    "Series_title_3",
                    "Series_title_4",
                    "Series_title_5");
        }



    }
}