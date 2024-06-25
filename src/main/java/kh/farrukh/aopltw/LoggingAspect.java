package kh.farrukh.aopltw;

import java.util.Optional;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

  @Pointcut("execution(* kh.farrukh.aopltw..*(..))")
  public void allMethods() {
  }

  @Before("allMethods()")
  public void logMethod(JoinPoint joinPoint) {
    var className = Optional.ofNullable(joinPoint.getTarget())
        .map(Object::getClass)
        .map(Class::getName)
        .orElse("Unknown class");
    var methodName = Optional.ofNullable(joinPoint.getSignature())
        .map(Signature::getName)
        .orElse("Unknown method");

    System.out.println("Before method: " + className + "." + methodName);
  }

}
