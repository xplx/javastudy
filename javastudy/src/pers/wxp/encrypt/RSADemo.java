package pers.wxp.encrypt;

import javax.crypto.Cipher;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @Description:RSA加解密DEMO
 * @author:wuxiaopeng
 * @create: 2019-01-15 15:36
 **/
public class RSADemo {
    private String src = "签名";
    public void compress() throws Exception {
        KeyPairGenerator key = KeyPairGenerator.getInstance("RSA");
        key.initialize(1024);
        KeyPair pair = key.generateKeyPair();
        RSAPublicKey rsapublickey = (RSAPublicKey) pair.getPublic();
        RSAPrivateKey rsaprivatekey = (RSAPrivateKey) pair.getPrivate();
        //将私钥存到本地
        Files.write(Paths.get("D:/configuration/private.key"), rsaprivatekey.getEncoded(), StandardOpenOption.CREATE);

        //将公钥存到本地，
        Files.write(Paths.get("D:/configuration/public.key"), rsapublickey.getEncoded(),StandardOpenOption.CREATE);

        //从本地读取私钥
        byte[] privateKeyBytes = Files.readAllBytes(Paths.get("D:/configuration/private.key"));
        //从本地读取公钥
        byte[] publicKeyBytes = Files.readAllBytes(Paths.get("D:/configuration/public.key"));
        //PKCS8EncodedKeySpec类使用PKCS#8标准作为密钥规范管理的编码格式
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyfactory = KeyFactory.getInstance("RSA");
        PrivateKey privatekey = keyfactory.generatePrivate(spec);

        //签名
        Signature singnaure = Signature.getInstance("MD5withRSA");
        singnaure.initSign(privatekey);
        singnaure.update(src.getBytes());
        byte[] res = singnaure.sign();

        //X509EncodedKeySpec类使用X.509标准作为密钥规范管理的编码格式
        X509EncodedKeySpec x509spec = new X509EncodedKeySpec(publicKeyBytes);
        PublicKey publickey = keyfactory.generatePublic(x509spec);
        singnaure = Signature.getInstance("MD5withRSA");
        singnaure.initVerify(publickey);
        singnaure.update(src.getBytes());
        //验证签名
        boolean result = singnaure.verify(res);


        //加密数据
        Cipher cipher = Cipher.getInstance(keyfactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publickey);
        String data = "不要害怕你的生活将要结束，应该担心你的生活永远不会真正开始。";
        byte[] datas =  cipher.doFinal(data.getBytes());
        System.out.println("加密数据"+ datas);

        //解密数据
        Cipher pircipher = Cipher.getInstance(keyfactory.getAlgorithm());
        pircipher.init(Cipher.DECRYPT_MODE,privatekey );
        byte[] doFinal = pircipher.doFinal(datas);
        String stringresult = new String(doFinal,"UTF-8");
        System.out.println("解密数据"+ stringresult);


    }

    public static void main(String[] arg0) {
        RSADemo compress = new RSADemo();
        try {
            compress.compress();
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }
}
