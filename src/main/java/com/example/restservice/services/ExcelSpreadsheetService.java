package com.example.restservice.services;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExcelSpreadsheetService {

    private static final Logger log = LoggerFactory.getLogger(ConsumeService.class);
    private static final String documentsAbsolutePath = "complete/src/main/resources/documents/";

    public String readSpreadsheet(String path) throws IOException {
        try {
            path = documentsAbsolutePath + path;
            File f = new File(path);
            FileInputStream file = new FileInputStream(f);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            Map<Integer, List<String>> data = new HashMap<>();
            int i = 0;
            for (Row row : sheet) {
                data.put(i, new ArrayList<String>());
                for (Cell cell : row) {
                    switch (cell.getCellTypeEnum()) {
                        case STRING:
                            data.get(i).add(cell.getRichStringCellValue().getString());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                data.get(i).add(cell.getDateCellValue() + "");
                            } else {
                                data.get(i).add(cell.getNumericCellValue() + "");
                            }
                            break;
                        case BOOLEAN:
                            data.get(i).add(cell.getBooleanCellValue() + "");
                            break;
                        case FORMULA:
                            data.get(i).add(cell.getCellFormula() + "");
                            break;
                        default: data.get(i).add(" ");
                    }
                }
                i++;
            }
            List<String> stringifiedSheet = new ArrayList<String>();
            data.forEach((key, value) -> {
                value.forEach(str -> stringifiedSheet.add(str));
            });
            return String.join("\n", stringifiedSheet);
        } catch (IOException e) {
            log.error(e.toString());
            return null;
        }
    }
}
