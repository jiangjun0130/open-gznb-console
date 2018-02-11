package com.gznb.open.common.utils;

import sun.misc.BASE64Encoder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sx07 on 2017/7/13.
 */
public class RSAUtils {

    public static final String PUBLIC_KEY = "rsaPub.key";
    public static final String PRIVATE_KEY = "rsaPri.key";
    public static final String RSA = "RSA";

    public static Map<String,String> genKeyPair(int length) throws Exception{
        Map<String,String> map = new HashMap<String,String>();
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = null;
        keyPairGen = KeyPairGenerator.getInstance(RSA);
        keyPairGen.initialize(length, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        // 得到私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        // 得到公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

        // 得到公钥字符串
        String publicKeyString = new BASE64Encoder().encode(publicKey.getEncoded());
        // 得到私钥字符串
        String privateKeyString = new BASE64Encoder().encode(privateKey.getEncoded());

        map.put(PUBLIC_KEY,publicKeyString);
        map.put(PRIVATE_KEY,privateKeyString);
        return map;
    }
}
