package Utilities;

import PageObjects.PageObjectManager;

import java.io.IOException;

public class TextContext {
    public Baseclass baseclass;
    public PageObjectManager pageObjectManager;

    public TextContext() throws IOException {
        baseclass=new Baseclass();
        baseclass.initializeDriver();
        pageObjectManager=new PageObjectManager(baseclass.driver);
    }
}
