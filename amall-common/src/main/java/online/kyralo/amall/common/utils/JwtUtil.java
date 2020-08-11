package online.kyralo.amall.common.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.business.AuthException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static online.kyralo.amall.common.constants.SecurityConstant.TOKEN_PREFIX;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/6/20
 * \* Time: 14:51
 * \* Description: jwt
 * \
 */
@Slf4j
@Component
public class JwtUtil {
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    private static final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static Long expiration;
    private static String tokenHead;

    @Value("${jwt.expiration}")
    private Long jwtExpiration;
    @Value("${jwt.tokenHead}")
    private String jwtTokenHead;

    @PostConstruct
    public void init() {
        expiration = this.jwtExpiration;
        tokenHead = this.jwtTokenHead;
    }

    /**
     * 根据负载生成JWT的token
     */
    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(KEY)
                .compact();
    }

    /**
     * 管理员token授权
     *
     * @param username 用户名
     * @return the JWT token
     */
    public static String generateTokenForAdmin(String username) {

        Claims claims = Jwts.claims()
                .setAudience(username).setSubject("ROLE_ADMIN");
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(KEY)
                .compact();
    }


    /**
     * 解析token
     * 从token中获取JWT中的负载
     *
     * @param token the JWT token to parse
     * @return token claims
     */
    public static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(KEY)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
        } catch (JwtException e) {
            log.warn("JWT格式验证失败: {} \n {}\n", token, e.getMessage());
            throw new AuthException(ResCode.UNAUTHORIZED);
        }
        return claims;
    }

    /**
     * 生成token的过期时间
     */
    public static Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * 从token中获取登录用户名
     */
    public static String getUserNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 验证token是否还有效
     *
     * @param token       客户端传入的token
     * @param userDetails 从数据库中查询出来的用户信息
     */
    public static boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * 判断token是否已经失效
     */
    public static boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token.replace(TOKEN_PREFIX, ""));
        return expiredDate.before(new Date());
    }

    /**
     * 从token中获取过期时间
     */
    public static Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token.replace(TOKEN_PREFIX, ""));
        return claims.getExpiration();
    }

    /**
     * 根据用户信息生成token
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 当原来的token没过期时是可以刷新的
     *
     * @param oldToken 带tokenHead的token
     */
    public static String refreshHeadToken(String oldToken) {
        if (StrUtil.isEmpty(oldToken)) {
            return null;
        }
        String token = oldToken.substring(tokenHead.length());
        if (StrUtil.isEmpty(token)) {
            return null;
        }
        //token校验不通过
        Claims claims = getClaimsFromToken(token);
        if (claims == null) {
            return null;
        }
        //如果token已经过期，不支持刷新
        if (isTokenExpired(token)) {
            return null;
        }
        //如果token在30分钟之内刚刷新过，返回原token
        if (tokenRefreshJustBefore(token)) {
            return token;
        } else {
            claims.put(CLAIM_KEY_CREATED, new Date());
            return generateToken(claims);
        }
    }

    /**
     * 判断token在指定时间内是否刚刚刷新过
     *
     * @param token 原token
     */
    public static boolean tokenRefreshJustBefore(String token) {
        Claims claims = getClaimsFromToken(token.replace(TOKEN_PREFIX, ""));
        Date created = claims.get(CLAIM_KEY_CREATED, Date.class);
        Date refreshDate = new Date();
        //刷新时间在创建时间的指定时间内
        return refreshDate.after(created) && refreshDate.before(DateUtil.offsetSecond(created, 1800));
    }
}
