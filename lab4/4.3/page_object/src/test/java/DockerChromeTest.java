import static io.github.bonigarcia.seljup.BrowserType.CHROME;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import POMs.CitySelectionPage;
import POMs.PurchasePage;
import POMs.ReservePage;
import io.github.bonigarcia.seljup.DockerBrowser;
import io.github.bonigarcia.seljup.SeleniumJupiter;

@ExtendWith(SeleniumJupiter.class)
class DockerChromeTest {

    @Test
    public void test_chrome(@DockerBrowser(type = CHROME) WebDriver driver) {
        CitySelectionPage citySelectionPage = new CitySelectionPage(driver);
        ReservePage reservePage = citySelectionPage.with("Boston", "New York");
        assertThat(citySelectionPage.success());
        PurchasePage purchasePage = reservePage.chooseFlight();
        assertThat(reservePage.success());
        purchasePage.with("John Doe", "123 Main St", "Boston", "MA", "12345", "Visa", "1234567890", "12", "2023",
                "John Doe");
        assertThat(purchasePage.success());
    }

}