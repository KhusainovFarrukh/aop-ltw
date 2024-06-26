package kh.farrukh.aopltw.tenant;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.Session;

@Aspect
public class TenantAspect {

  @AfterReturning(pointcut = "execution (* org.hibernate.internal.SessionFactoryImpl.SessionBuilderImpl.openSession(..))", returning = "session")
  public void getSessionAfter(Session session) {
    session
        .enableFilter("tenantFilter")
        .setParameter("tenant", CurrentTenant.get());
  }

}
