package br.com.tavares.el.converter;

import br.com.tavares.el.converter.exception.BeanConverterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.el.ELContext;
import javax.el.TypeConverter;

/**
 * Convert Objects that has @ConvertFrom Annotation
 */
public class BeanTypeConverter extends TypeConverter {

    private static final Logger LOG = LoggerFactory.getLogger(BeanTypeConverter.class);

    public static BeanTypeConverter INSTANCE = new BeanTypeConverter();

    @Override
    public Object convertToType(ELContext elContext, Object o, Class<?> aClass) {
        try {
            BeanConverter beanConverter = new BeanConverter();
            if (beanConverter.canConvertTo(o, aClass)) {
                elContext.setPropertyResolved(true);
                return beanConverter.convert(o, aClass);
            }
        } catch (BeanConverterException e) {
            LOG.error("Cannot convert bean.", e);
        }
        return null;
    }
}
