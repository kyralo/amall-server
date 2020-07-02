package online.kyralo.amall.common.security.filter;

import io.jsonwebtoken.Claims;
import online.kyralo.amall.common.utils.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

import static online.kyralo.amall.common.constants.SecurityConstant.HEADER_STRING;
import static online.kyralo.amall.common.constants.SecurityConstant.TOKEN_PREFIX;


public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(HEADER_STRING);

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(request);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        // token刷新
        String refreshToken = JwtUtil.refreshHeadToken(header);
        if (refreshToken != null) {
            response.setHeader(HEADER_STRING, refreshToken);
        }

        chain.doFilter(request, response);

    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token.
            Claims claims = JwtUtil.getClaimsFromToken(token);
            if (claims != null) {
                //用户的唯一标识符 管理员为用户名 普通用户为ID
                String userIdentifier = claims.getAudience();
                String role = claims.getSubject();
                return new UsernamePasswordAuthenticationToken(userIdentifier, null,
                        Collections.singletonList(new SimpleGrantedAuthority(role)));
            }
            return null;
        }
        return null;
    }
}
