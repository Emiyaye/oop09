package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String HOME = System.getProperty("user.home");
    private static final String SLASH = System.getProperty("file.separator");
    private static final String PATH = HOME + SLASH + "output.txt";
    private File file = new File(PATH);

    public void setFile(final File file) {
        if (file.getParentFile().exists()){
            this.file = file;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public void setFile( final String file) {
        setFile(new File(file));
    }

    public File getFile() {
        return file;
    }

    public String getFilePath() {
        return file.getAbsolutePath();
    }

    public boolean save(final String string) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(string);
            return true;
        } catch (final IOException e) {
            e.printStackTrace();    
        }
        return false;
    }
}
