package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {

    private List<String> string = new ArrayList<>();
    private int size;
    
    @Override
    public void setString(String string) {
        this.string.add(size, string);
        size++;
    }

    @Override
    public String getString() {
        return new String(string.get(size));
    }

    @Override
    public List<String> history() {
        return new ArrayList<>(string);
    }

    @Override
    public void printCurrentString() {
        if (size == 0) {
            throw new IllegalStateException("Ugabuga");
        }
        System.out.println(string.get(size));
    }
    
}