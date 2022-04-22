package guru.qa;
import static com.codeborne.xlstest.XLS.containsText;
import static org.hamcrest.MatcherAssert.assertThat;

import com.codeborne.xlstest.XLS;
import com.codeborne.xlstest.XLS.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class XlsTest {
    @Test
    public void canAssertThatXlsContainsText() throws IOException {
        XLS spreadsheet = new XLS(getClass().getClassLoader().getResource("statement.xls"));
        assertThat(spreadsheet, containsText("Statement"));
    }
}
