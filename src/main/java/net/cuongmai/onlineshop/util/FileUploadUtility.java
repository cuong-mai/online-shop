package net.cuongmai.onlineshop.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class FileUploadUtility {

    public static void uploadFile(HttpServletRequest request, MultipartFile file, String subDirectoryName, String fileName) {

        String developmentPath =
                "E:/Google Drive/Projects/online-shop/online-shop/src/main/webapp/resources/images/products/"
                        + subDirectoryName + "/";

        String serverAppPath = request.getSession().getServletContext().getRealPath("/resources/images/products/")
                + subDirectoryName + "/";

        System.out.println(developmentPath);
        System.out.println(serverAppPath);

        File fileTemp = new File(developmentPath);
        if (!fileTemp.exists()) {
            fileTemp.mkdirs();
        }

        fileTemp = new File(serverAppPath);
        if (!fileTemp.exists()) {
            fileTemp.mkdirs();
        }

        try {
            file.transferTo(new File(developmentPath + fileName + ".jpg"));
            file.transferTo(new File(serverAppPath + fileName + ".jpg"));

        } catch (IOException ex) {
            ex.printStackTrace();

        }

    }
}
