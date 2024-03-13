import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.firefox.FirefoxDriver;

import POMs.CitySelectionPage;
import POMs.PurchasePage;
import POMs.ReservePage;
import io.github.bonigarcia.seljup.SeleniumJupiter;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SeleniumJupiter.class)
public class BasicPOMTest {

    CitySelectionPage citySelectionPage;
    PurchasePage purchasePage;
    ReservePage reservePage;

    @Test
    public void test(FirefoxDriver driver) {
        citySelectionPage = new CitySelectionPage(driver);
        reservePage = citySelectionPage.with("Boston", "New York");
        assertThat(citySelectionPage.success());
        purchasePage = reservePage.chooseFlight();
        assertThat(reservePage.success());
        purchasePage.with("John Doe", "123 Main St", "Boston", "MA", "12345", "Visa", "1234567890", "12", "2023",
                "John Doe");
        assertThat(purchasePage.success());
    }



}