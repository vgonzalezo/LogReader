package cl.pixelchile.jwt;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.auth0.jwt.Algorithm;
import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTSigner.Options;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class JWTest {

//	@Test
	public void javaJwt() throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, SignatureException, IOException, JWTVerifyException {
		Options opt = new Options();
		opt.setAlgorithm(Algorithm.HS256);
		JWTSigner signer = new JWTSigner("1");
		
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("sub", "4990");
		
		String token = signer.sign(claims);
		
		System.out.println(token);
		
		JWTVerifier verifier = new JWTVerifier("1".getBytes());
		Map<String, Object> result = verifier.verify(token);
		
		
		for (Map.Entry entry : result.entrySet()) {
		    System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
	
//	@Test
	public void jjwt() {
		Key key = MacProvider.generateKey();

		String compactJws = Jwts.builder()
		  .setSubject("4990")
		  .signWith(SignatureAlgorithm.HS256, "1".getBytes())
		  .compact();
		
		System.out.println(compactJws);
		
		System.out.println(Jwts.parser().setSigningKey("1".getBytes()).parseClaimsJws(compactJws).getBody().getSubject());
	}
	
//	@Test
	public void Jwts2() {
		String compatJws = Jwts2.encode("4990", "1");
		System.out.println(compatJws);
		System.out.println(Jwts2.decode(compatJws, "1"));
	}
	
	@Test
	public void Md5() throws Exception {
		String compatJws = Md5.Cifrar("v.gonzalez.o@gmail.com");
		System.out.println(compatJws);
		System.out.println(Md5.Descifrar(compatJws));
	}
}
