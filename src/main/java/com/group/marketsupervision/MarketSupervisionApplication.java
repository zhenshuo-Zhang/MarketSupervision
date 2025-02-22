package com.group.marketsupervision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class MarketSupervisionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketSupervisionApplication.class, args);
    }

}
