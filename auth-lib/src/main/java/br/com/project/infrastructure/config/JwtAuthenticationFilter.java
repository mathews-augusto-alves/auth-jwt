package br.com.project.infrastructure.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.project.application.service.user.UsersServiceImpl;
import br.com.project.domain.user.model.Users;
import br.com.project.infrastructure.security.JwtTokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Filter that processes JWT authentication for incoming HTTP requests.
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    private final JwtTokenProvider jwtTokenProvider;
    private final UsersServiceImpl usersService;

    /**
     * Constructor for JwtAuthenticationFilter.
     *
     * @param jwtTokenProvider The JWT token provider.
     * @param usersService The user service implementation.
     */
    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider, UsersServiceImpl usersService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.usersService = usersService;
    }

    /**
     * Filter method that is executed once per request.
     *
     * @param request The HTTP request.
     * @param response The HTTP response.
     * @param filterChain The filter chain.
     * @throws ServletException if an error occurs during filtering.
     * @throws IOException if an I/O error occurs during filtering.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = jwtTokenProvider.resolveToken(request);
        
        if (token != null && jwtTokenProvider.validateToken(token)) {
            String username = jwtTokenProvider.getUsername(token);

            try {
                Users user = usersService.findByUsername(username)
                        .orElseThrow(() -> new RuntimeException("User not found."));

                Set<GrantedAuthority> authorities = user.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.getName()))
                        .collect(Collectors.toSet());

                Authentication authentication = new UsernamePasswordAuthenticationToken(
                        username, null, authorities);

                SecurityContextHolder.getContext().setAuthentication(authentication);
                logger.info("User '{}' authenticated with roles: {}", username, authorities);
            } catch (RuntimeException e) {
                logger.error("Authentication error: {}", e.getMessage());
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication failed");
                return;
            }
        } else {
            logger.warn("No valid JWT token found for request: {}", request.getRequestURI());
        }
        
        filterChain.doFilter(request, response);
    }
}
