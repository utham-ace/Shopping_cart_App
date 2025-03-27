package com.ecom.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

@Configuration
public class AwsConfig {

	@Value("${aws.access.key}")
	private String accesskey;
	
	@Value("${aws.secret.key}")
	private String SecretKey;
	
	@Value("${aws.region}")
	private String region;
	
	@Bean
	public AmazonS3 amazonS3()
	{
	BasicAWSCredentials credentials	=new BasicAWSCredentials(accesskey, SecretKey);
	
	return AmazonS3Client.builder().
	withRegion(region)
	.withCredentials(new AWSStaticCredentialsProvider(credentials)).
	build();
	}
}
