package com.example.restservice.services;

import com.example.restservice.domain.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumeService {

    private static final Logger log = LoggerFactory.getLogger(ConsumeService.class);

    public String makeRandomRequest() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate restTemplate = builder.build();
        String url = "https://gturnquist-quoters.cfapps.io/api/random";
        Quote quote = restTemplate.getForObject(url, Quote.class);
        if (quote != null) log.info(quote.toString());
        else log.info("Request returned empty for url -> " + url);

        return quote != null ? quote.toString() : "";
    }
}
