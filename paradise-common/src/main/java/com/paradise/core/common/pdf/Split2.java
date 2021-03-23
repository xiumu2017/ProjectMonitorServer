package com.paradise.core.common.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Split2 {
    public static void main(String[] args) {
        String file = "E:\\1.pdf";
        splitFile(file, 1, 24, "1-计算机系统知识");
        splitFile(file, 25, 34, "2-程序设计语言基础");
        splitFile(file, 35, 51, "3-数据结构");
        splitFile(file, 52, 59, "4-操作系统知识");
        splitFile(file, 60, 85, "5-软件工程基础知识");
        splitFile(file, 86, 94, "6-结构化开发方法");
        splitFile(file, 95, 112, "7-面向对象技术");
        splitFile(file, 113, 119, "8-算法设计与分析");
        splitFile(file, 120, 132, "9-数据库技术基础");
        splitFile(file, 133, 148, "10-网络与信息安全基础知识");
        splitFile(file, 149, 157, "11-标准化和软件知识产权基础知识");
        splitFile(file, 158, 167, "12-软件系统分析与设计");
        splitFile(file, 168, 180, "13-新技术");
        splitFile(file, 181, 186, "14-专业英语");
        splitFile(file, 187, 232, "2015.11考试真题");
        splitFile(file, 233, 271, "2016.5考试真题");
        splitFile(file, 272, 309, "2016.11考试真题");
        splitFile(file, 310, 350, "2017.05考试真题");
        splitFile(file, 351, 394, "2017.11考试真题");
        splitFile(file, 395, 436, "2018.05考试真题");
    }

    public static String splitFile(String pdfFile, Integer from, Integer end, String targetName) {
        Document document;
        PdfCopy copy;
        try {
            PdfReader reader = new PdfReader(pdfFile);
            int n = reader.getNumberOfPages();
            if (end == 0) {
                end = n;
            }
            List<String> savePaths = new ArrayList<>();
            int a = pdfFile.lastIndexOf("1.pdf");
            String staticPath = pdfFile.substring(0, a);
            String savePath = staticPath + targetName + ".pdf";
            savePaths.add(savePath);
            document = new Document(reader.getPageSize(1));
            copy = new PdfCopy(document, new FileOutputStream(savePaths.get(0)));
            document.open();
            for (int j = from; j <= end; j++) {
                document.newPage();
                PdfImportedPage page = copy.getImportedPage(reader, j);
                copy.addPage(page);
            }
            document.close();
            return new File(savePath).getName();
        } catch (IOException | DocumentException e) {
            return null;
        }
    }

}