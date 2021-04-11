package helpers;

public class MappingsHelper {

    public static String dropdownFieldsXpathHelper(String nameOfLanguage){
        return String.format("//*[text()='%s']//parent::*//parent::*//parent::div//input[@data-ref='inputEl']", nameOfLanguage);
    }

    public static String getProjectInTable(String projectName){
        return String.format("//table[@class = 'x-grid-item']//span[text() = '%s']", projectName);
    }
}
