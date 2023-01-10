package com.bigdataca.electronicsignatureservice.controller;

import com.bigdataca.electronicsignatureservice.service.SignatureService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@RequestMapping(path = "/api/pdf")
public class SignatureController {

    private final SignatureService signatureService;

    @Autowired
    public SignatureController(SignatureService signatureService) {
        this.signatureService = signatureService;
    }

    @PostMapping(value = "/export", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void signPDF(@ApiParam(name = "pdfFile", type = "file", required = true) @RequestPart(required = true, name = "pdfFile") MultipartFile pdfFile,
                        @ApiParam(name = "p12File", type = "file", required = true) @RequestPart(required = true, name = "p12File") MultipartFile p12File,
                        @RequestParam("password") String password) throws GeneralSecurityException, IOException {

//        ObjectMapper map = new ObjectMapper();
//        String pass = map.readValue(password, String.class);
        signatureService.signerService(pdfFile.getBytes(), p12File.getBytes(), password);

    }
}
