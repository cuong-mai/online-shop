package net.cuongmai.onlineshop.util;

import javafx.scene.shape.Path;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class FileUploadUtility {

    public static void uploadFile(HttpServletRequest request, MultipartFile file,
                                  String targetPathWithoutEndSeparator, String targetFilenameWithExtension) {

        String developmentPath =
                "E:/Google Drive/Projects/online-shop/online-shop/src/main/webapp/" + targetPathWithoutEndSeparator + "/";

        String serverAppPath = request.getSession().getServletContext().getRealPath(targetPathWithoutEndSeparator) + "/";
        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());

        File fileTemp = new File(developmentPath);
        if (!fileTemp.exists()) {
            fileTemp.mkdirs();
        }

        fileTemp = new File(serverAppPath);
        if (!fileTemp.exists()) {
            fileTemp.mkdirs();
        }

        try {
            file.transferTo(new File(developmentPath + targetFilenameWithExtension));
            file.transferTo(new File(serverAppPath + targetFilenameWithExtension));

        } catch (IOException ex) {
            ex.printStackTrace();

        }

    }
}
