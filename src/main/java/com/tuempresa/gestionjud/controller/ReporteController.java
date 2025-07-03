package com.tuempresa.gestionjud.controller;

import com.tuempresa.gestionjud.repository.ExpedienteRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    private final ExpedienteRepository expedienteRepository;

    public ReporteController(ExpedienteRepository expedienteRepository) {
        this.expedienteRepository = expedienteRepository;
    }

    @GetMapping("/provisiones")
    public ResponseEntity<byte[]> provisiones() throws IOException {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("Provisiones");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Expediente");
        header.createCell(1).setCellValue("Provision");

        List<Object[]> data = expedienteRepository
                .findAll()
                .stream()
                .map(e -> new Object[]{e.getId(), e.getProvisionContable()})
                .toList();
        int i = 1;
        for (Object[] d : data) {
            Row row = sheet.createRow(i++);
            row.createCell(0).setCellValue(((Long) d[0]));
            row.createCell(1).setCellValue(((BigDecimal) d[1]).doubleValue());
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        wb.write(baos);
        wb.close();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=provisiones.xlsx")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(baos.toByteArray());
    }
}
