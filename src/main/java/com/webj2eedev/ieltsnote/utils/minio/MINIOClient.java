package com.webj2eedev.ieltsnote.utils.minio;

import io.minio.*;
import io.minio.http.Method;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Slf4j
@Component
public class MINIOClient {
    @Value("${minio.url}")
    private String url;
    @Value("${minio.accessKey}")
    private String accessKey;
    @Value("${minio.secretKey}")
    private String secretKey;

    public void putObject(String bucketName, String objectName, InputStream inputStream, Long size, String contentType) {
        try {
            MinioClient minioClient = MinioClient.builder().endpoint(url).credentials(accessKey, secretKey).build();

            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!found) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            }

            minioClient.putObject(
                    PutObjectArgs.builder().bucket(bucketName).object(objectName).stream(
                                    inputStream, size, -1)
                            .contentType(contentType)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void removeObject(String bucketName, String objectName) {
        MinioClient minioClient = MinioClient.builder().endpoint(url).credentials(accessKey, secretKey).build();
        try {
            minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(objectName).build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getObjectPersistUrl(String bucketName, String objectname) {
        return getPersistUrl(bucketName, objectname);
    }

    public String getObjectTempUrl(String bucketName, String objectname) {
        try {
            MinioClient minioClient = MinioClient.builder().endpoint(url).credentials(accessKey, secretKey).build();
            return minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder().bucket(bucketName).object(objectname).method(Method.GET).build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getPersistUrl(String bucketName, String objectname) {
        try {
            return "/minio" + "/" + bucketName + "/" + objectname;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
