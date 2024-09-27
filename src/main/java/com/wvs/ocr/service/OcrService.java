package com.wvs.ocr.service;

import lombok.AllArgsConstructor;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@AllArgsConstructor
@Service
public class OcrService {

    private final Tesseract tesseract;

    public String extractText(MultipartFile imageFile) throws IOException {

        try {
            File file = convertMultiPartToFile(imageFile);
            return tesseract.doOCR(file);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao processar OCR: " + e.getMessage());
       }
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename());
        file.transferTo(convFile);
        return convFile;
    }
}

