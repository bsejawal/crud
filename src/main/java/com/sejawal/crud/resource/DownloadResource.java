package com.sejawal.crud.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


@RestController
public class DownloadResource {

    @Autowired
    ResourceLoader resourceLoader;

    @GetMapping("/pdffile")
    public ResponseEntity<Resource> pdfDownload(){
        Resource resource=resourceLoader.getResource("classpath:test.pdf");
        System.out.println("file downloading");
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
    @GetMapping("/pdfBytestream")
    public @ResponseBody byte[] byteStream()throws IOException{
        Resource resource=resourceLoader.getResource("classpath:test.pdf");
        InputStream in = resource.getInputStream();
        return IOUtils.toByteArray(in);
    }
    @GetMapping(
            value = "/pdfBytestreamWithContentType",
            produces = MediaType.APPLICATION_PDF_VALUE
    )
    public @ResponseBody byte[] byteStreamWithContentType()throws IOException{
        Resource resource=resourceLoader.getResource("classpath:test.pdf");
        InputStream in = resource.getInputStream();
        return IOUtils.toByteArray(in);
    }
}
