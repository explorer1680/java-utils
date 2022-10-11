package personal.jce;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import com.sun.org.apache.xml.internal.security.algorithms.JCEMapper;
//import com.sun.org.apache.xml.internal.security.encryption.XMLCipher;
//import com.sun.org.apache.xml.internal.security.encryption.XMLCipher;

public class JCETest {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		int maxKeySize = javax.crypto.Cipher.getMaxAllowedKeyLength("AES");
        System.out.println(maxKeySize);
        JCEMapper.registerDefaultAlgorithms();
        
//		String algorithmURI = "http://www.w3.org/2001/04/xmlenc#aes128-cbc";
//		String keyAlgo = JCEMapper.getJCEKeyAlgorithmFromURI(XMLCipher.TRIPLEDES);
//		System.out.println(keyAlgo);
//		int keySize = JCEMapper.getKeyLengthFromURI(algorithmURI);
//		System.out.println(keySize);
//		KeyGenerator keyGen = KeyGenerator.getInstance(keyAlgo);
//		System.out.println(keyGen);
//        keyGen.init(keySize);
//        SecretKey secretKey = keyGen.generateKey();
	}

}
