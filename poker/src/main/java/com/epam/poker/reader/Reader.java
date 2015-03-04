package com.epam.poker.reader;

import java.io.IOException;
import java.util.List;

public interface Reader {
    
    public List<String> getStrings() throws IOException;

}
