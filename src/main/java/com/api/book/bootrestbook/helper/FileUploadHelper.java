package com.api.book.bootrestbook.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    public final String UPLOAD_DIR = "D:\\myWebsite\\Java\\springbootprojects\\bootrestbook\\src\\main\\resources\\static\\image";

    public boolean uploadFile(MultipartFile file) {
        boolean isFile = false;

        try {
            // InputStream is = file.getInputStream();
            // byte data[] = new byte[is.available()];

            // is.read(data);

            // // write
            // FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + File.separator +
            // file.getOriginalFilename());

            // fos.write(data);
            // fos.flush();
            // fos.close();
            // isFile = true;

            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);

            isFile = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isFile;
    }
}
