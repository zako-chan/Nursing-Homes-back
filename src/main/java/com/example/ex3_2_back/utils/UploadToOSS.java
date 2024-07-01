package com.example.ex3_2_back.utils;

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyuncs.exceptions.ClientException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.springframework.core.io.buffer.DataBufferUtils.readInputStream;

public class UploadToOSS {
    //获取域名
    public static final String ALI_DOMAIN = "https://api-03-tiktok.oss-cn-beijing.aliyuncs.com/";
    // 地域节点
    @Value("${oss.endpoint}")
    static String OSS_ENDPOINT;
    @Value("${oss.access-key-id}")
    static String OSS_ACCESS_KEY_ID;
    @Value("${oss.access-key-secret}")
    static String OSS_ACCESS_KEY_SECRET;
    @Value("${oss.bucket-name}")
    static String OSS_BUCKET_NAME;

    public static String uploadFile(MultipartFile file) throws IOException, URISyntaxException, ClientException {
        //生成新文件名
        String originalFileName = file.getOriginalFilename();
        String ext = "." + FilenameUtils.getExtension(originalFileName);
        String uuid = UUID.randomUUID().toString().replace("-","");
        String fileName = uuid + ext ;
        String parentDir = "";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(OSS_ENDPOINT, OSS_ACCESS_KEY_ID, OSS_ACCESS_KEY_SECRET);

        String bucketName = "api-03-tiktok";

        String contentType = file.getContentType();
        System.out.println("File MIME type: " + contentType);
        if(contentType != null){
            if (contentType.equals("video/mp4")) {
                parentDir = "video/";
            } else if (contentType.equals("image/jpeg") || contentType.equals("image/jpg")||contentType.equals("image/png")) {
                parentDir = "image/";
            }
        }

        //存放视频文件
        ossClient.putObject(
                bucketName,//仓库名
                parentDir + LocalDate.now() + "/" + fileName,//文件名
                file.getInputStream()
        );
        ossClient.shutdown();

        return "http://" + OSS_BUCKET_NAME + ". " + OSS_ENDPOINT + "/" + fileName;
    }



}
