package kh.farrukh.aopltw.tenant;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class TenantInterceptor extends OncePerRequestFilter {

  public static final String TENANT_HEADER = "tenant";

  @Override
  protected void doFilterInternal(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain filterChain
  ) throws ServletException, IOException {
    try {
      CurrentTenant.set(Long.valueOf(request.getHeader(TENANT_HEADER)));
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      filterChain.doFilter(request, response);
    }
  }

}
