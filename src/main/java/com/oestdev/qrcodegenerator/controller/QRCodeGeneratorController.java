package com.oestdev.qrcodegenerator.controller;

import com.oestdev.qrcodegenerator.dto.qrcode.QRCodeRequest;
import com.oestdev.qrcodegenerator.dto.qrcode.QRCodeResponse;
import com.oestdev.qrcodegenerator.service.QRCodeGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qrcode")
public class QRCodeGeneratorController {

    private final QRCodeGeneratorService service;

    public QRCodeGeneratorController(QRCodeGeneratorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<QRCodeResponse> generateQRCode(@RequestBody QRCodeRequest request) {
        try {
            return ResponseEntity.ok(service.generateQRCode(request.text()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
