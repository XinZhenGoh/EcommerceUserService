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
			.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("AKIAVU2RRFDJ5JLC3V6A","\n" +
					"ajX7wE2+TIND8RfHoJ6N8UdHFT/d3R1UcGsPN13v")))
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

		try (OutputStream os = new FileOutputStream(file)) {
			os.write(f.getBytes());
		}

		s3Client.putObject("ecommerceimagestore", uniqueFileName ,file);
		URL url= s3Client.getUrl("ecommerceimagestore", uniqueFileName);
		return url.toExternalForm();
	}


}
