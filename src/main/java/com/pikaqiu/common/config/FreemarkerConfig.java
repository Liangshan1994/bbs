package com.pikaqiu.common.config;

import com.pikaqiu.bbs.utils.DictDirective;
import freemarker.template.Configuration;
import freemarker.template.TemplateModelException;
import com.pikaqiu.bbs.utils.DictDirective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Create by lvls on 2018/4/9
 */
@Component
public class FreemarkerConfig {
    @Autowired
    private Configuration configuration;
    @Autowired
    private DictDirective dictDirective;

    @PostConstruct
    public void setSharedVariable() {
        configuration.setSharedVariable("dict_tag", dictDirective);
    }
}
