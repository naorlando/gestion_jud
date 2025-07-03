package com.tuempresa.gestionjud.service;

import com.tuempresa.gestionjud.repository.ExpedienteRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;


@Service
public class ReporteServiceImpl implements ReporteService {

    private final ExpedienteRepository expedienteRepository;

    public ReporteServiceImpl(ExpedienteRepository expedienteRepository) {
        this.expedienteRepository = expedienteRepository;
    }

    @Override
    public ByteArrayInputStream reporteProvisiones() {
        try (Workbook wb = new XSSFWorkbook(); ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Sheet sheet = wb.createSheet("Provisiones");
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Expediente");
            header.createCell(1).setCellValue("Provision");
          
            int i = 1;
            for (var e : expedienteRepository.findAll()) {
                Row row = sheet.createRow(i++);
                row.createCell(0).setCellValue(e.getId());
                if (e.getProvisionContable() != null) {
                    row.createCell(1).setCellValue(e.getProvisionContable().doubleValue());
                }
            }
            wb.write(baos);
            return new ByteArrayInputStream(baos.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
