package lk.ijse.GreenShadow.service.Impl;

import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.RouterFunctionDsl;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${spring.jwtKey}")
    private String jwtKey;

    // extract Email
    public String extractUserName(String token) {
        return extractClaim(token,Claims::getSubject);
    }

    // extract All the parts in JWT Token
    public Claims extractAllClaims(String token){
        return Jwts
                .parser()
                .setSigningKey(getSigninKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // get Secrate key and convert it as Base64 key
    private Key getSigninKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // extract All Claims and return
    public <T> T extractClaim(String token, Function<Claims,T> claimResolve){
        final Claims claims = extractAllClaims(token);
        return claimResolve.apply(claims);
    }

    // Genarate Token with extra details
    public String genarateToken(
            Map<String,Object> extractClaims,
            UserDetails userDetails
    ){
        return Jwts
                .builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis())) // set Time in milisecounds
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Genarate Token using User Details
    public String genarateToken(UserDetails userDetails){
        return genarateToken(new HashMap<>(),userDetails); // pass empty set
    }

    //cheack validation of the token
    public boolean isTokenValied(String token,UserDetails userDetails ){
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpaired(token));
    }

    //cheack token is Expaierd
    private boolean isTokenExpaired(String token) {
        return extractExpiration(token).before(new Date());
    }

    //extract token and return Expiration date
    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }

}
