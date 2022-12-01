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

    private final String SPEAKING_TEST_BUCKET_NAME = "speaking-answer-mp3-bucket";
    private final String SPEAKING_TEST_VIDEO_BUCKET_NAME = "speaking-answer-video-bucket";

    private final String LISTENING_TEST_BUCKET_NAME = "listening-answer-mp3-bucket";

    private final String WRITING_TEST_BUCKET_NAME = "writing-images-bucket";
    private final String READING_IMAGES_BUCKET_NAME = "reading-images-bucket";
    private final String LISTENING_IMAGES_BUCKET_NAME = "listening-images-bucket";

    private final String WORD_AUDIO_BUCKET_NAME = "word-audio-bucket";
    private final String WORD_IMAGE_BUCKET_NAME = "word-image-bucket";

    private final String READING_TEST_BUCKET_NAME = "reading-test-bucket";

    private final String GRAMMAR_BUCKET_NAME = "grammar-bucket";
    private final String BGKNOWLEDGE_BUCKET_NAME = "bgknowledge-bucket";

    public void putObject(String bucketName, String objectName, InputStream inputStream, Long size, String contentType) {
        putTestMp3(bucketName, objectName, inputStream, size, contentType);
    }

    public String getObjectUrl(String bucketName, String objectname) {
        return getPersistUrl(bucketName, objectname);
    }


    // -----------------------

    public void putBgknowledgeObject(String objectName, InputStream inputStream, Long size, String contentType) {
        putTestMp3(BGKNOWLEDGE_BUCKET_NAME, objectName, inputStream, size, contentType);
    }

    public String getBgknowledgeObjectUrl(String objectname) {
        return getPersistUrl(BGKNOWLEDGE_BUCKET_NAME, objectname);
    }


    // -------------------

    public void putGrammarObject(String objectName, InputStream inputStream, Long size, String contentType) {
        putTestMp3(GRAMMAR_BUCKET_NAME, objectName, inputStream, size, contentType);
    }

    public String getGrammarObjectUrl(String objectname) {
        return getPersistUrl(GRAMMAR_BUCKET_NAME, objectname);
    }


    // -------------------

    public void putReadingTestObject(String objectName, InputStream inputStream, Long size, String contentType) {
        putTestMp3(READING_TEST_BUCKET_NAME, objectName, inputStream, size, contentType);
    }

    public String getReadingTestObjectUrl(String objectname) {
        return getPersistUrl(READING_TEST_BUCKET_NAME, objectname);
    }


    // -------------------

    public void putSpeakingTestVideo(String objectName, InputStream inputStream, Long size, String contentType) {
        putTestMp3(SPEAKING_TEST_VIDEO_BUCKET_NAME, objectName, inputStream, size, contentType);
    }

    public String getSpeakingTestVideoUrl(String objectname) {
        return getPersistUrl(SPEAKING_TEST_VIDEO_BUCKET_NAME, objectname);
    }


    public void putSpeakingTestMp3(String objectName, InputStream inputStream, Long size, String contentType) {
        putTestMp3(SPEAKING_TEST_BUCKET_NAME, objectName, inputStream, size, contentType);
    }

    public String getSpeakingTestMp3Url(String objectname) {
        return getPersistUrl(SPEAKING_TEST_BUCKET_NAME, objectname);
    }

    // -----------------

    public void putListeningTestMp3(String objectName, InputStream inputStream, Long size, String contentType) {
        putTestMp3(LISTENING_TEST_BUCKET_NAME, objectName, inputStream, size, contentType);
    }

    public String getListeningTestMp3Url(String objectname) {
        return getPersistUrl(LISTENING_TEST_BUCKET_NAME, objectname);
    }

    // -----------------
    public void putWritingTestImage(String objectName, InputStream inputStream, Long size, String contentType) {
        putTestMp3(WRITING_TEST_BUCKET_NAME, objectName, inputStream, size, contentType);
    }

    public String getWritingTestImageUrl(String objectname) {
        return getPersistUrl(WRITING_TEST_BUCKET_NAME, objectname);
    }

    //////////////////////////

    public void putReadingImage(String objectName, InputStream inputStream, Long size, String contentType) {
        putTestMp3(READING_IMAGES_BUCKET_NAME, objectName, inputStream, size, contentType);
    }

    public String getReadingImageUrl(String objectname) {
        return getPersistUrl(READING_IMAGES_BUCKET_NAME, objectname);
    }


    //////////////////////////

    public void putListeningTestImage(String objectName, InputStream inputStream, Long size, String contentType) {
        putTestMp3(LISTENING_IMAGES_BUCKET_NAME, objectName, inputStream, size, contentType);
    }

    public String getListeningTestImageUrl(String objectname) {
        return getPersistUrl(LISTENING_IMAGES_BUCKET_NAME, objectname);
    }


    //////////////////////////

    public void putWordAudio(String objectName, InputStream inputStream, Long size, String contentType) {
        putTestMp3(WORD_AUDIO_BUCKET_NAME, objectName, inputStream, size, contentType);
    }

    public String getWordAudioUrl(String objectname) {
        return getPersistUrl(WORD_AUDIO_BUCKET_NAME, objectname);
    }

    //////////////////////////

    public void putWordImage(String objectName, InputStream inputStream, Long size, String contentType) {
        putTestMp3(WORD_IMAGE_BUCKET_NAME, objectName, inputStream, size, contentType);
    }

    public String getWordImageUrl(String objectname) {
        return getPersistUrl(WORD_IMAGE_BUCKET_NAME, objectname);
    }


    private void putTestMp3(String bucketName, String objectName, InputStream inputStream, Long size, String contentType) {
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

    private String getTempUrl(String bucketName, String objectname) {
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
