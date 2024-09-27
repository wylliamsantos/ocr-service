package com.wvs.ocr.controller;

import com.wvs.ocr.service.OcrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class OcrController {

    @Autowired
    private OcrService ocrService;

    @PostMapping("/ocr")
    public ResponseEntity<String> performOcr(@RequestParam("image") MultipartFile imageFile) throws IOException {
        return ResponseEntity.ok(this.ocrService.extractText(imageFile));
    }

}