package com.wvs.ocr.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.File;
import java.util.Optional;

@Configuration
@AllArgsConstructor
@Slf4j
public class TesseractConfig {


    private final Environment environment;

    @Bean
    public Tesseract tesseract() {
        Tesseract tesseract = new Tesseract();

        String tessDataPath = Optional.ofNullable(System.getenv("TESSDATA_PREFIX"))
                .orElse(environment.getProperty("tesseract.datapath"));

        log.info("Configurando o caminho para tessdata: {}", tessDataPath);

        Optional.ofNullable(tessDataPath)
                .ifPresentOrElse(
                        tesseract::setDatapath,
                        () -> { throw new IllegalStateException("O caminho para tessdata não foi configurado!"); }
                );

        tesseract.setLanguage("por");

        return tesseract;
    }

}
