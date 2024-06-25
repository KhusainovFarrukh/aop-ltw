package kh.farrukh.aopltw.tenant;

import jakarta.persistence.EntityManager;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TenantAspect {

  @AfterReturning(pointcut = "bean(entityManagerFactory) && execution(* createEntityManager(..))", returning = "entityManager")
  public void getSessionAfter(EntityManager entityManager) {
    entityManager.unwrap(Session.class)
        .enableFilter("tenantFilter")
        .setParameter("tenant", CurrentTenant.get());
  }

}
