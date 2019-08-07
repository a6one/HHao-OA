package com.yj.oa.framework.web.controller.defaulView;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class DefaultView extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/OA").setViewName("redirect:/oa/toLogin");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        // 这里其实没有比较，框架其实会传入registry框架
        super.addViewControllers(registry);
    }



}
