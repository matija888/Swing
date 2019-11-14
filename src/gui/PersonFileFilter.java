package gui;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class PersonFileFilter extends FileFilter {

    @Override
    public boolean accept(File file) {
        String name = file.getName();
        String extension = Utils.getFileExtension(name);

        if (extension == null) {
            return false;
        }

        if(extension.equals("per")) {
            return true;
        }

        return true;
    }

    @Override
    public String getDescription() {
        return "Person database files (*.per)";
    }
}
