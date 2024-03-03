package com.example.developermaker.test;

import com.example.developermaker.utils.image.AwsS3Util;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final AwsS3Util awsS3Util;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(
            @RequestParam(value = "file") MultipartFile file
    ) {
        return new ResponseEntity<>(awsS3Util.uploadFile(file), HttpStatus.OK);
    }


    // 다중 업로드
    @PostMapping("/uploads")
    public ResponseEntity<?> uploadFiles(
            @RequestParam(value = "files") List<MultipartFile> files
    ) {
        return new ResponseEntity<>(awsS3Util.uploadFiles(files), HttpStatus.OK);
    }

    // 다운로드
    @GetMapping("/download")
    public ResponseEntity<ByteArrayResource> downloadFile(@RequestParam(value = "image") String image) {

        //  ex. image=https://board-example.s3.ap-northeast-2.amazonaws.com/2b8359b2-de59-4765-8da0-51f5d4e556c3.jpg

        byte[] data = awsS3Util.downloadFile(image);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + image + "\"")
                .body(resource);
    }



    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteFile(@RequestParam String image) {
        return new ResponseEntity<>(awsS3Util.deleteFile(image), HttpStatus.OK);
    }

}
