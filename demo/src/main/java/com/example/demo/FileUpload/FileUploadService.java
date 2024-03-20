package com.example.demo.FileUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@org.springframework.stereotype.Service
public class FileUploadService {

    @Autowired
    private FileUploadRepository fileUploadRepository;

    public FileModel uploadFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        FileModel newFile = new FileModel(fileName, file.getBytes(), 1, new Date());
        return fileUploadRepository.save(newFile);
    }


}
