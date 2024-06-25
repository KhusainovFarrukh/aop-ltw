package kh.farrukh.aopltw.tenant;

public class CurrentTenant {

  private static final ThreadLocal<Long> tenant = new ThreadLocal<>();

  public static Long get() {
    return tenant.get();
  }

  public static void set(Long value) {
    tenant.set(value);
  }

}
