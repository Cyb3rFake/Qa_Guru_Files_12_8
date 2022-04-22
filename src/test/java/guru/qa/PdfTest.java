package guru.qa;
import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
public class PdfTest {
    @Test
    public void canAssertThatPdfContainsText() throws IOException {
        PDF pdf = new PDF(new File("src/test/resources/50quickideas.pdf"));
        assertThat(pdf).containsExactText("50 Quick Ideas to Improve your User Stories");
    }
}
