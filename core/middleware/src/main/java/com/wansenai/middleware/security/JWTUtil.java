package com.wansenai.middleware.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * <P>
 *  JWT工具类
 * </P>
 */
@Component
public class JWTUtil {

    /** 有效期为一天 **/
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24;

    /** 密钥，建议从配置文件中读取 */
    private static final String SECRET_STRING = "9c9gDwweAyELX3DindbyVfZbNM9bUdfD";

    /** 使用更安全的密钥生成方式 */
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET_STRING.getBytes());

    /**
     * 生成token
     * @param userName 用户名
     * @return token字符串
     */
    public String createToken(String userName) {
        // 不需要手动设置 "alg"，signWith 会自动设置；如果需要自定义 header 可使用 setHeader(Map)
        return Jwts.builder()
                .claim("userName", userName)
                .subject(userName)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY) // 使用 SecretKey，JJWT 会自动填充 alg 等头部
                .compact();
    }

    /**
     * 验证token
     * @param token token字符串
     * @return Claims对象，如果验证失败返回null
     */
    public Claims checkToken(String token) {
        if (token == null || token.trim().isEmpty()) {
            return null;
        }

        try {
            return Jwts.parser()
                    .verifyWith(SECRET_KEY)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (ExpiredJwtException e) {
            // token过期
            System.err.println("Token expired: " + e.getMessage());
            return null;
        } catch (MalformedJwtException e) {
            // token格式错误
            System.err.println("Invalid token: " + e.getMessage());
            return null;
        } catch (SignatureException e) {
            // 签名验证失败
            System.err.println("Signature validation failed: " + e.getMessage());
            return null;
        } catch (JwtException e) {
            // 其他JWT异常
            System.err.println("JWT exception: " + e.getMessage());
            return null;
        }
    }

    /**
     * 从token中获取用户ID
     * @param token token字符串
     * @return 用户ID，如果解析失败返回null
     */
    public Long getUserIdFromToken(String token) {
        Claims claims = checkToken(token);
        if (claims == null) {
            return null;
        }

        try {
            // 注意：这里期望 subject 存的是用户 ID（字符串形式）。如果你实际把 subject 设为 username，
            // 则应改用 getUsernameFromToken 而不是这个方法。
            String subject = claims.getSubject();
            return subject != null ? Long.valueOf(subject) : null;
        } catch (NumberFormatException e) {
            System.err.println("Invalid user ID format in token: " + e.getMessage());
            return null;
        }
    }

    /**
     * 从token中获取用户名
     * @param token token字符串
     * @return 用户名，如果解析失败返回null
     */
    public String getUsernameFromToken(String token) {
        Claims claims = checkToken(token);
        if (claims == null) {
            return null;
        }

        return claims.get("userName", String.class);
    }

    /**
     * 检查token是否即将过期（在指定时间内）
     * @param token token字符串
     * @param minutes 提前检查的分钟数
     * @return 是否即将过期
     */
    public boolean isTokenExpiringSoon(String token, long minutes) {
        Claims claims = checkToken(token);
        if (claims == null) {
            return true;
        }

        Date expiration = claims.getExpiration();
        long currentTime = System.currentTimeMillis();
        long threshold = minutes * 60 * 1000; // 转换为毫秒

        return (expiration.getTime() - currentTime) <= threshold;
    }

    /**
     * 刷新token（创建新token）
     * @param token 旧token
     * @return 新token，如果旧token无效返回null
     */
    public String refreshToken(String token) {
        Claims claims = checkToken(token);
        if (claims == null) {
            return null;
        }

        String userName = claims.get("userName", String.class);
        if (userName == null) {
            userName = claims.getSubject();
        }

        return createToken(userName);
    }

    /**
     * 获取token的过期时间
     * @param token token字符串
     * @return 过期时间，如果解析失败返回null
     */
    public Date getExpirationDateFromToken(String token) {
        Claims claims = checkToken(token);
        return claims != null ? claims.getExpiration() : null;
    }

    /**
     * 获取token的签发时间
     * @param token token字符串
     * @return 签发时间，如果解析失败返回null
     */
    public Date getIssuedAtDateFromToken(String token) {
        Claims claims = checkToken(token);
        return claims != null ? claims.getIssuedAt() : null;
    }
}