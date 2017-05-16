package cl.pixelchile.jwt;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.Algorithm;
import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.auth0.jwt.JWTSigner.Options;

public abstract class Jwts2 {

	public static String encode(String texto, String clave) {
		String token = null;
		
		try {
			Options opt = new Options();
			opt.setAlgorithm(Algorithm.HS256);
			
			JWTSigner signer = new JWTSigner(clave.getBytes());
			
			Map<String, Object> claims = new HashMap<String, Object>();
			claims.put("sub", texto);
			token = signer.sign(claims);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return token;
	}
	
	public static String decode(String token, String clave) {
		String texto = null;
		Map<String, Object> result = null;
		
		try {
			JWTVerifier verifier = new JWTVerifier(clave.getBytes());
			result = verifier.verify(token);
			texto = result.get("sub").toString();
		} catch (InvalidKeyException | NoSuchAlgorithmException | IllegalStateException | SignatureException
				| IOException | JWTVerifyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return texto;
	}
}
