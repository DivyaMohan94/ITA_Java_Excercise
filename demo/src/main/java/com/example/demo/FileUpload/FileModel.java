package com.example.demo.FileUpload;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "files")
public class FileModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentId;
    private String documentName;
    @Lob
    private byte[] document;

    private int uploadedBy;
    private Date uploadedOn;

    public FileModel(String documentName, byte[] data, int uploadedBy, Date uploadedOn) {
        this.documentName = documentName;
        this.document = data;
        this.uploadedBy = uploadedBy;
        this.uploadedOn = uploadedOn;
    }
}
