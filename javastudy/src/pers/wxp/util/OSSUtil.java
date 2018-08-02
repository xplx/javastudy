package pers.wxp.util;

import com.aliyun.oss.*;
import com.aliyun.oss.model.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * 该示例代码展示了如果在OSS中创建和删除一个Bucket，以及如何上传和下载一个文件。
 * 
 * 该示例代码的执行过程是： 1. 创建一个Bucket（如果已经存在，则忽略错误码）； 2. 上传一个文件到OSS； 3. 下载这个文件到本地； 4.
 * 清理测试资源：删除Bucket及其中的所有Objects。
 * 
 * 尝试运行这段示例代码时需要注意： 1. 为了展示在删除Bucket时除了需要删除其中的Objects,
 * 示例代码最后为删除掉指定的Bucket，因为不要使用您的已经有资源的Bucket进行测试！ 2.
 * 请使用您的API授权密钥填充ACCESS_ID和ACCESS_KEY常量； 3.
 * 需要准确上传用的测试文件，并修改常量uploadFilePath为测试文件的路径； 修改常量downloadFilePath为下载文件的路径。 4.
 * 该程序仅为示例代码，仅供参考，并不能保证足够健壮。
 * 
 */
public class OSSUtil {

	public static String ACCESS_ID = "ymx8Po4GOd5dZLxt";
	public static String ACCESS_KEY = "ltOxF4OgubhazlElV3uIkGgZKhsfBI";
	public static String OSS_ENDPOINT = "http://oss-cn-qingdao.aliyuncs.com";
	public static String bucketName = "xintongdai-test";// 普通bucket
	public static String pBucketName = "xintongdai-private-test";// 私有的bucket
	public static String bucketUrl = "http://xintongdai-test.oss-cn-qingdao.aliyuncs.com";


	// 上传文件
	public static Boolean uploadInputStream(String key, InputStream inputStream) {
		OSSClient client = null;
		boolean s = true;
		try {
			client = new OSSClient(OSS_ENDPOINT, ACCESS_ID, ACCESS_KEY);
			// 判断Bucket
			ensureBucket(client, pBucketName);
			// 上传文件流
			client.putObject(pBucketName, key, inputStream);
		} catch (Exception e) {
			e.printStackTrace();
			s = false;
		} finally {
			try {
				// 关闭client
				if (client != null) {
					client.shutdown();
				}
				// 关闭文件流
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
			}
		}
		return s;
	}

	// 上传文件
	public static Boolean multipartFileUpload(String bucketName,
			String fileName, String file, MultipartFile uploadFilePath,
			String fileType) {
		String key = file + "/" + fileName;

		ClientConfiguration config = new ClientConfiguration();
		OSSClient client = new OSSClient(OSS_ENDPOINT, ACCESS_ID, ACCESS_KEY,
				config);

		ensureBucket(client, bucketName);

		boolean success = true;
		try {

			uploadMultipartFile(client, bucketName, key, uploadFilePath,
					fileType);

		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		}
		return success;
	}

	// 上传文件
	public static Boolean fileUpload(String bucketName, String fileName,
			String file, String uploadFilePath, String fileType) {
		String key = file + "/" + fileName;

		ClientConfiguration config = new ClientConfiguration();
		OSSClient client = new OSSClient(OSS_ENDPOINT, ACCESS_ID, ACCESS_KEY,
				config);

		ensureBucket(client, bucketName);

		boolean success = true;
		try {

			uploadFile(client, bucketName, key, uploadFilePath, fileType);

		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		}
		return success;
	}

	// 创建Bucket.
	private static void ensureBucket(OSSClient client, String bucketName)
			throws OSSException, ClientException {

		try {
			// 创建bucket
			client.createBucket(bucketName);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	// 删除一个Bucket和其中的Objects
	private static void deleteBucket(OSSClient client) throws OSSException,
			ClientException {

		ObjectListing ObjectListing = client.listObjects(bucketName);
		List<OSSObjectSummary> listDeletes = ObjectListing.getObjectSummaries();
		for (int i = 0; i < listDeletes.size(); i++) {
			String objectName = listDeletes.get(i).getKey();
			// 如果不为空，先删除bucket下的文件
			client.deleteObject(bucketName, objectName);
		}
		client.deleteBucket(bucketName);
	}

	// 把Bucket设置为所有人可读
	private static void setBucketPublicReadable(OSSClient client,
			String bucketName) throws OSSException, ClientException {
		// 创建bucket
		client.createBucket(bucketName);

		// 设置bucket的访问权限，public-read-write权限
		client.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
	}

	// 上传文件
	private static void uploadMultipartFile(OSSClient client,
			String bucketName, String key, MultipartFile filename,
			String flieType) throws OSSException, ClientException, IOException {
		/* File file = new File(filename); */

		ObjectMetadata objectMeta = new ObjectMetadata();
		objectMeta.setContentLength(filename.getSize());
		// 可以在metadata中标记文件类型
		objectMeta.setContentType(flieType);

		InputStream input = filename.getInputStream();
		client.putObject(bucketName, key, input, objectMeta);
	}

	// 上传文件
	private static void uploadFile(OSSClient client, String bucketName,
			String key, String filename, String flieType) throws OSSException,
			ClientException, FileNotFoundException {
		File file = new File(filename);

		ObjectMetadata objectMeta = new ObjectMetadata();
		objectMeta.setContentLength(file.length());
		// 可以在metadata中标记文件类型
		objectMeta.setContentType(flieType);

		InputStream input = new FileInputStream(file);
		client.putObject(bucketName, key, input, objectMeta);
	}

	// 获得只读文件的临时URL exp为分钟数
	public static String getUrl(String bucket, String keyFile, int exp) {
		Date expiration = new Date(new Date().getTime() + 6000 * exp);
		ClientConfiguration config = new ClientConfiguration();
		OSSClient client = new OSSClient(OSS_ENDPOINT, ACCESS_ID, ACCESS_KEY,
				config);
		// 生成URL
		URL url = client.generatePresignedUrl(bucket, keyFile, expiration);

		return url.toString();
	}

	// 下载文件
	public static void downloadFile(String key, String filename)
			throws OSSException, ClientException {
		OSSClient client = new OSSClient(OSS_ENDPOINT, ACCESS_ID, ACCESS_KEY);
		client.getObject(new GetObjectRequest(pBucketName, key), new File(
				filename));
	}

	// 获取bucket下的所有object
	public static Map<String, Object> getObjects(String bucketName, String obj,
			Integer rows, Integer page) {
		ClientConfiguration config = new ClientConfiguration();
		OSSClient client = new OSSClient(OSS_ENDPOINT, ACCESS_ID, ACCESS_KEY,
				config);

		ObjectListing listing = client.listObjects(bucketName, obj);

		List<Map<String, Object>> ls = new ArrayList<Map<String, Object>>();
		for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
			Map<String, Object> n = new HashMap<String, Object>();

			n.put("name", objectSummary.getKey());

			n.put("shijian", objectSummary.getLastModified());
			Collections.reverse(ls);
			ls.add(n);
		}
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = rows * page - rows; i < rows * page; i++) {
			if (i == ls.size()) {
				break;
			}
			list.add(ls.get(i));
		}

		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("rows", list);

		resultMap.put("total", ls.size());

		return resultMap;
	}

	public static void main(String[] args) {
		String u = OSSUtil.getUrl(OSSUtil.pBucketName,
				"customer/feedback/607117049064548_1.jpg", 30);
		System.out.println(u);
	}

}