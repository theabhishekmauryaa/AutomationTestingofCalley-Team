package tests;

import org.testng.annotations.Test;

import pages.AddListPage;
import utils.Base;

public class AddNewListTest extends Base {

    @Test
    public void AddNewListTests() throws Exception {
        loginpageValidCrendails(); // Assuming login method is in BaseTest

        AddListPage addListPage = new AddListPage(driver);

        addListPage.closeCalleyModalIfPresent();
        addListPage.dismissSubscribePopupIfPresent();
        addListPage.clickAddNewList();
        addListPage.enterListName("getCally");
        addListPage.uploadCSV("D:\\masai\\Evaluate-Prograne\\Project\\CalleyAutomation\\src\\test\\resources\\demo.csv");
        addListPage.clickUploadButtonAndAcceptConfirmation();
        addListPage.selectDropdownValues();
        addListPage.clickFinalSubmitAndAcceptConfirmation();
        addListPage.finalOkbuttomclick();
    }
}
