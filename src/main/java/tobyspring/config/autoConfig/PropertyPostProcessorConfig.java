package tobyspring.config.autoConfig;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;
import tobyspring.config.MyAutoConfiguration;
import tobyspring.config.MyConfigurationProperties;

import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;

@MyAutoConfiguration
public class PropertyPostProcessorConfig {
    @Bean
    BeanPostProcessor beanPostProcessor(Environment env){
        return new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                MyConfigurationProperties anno = findAnnotation(bean.getClass(), MyConfigurationProperties.class);
                if (anno == null)
                    return bean;

                return Binder.get(env).bindOrCreate("", bean.getClass());
//                return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
            }
        };

    }
}
