package tech.lander.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppRequestMVCConfig implements WebMvcConfigurer {

    @Autowired
    private AppRequestInterceptor appRequestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(appRequestInterceptor)
                .addPathPatterns("/**/");
    }
}