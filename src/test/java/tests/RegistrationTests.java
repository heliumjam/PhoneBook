package tests;

import manager.HelperUser;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
            app.getUser().pause(2000);
        }
    }

    @Test
    public void registrationPositive() {
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        String email = "domes"+ i +"@mail.com", password = "123456Aa$";

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitRegistration();
        app.getUser().pause(2000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));

    }

    @Test
    public void registrationNegativeWrongEmail(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        String email = "domes"+ i +"mail.com", password = "123456Aa$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitRegistration();
        app.getUser().pause(2000);
        app.getUser().asseptAlertOk();

    }
@Test
    public void registrationNegativeWrongPassword(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        String email = "domes"+ i +"@mail.com", password = "123Aa$";

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitRegistration();
        app.getUser().pause(2000);
        app.getUser().asseptAlertOk();

    }
    @Test
    public void registrationNegativeUserExits() {
        String email = "domes7@mail.com", password = "123456Aa$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitRegistration();
        app.getUser().pause(2000);
        app.getUser().asseptAlertOk();
    }

    @AfterMethod
        public void postcondition() {
        app.getUser().pause(2000);
    }

}