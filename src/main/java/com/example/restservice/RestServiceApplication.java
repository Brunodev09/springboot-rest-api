package com.example.restservice;

import com.example.restservice.domain.Quote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class RestServiceApplication {

    private static final Logger log = LoggerFactory.getLogger(RestServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

//    @Bean
//    public boolean run(RestTemplate restTemplate) throws Exception {
////        String url = "https://gturnquist-quoters.cfapps.io/api/random";
////        return args -> {
////            Quote quote = restTemplate.getForObject(url, Quote.class);
////            if (quote != null) log.info(quote.toString());
////            else log.info("Request returned empty for url -> " + url);
////        };
//        log.info("Done loading application...");
//        return true;
//    }

}
