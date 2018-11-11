package com.magicDigit.ecStore;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Date: 2018-10-10-下午12:15
 */
public class ApplicationServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	  return builder.sources(Application.class);
    }
}
