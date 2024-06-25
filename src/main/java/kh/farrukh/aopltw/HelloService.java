package kh.farrukh.aopltw;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

  public String sayHello() {
    return getHelloMessage();
  }

  private String getHelloMessage() {
    return "Hello, World!";
  }

}
