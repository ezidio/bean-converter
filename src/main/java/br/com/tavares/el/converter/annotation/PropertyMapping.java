package br.com.tavares.el.converter.annotation;

import java.lang.annotation.*;

/**
 * Configure the property
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PropertyMapping {

    String value();
}
