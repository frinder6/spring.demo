package com.spring;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created on 2016/9/2.
 */
@Component
@Profile("prod")
public class ProdConfiguration {

    public ProdConfiguration() {
        System.out.println("prod................");
    }
}
