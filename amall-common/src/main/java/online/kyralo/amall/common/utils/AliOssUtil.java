//package online.kyralo.amall.common.utils;
//
//import com.aliyun.oss.OSS;
//import com.aliyun.oss.OSSException;
//import com.aliyun.oss.model.CannedAccessControlList;
//import com.aliyun.oss.model.CreateBucketRequest;
//import com.aliyun.oss.model.PutObjectRequest;
//import com.aliyun.oss.model.PutObjectResult;
//import lombok.extern.slf4j.Slf4j;
//import online.kyralo.amall.common.constants.ResCodeConstant;
//import online.kyralo.amall.common.exceptions.business.AliOSSException;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Objects;
//import java.util.UUID;
//
///**
// * \* Created with Intellij IDEA.
// * \* Author: wangchen
// * \* Date: 2020-05-14
// * \* Time: 21:28
// * \* Description:
// * \
// */
//
//@Component
//@Slf4j
//public class AliOssUtil {
//
//    @Value("${aliyun.oss.dir.prefix}")
//    private String ossDirPrefix;
//
//    @Value("${aliyun.oss.bucketName}")
//    private String ossBucketName;
//
//    @Resource
//    private OSS oss;
//
//    private static String dirPrefix;
//    private static String bucketName;
//    private static OSS ossClient;
//
//    @PostConstruct
//    public void init(){
//        dirPrefix = this.ossDirPrefix;
//        bucketName = this.ossBucketName;
//        ossClient =  this.oss;
//    }
//
//    /**
//     * 文件上传
//     * @param file 文件流
//     * @param fileUrl 文件url(relatedUrl()方法确定)
//     * @return OSS上文件的网络地址
//     */
//    public static String upload(MultipartFile file, String fileUrl) {
//
//        if (null == file) {
//            throw new AliOSSException(ResCodeConstant.FAILED, "文件不能为空!");
//        }
//
//        try {
//            //容器不存在，就创建
//            if (!ossClient.doesBucketExist(bucketName)) {
//                ossClient.createBucket(bucketName);
//                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
//                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
//                ossClient.createBucket(createBucketRequest);
//            }
//
//            //创建文件路径
//            // String fileUrl = fileHost + "/" + (dateStr + "/" + UUID.randomUUID().toString().replace("-", "") + "-" + file.getName())
//
//            String[] split = Objects.requireNonNull(file.getOriginalFilename()).split("\\.");
//
//            fileUrl = dirPrefix + fileUrl + "." + split[1];
//
//            //上传文件
//            PutObjectResult result =
//                    ossClient.putObject(new PutObjectRequest(bucketName, fileUrl, file.getInputStream()));
//            //设置权限 这里是公开读
//            ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
//            if (null != result) {
//                return fileUrl;
//            }
//        } catch (OSSException | IOException oe) {
//            log.error("文件上传失败! -- " + new Date().toString());
//            throw new AliOSSException(ResCodeConstant.FAILED, "文件上传失败!");
//        }
//
//        return null;
//    }
//
//    /**
//     * OSS上相关文件路径
//     * @param name 上传的文件名
//     * @param dir 上传到的文件夹
//     * @return 路径
//     */
//    public static String relatedUrl(String dir, String name){
//        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd/");
//        if ("".equals(name)){
//            return dir + format.format(new Date()) + UUID.randomUUID().toString().replace("-", "");
//        }
//        return dir + format.format(new Date()) + name;
//    }
//
//
//    public static File changeToFile(MultipartFile file) throws IOException {
//        String filename = file.getOriginalFilename();
//        if (filename != null && !"".equals(filename.trim())) {
//            File newFile = new File(filename);
//            FileOutputStream os = new FileOutputStream(newFile);
//            os.write(file.getBytes());
//            os.close();
//            file.transferTo(newFile);
//            return newFile;
//        }
//
//        return null;
//    }
//
//}
