package com.usermanagement.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Objects;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectResult;
import org.springframework.web.multipart.MultipartFile;

@Service
@Aspect
public class S3Util {

	static AmazonS3 s3Client ;

	static {   s3Client = AmazonS3ClientBuilder.standard()
			.withRegion("us-east-1")
			.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("AKIAUJ2OJLRCH3Y72U4E","lZzNvou2iXfYmmpAkBKhrphgEf84KllyX23uTaf9")))
			.build();
	}

//	public static String uploadImage(File f, String uniqueFileName) {
//		PutObjectResult result=s3Client.putObject("bucket-demo-12345", uniqueFileName ,f);
//		URL url= s3Client.getUrl("bucket-demo-12345", uniqueFileName);
//		System.out.println(url.toExternalForm());
//		return url.toExternalForm();
//	}

	public static String uploadImageWithMultipart(MultipartFile f, String uniqueFileName) throws IOException {
		File file = new File("targetFile.tmp");
//		System.out.println(f.getOriginalFilename());
//		f.transferTo(file);

		try (OutputStream os = new FileOutputStream(file)) {
			os.write(f.getBytes());
		}

		PutObjectResult result=s3Client.putObject("bucket-demo-12345", uniqueFileName ,file);
//		System.out.println(result);
		URL url= s3Client.getUrl("bucket-demo-12345", uniqueFileName);
		return url.toExternalForm();
	}


}
