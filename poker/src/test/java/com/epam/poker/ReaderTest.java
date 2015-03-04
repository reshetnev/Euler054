package com.epam.poker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.epam.poker.reader.Reader;
import com.epam.poker.reader.impl.FileTxtReader;

public class ReaderTest {
    
    @Test(expected = IOException.class)
    public void getStringsExceptionTest() throws IOException {
        Reader reader = new FileTxtReader("test.txt");
        reader.getStrings();
    }
    
    @Test
    public void getStringsTest() throws IOException {
        Reader reader = new FileTxtReader("poker.txt");
        List<String> strList = new ArrayList<String>();
        strList = reader.getStrings();
        Assert.assertEquals(new Integer(1000), new Integer(strList.size()));
    }

}
