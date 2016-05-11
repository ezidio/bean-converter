package br.com.tavares.el.converter.annotation;

import java.lang.annotation.*;

/**
 * Annotate that the type can be converted with BeanConverter
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ConvertFrom {

    Class<?>[] value();

}
