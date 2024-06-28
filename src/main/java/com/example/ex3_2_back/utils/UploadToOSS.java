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


    public static String uploadFile(MultipartFile file) throws IOException, URISyntaxException, ClientException {
        //生成新文件名
        String originalFileName = file.getOriginalFilename();
        String ext = "." + FilenameUtils.getExtension(originalFileName);
        String uuid = UUID.randomUUID().toString().replace("-","");
        String fileName = uuid + ext ;
        String parentDir = "";
        //地域节点
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // 使用环境变量中获取的RAM用户的访问密钥配置访问凭证。
        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);

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
        return ALI_DOMAIN + parentDir + LocalDate.now() + "/" + fileName;
    }





}
