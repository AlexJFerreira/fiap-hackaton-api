package br.com.postech.hackatonfiapsoathealthmedmvpapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.postech.hackatonfiapsoathealthmedmvpapi.config", "br.com.postech.hackatonfiapsoathealthmedmvpapi"})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
