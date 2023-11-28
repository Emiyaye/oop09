package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    void setString(String s);

    String getString();

    List<String> history();

    void printCurrentString();

}
