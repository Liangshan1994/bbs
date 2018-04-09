package com.pikaqiu.bbs.utils;

import com.pikaqiu.bbs.entity.Dict;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Create by lvls on 2018/4/9
 */
@Component
public class DictDirective implements TemplateDirectiveModel {

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
        if(map.containsKey("type") && map.get("type") != null){
            String type = map.get("type").toString();
            List<Dict> dictList = DictUtils.getDictList(type);
            if(map.containsKey("value") && map.get("value") != null){
                String value = map.get("value").toString();
                Dict dict = null;
                for (Dict dict1 : dictList) {
                    if(value.equals(dict1.getValue().toString())){
                        dict = dict1;
                    }
                }
                environment.setVariable("dict", builder.build().wrap(dict));
            }else{
                environment.setVariable("dictList", builder.build().wrap(dictList));
            }
        }
        if(templateDirectiveBody!=null){
            templateDirectiveBody.render(environment.getOut());
        }
    }
}
