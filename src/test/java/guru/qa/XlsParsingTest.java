package guru.qa;

import com.codeborne.selenide.Selenide;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static org.assertj.core.api.Assertions.assertThat;

public class XlsParsingTest {
    @Test
    void parseXlsTest() throws Exception{
        Selenide.open("http://romashka2008.ru/price");
        File xlsDownload = Selenide.$(".site-main__inner a[href*='prajs_ot']").download();
        XLS xls = new XLS(xlsDownload);

        assertThat(xls.excel
                .getSheetAt(0)
                .getRow(11)
                .getCell(1)
                .getStringCellValue().contains("Сахалинская обл, Южно-Сахалинск"));

    }
}