package com.sandbox.console.office;

import com.aspose.cells.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Excel2Pdf {
    private static boolean getLicense() {
        boolean result = false;
        try {
            InputStream is = Excel2Pdf.class.getClassLoader().getResourceAsStream("xlsxlicense.xml");
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void excel2pdf(String input, String output) {
        if (!getLicense()) {
            return;
        }
        try {
            File pdfFile = new File(output);
            Workbook wb = new Workbook(input);
            FileOutputStream fileOS = new FileOutputStream(pdfFile);
            PdfSaveOptions saveOptions = new PdfSaveOptions();
            saveOptions.setAllColumnsInOnePagePerSheet(true);
            wb.save(fileOS, saveOptions);
            fileOS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
