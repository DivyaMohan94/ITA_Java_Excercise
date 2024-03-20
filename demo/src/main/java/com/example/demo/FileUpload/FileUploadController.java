package com.example.demo.FileUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.Util.ResponseMessage;

@Controller
public class FileUploadController {

    private FileUploadService fileUploadService;

    @Autowired
   private FileUploadController(FileUploadService fileUploadService){
       this.fileUploadService = fileUploadService;
   }

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage>  uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            FileModel data = fileUploadService.uploadFile(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
        }
    }
}
