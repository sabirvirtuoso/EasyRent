package com.easyrent.webapp.util;

import com.easyrent.webapp.persistance.entity.Rental;
import com.easyrent.webapp.persistance.entity.ResidentialRental;
import com.easyrent.webapp.persistance.entity.User;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by sabir.salman on 4/5/15.
 */
public class FileUploadHelper {

    private static final Logger log = LoggerFactory.getLogger(FileUploadHelper.class);
    private static final long MAX_FILE_UPLOAD_SIZE_IN_BYTES = (8 * 100000);

    public boolean isImageUploadSuccessful(MultipartFile image) {
        return !image.isEmpty() && isImageValidateSuccessful(image);
    }

    public boolean isImageValidateSuccessful(MultipartFile image) {
        try {
            validateImage(image);
        } catch (ImageUploadException e) {
            log.error("Image upload has been unsuccessful due to " + e.getMessage());

            return false;
        }

        return true;
    }

    public void validateImage(MultipartFile image) {
        if (!image.getContentType().equals("image/jpeg")) {
            throw new ImageUploadException("Only JPG images accepted");
        } else if (image.getSize() > MAX_FILE_UPLOAD_SIZE_IN_BYTES) {
            throw new ImageUploadException("File size exceeded maximum upload limit of 800 KB");
        }
    }

    public void saveOptionalImages(MultipartFile pictureTwo, MultipartFile pictureThree,
                                   Rental rental) throws IOException {
        if (isImageUploadSuccessful(pictureTwo)) {
            rental.setImageTwo(pictureTwo.getBytes());
        }

        if (isImageUploadSuccessful(pictureThree)) {
            rental.setImageThree(pictureThree.getBytes());
        }
    }
}
