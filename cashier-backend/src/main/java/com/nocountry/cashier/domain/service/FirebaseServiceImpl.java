package com.nocountry.cashier.domain.service;

import com.nocountry.cashier.controller.dto.response.ImageResponseDTO;
import com.nocountry.cashier.domain.usecase.FirebaseService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ROMULO
 * @package com.nocountry.cashier.domain.service
 * @license Lrpa, zephyr cygnus
 * @since 11/10/2023
 */
@Service
@NoArgsConstructor
@Slf4j
public class FirebaseServiceImpl implements FirebaseService {

    private final FirebaseProperties propertiesFirebase;
    private final ImageMapper imageMapper;
    @Override
    public String getUrlImageFirebase(String bucketName, String filename) {
        return null;
    }

    @Override
    public void deleteImageFirebase(String fileName) {

    }

    @Override
    public ResponseEntity<?> generateImage(String fileImage) {
        return null;
    }

    @Override
    public ImageResponseDTO uploadImages(MultipartFile files) {
        return null;
    }

    @Override
    public String saveImageToDb(MultipartFile archivo) {
        return null;
    }
}
