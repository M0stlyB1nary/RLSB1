package tech.lander.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AppRequestInterceptor
        extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(AppRequestInterceptor.class);
    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) {

        HttpServletRequest requestCacheWrapperObject
                = new ContentCachingRequestWrapper(request);
        requestCacheWrapperObject.getParameterMap();
        // Read inputStream from requestCacheWrapperObject and log it
        logger.info("Request: " + requestCacheWrapperObject.getRequestURI());
//        logger.warn("this is a warn message");
//        logger.error("this is a error message");
        return true;
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception ex) {
        //
    }
}