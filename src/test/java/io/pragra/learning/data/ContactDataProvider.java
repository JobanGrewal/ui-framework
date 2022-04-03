package io.pragra.learning.data;

import org.testng.annotations.DataProvider;

import java.util.Iterator;

public class ContactDataProvider {

    @DataProvider(name = "contact")
    public Iterator<Object[]> getContactData() {
        return ExcelReader.getDataFromSheet("Student",false).iterator();
    }
}
