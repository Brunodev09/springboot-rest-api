package com.example.restservice.controllers;

import com.example.restservice.services.ExcelSpreadsheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ReadExcelSpreadsheet {

    @Autowired
    ExcelSpreadsheetService spreadsheetService;

    @GetMapping("/excel")
    public String excelRoute() throws IOException {
        String file = spreadsheetService.readSpreadsheet("sheet.xlsx");
        return file != null ? file : "";
    }

}