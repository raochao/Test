package com.yuanqi.powernt.tools;

import orgine.powermop.encrypt.core.EncryptException;
import orgine.powermop.encrypt.core.aes.AESHelper;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.util.Base64;

public class Test {
    public static void main(String[] args) {
        try {
            final String aPublic = decrypt("xR39hgEV+oKhtMOrakzkJQ==", "kgZlINUpGbFDtbcmpdmCUtUsLeaYrEFD107g+sUzfqELNo2cmFoH2RXas" +
                    "D62aM4RfbR8v0NB90co+GZwfXHpZfA43EOmfXoQnteJI98JrXcsnEonrNpgE4o8/ip9u2NgkKKnRZO6+tzjUpTQa3d4YinpiVUcH" +
                    "UnNVdxklqjui9bwjJUcFZqVCVMY7BZES2hzDMLbLd9BTtqhPoe7i4wqtcXM4EjnXzjIs/FKGIwthlScNti89QaQWPXvX74v09RcP" +
                    "cDKRDweZEwH5O0iPyFDTKt+D12ofyrU4i4jvUuhW+45OL9Kv4/r+eN+EDue9a7ngqrtDqe5EfA3h9Lm6e7jRzfTNiP2vv8ZxDAcR" +
                    "HCocVEJtA0EENOBPFDbYi2l4sdn8FKeoIAfph1mkTeCiG1ZEhwAs9hB0NX7G2XdzTzqkCQ=", "AES");
//
//            final String aPublic = decrypt( "kgZlINUpGbFDtbcmpdmCUtUsLeaYrEFD107g+sUzfqELNo2cmFoH2RXas\n" +
//                    "D62aM4RfbR8v0NB90co+GZwfXHpZfA43EOmfXoQnteJI98JrXcsnEonrNpgE4o8/ip9u2NgkKKnRZO6+tzjUpTQa3d4YinpiVUcH\n" +
//                    "UnNVdxklqjui9bwjJUcFZqVCVMY7BZES2hzDMLbLd9BTtqhPoe7i4wqtcXM4EjnXzjIs/FKGIwthlScNti89QaQWPXvX74v09RcP\n" +
//                    "cDKRDweZEwH5O0iPyFDTKt+D12ofyrU4i4jvUuhW+45OL9Kv4/r+eN+EDue9a7ngqrtDqe5EfA3h9Lm6e7jRzfTNiP2vv8ZxDAcR\n" +
//                    "HCocVEJtA0EENOBPFDbYi2l4sdn8FKeoIAfph1mkTeCiG1ZEhwAs9hB0NX7G2XdzTzqkCQ=".getBytes(), "xR39hgEV+oKhtMOrakzkJQ==".getBytes(),"RSA");


            System.out.println("AAAA="+aPublic);

        }catch (Exception e){
            e.printStackTrace();
        }


    }


    private final static String CIPHER_MODEL = "/CBC/NoPadding";
    /**
     * 解密
     *
     * @param key 密钥
     * @param content 加密内容，为密文
     * @param encryptKeyType 密钥类型，若为AES，此处传null，若为RSA，则公钥为public，私钥为private
     * @return 返回结果为明文，Base64处理
     */
    public static String decrypt(String key, String content, String encryptKeyType) throws EncryptException {
        try {
//            String keyAlgorithm = attribute.keyAlgorithm;

            byte[] keys = Base64.getDecoder().decode(key);

            //转base64字节码
            byte[] contentBytes = Base64.getDecoder().decode(content);
            byte[] result = AESHelper.decrypt(contentBytes, keys, "AES");

            return new String(result, Charset.forName("utf-8")).trim();
        } catch (Exception e) {
            throw new EncryptException(e);
        }

    }

    /**
     * 解密
     * @param content 密文
     * @param key  密钥
     * @param keyAlgorithm 算法名称
     * @return 明文二进制
     * @throws Exception
     */
//    public static byte[] decrypt(byte[] content, byte[] key,String keyAlgorithm) throws Exception{
//
//        Cipher cipher = Cipher.getInstance(keyAlgorithm + CIPHER_MODEL);
//        SecretKeySpec keyspec = new SecretKeySpec(key, keyAlgorithm);
//        IvParameterSpec ivspec = new IvParameterSpec(key);
//
//        cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
//
//        byte[] original = cipher.doFinal(content);
//
//        return original;
//    }

}
