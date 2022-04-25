package guru.qa;

import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;
public class ZipParsingTest {
    ClassLoader classLoader = getClass().getClassLoader();
    @Test
    void prasingZipTest() throws Exception{
        try (InputStream is = classLoader.getResourceAsStream("zip/zip.zip");
             ZipInputStream zis = new ZipInputStream(is)){
            ZipEntry entry;
            while ((entry = zis.getNextEntry())!= null){
                assertThat(entry.getName()).isEqualTo("Machine_readable_file_bdc_sf_2021_q4.csv");
            }
        }

    }

}
