package file;

import java.io.File;

public class FileHelper {

    public static String getFilePath(String fileName){
        File file = new File((FileHelper.class.getResource(fileName)).getFile());
        return file.getAbsolutePath();
    }
}
