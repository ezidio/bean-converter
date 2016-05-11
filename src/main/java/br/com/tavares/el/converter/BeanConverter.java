package br.com.tavares.el.converter;

import br.com.tavares.el.converter.annotation.ConvertFrom;
import br.com.tavares.el.converter.annotation.PropertyMapping;
import br.com.tavares.el.converter.exception.BeanConverterException;

import javax.el.ELProcessor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Converte objetos com base em Expression Language
 */
public class BeanConverter {


    private final ELProcessor processor;

    public BeanConverter() {
        this(new ELProcessor());
    }

    public BeanConverter(ELProcessor elProcessor) {
        this.processor = elProcessor;
        this.processor.getELManager().addELResolver(BeanTypeConverter.INSTANCE);
    }

    public <T> List<T> convertList(List<?> origin, Class<T> type) throws BeanConverterException {
        List<T> result = new ArrayList<T>();
        for (Object o : origin) {
            result.add(convert(o, type));
        }
        return result;
    }

    public <T> T convert(Object origin, Class<T> type) throws BeanConverterException {

        if (origin == null) {
            return null;
        }

        if (type == null) {
            throw new BeanConverterException("A classe para qual o objeto será convertido deve ser definida.");
        }

        if (!type.isAnnotationPresent(ConvertFrom.class)) {
            throw new BeanConverterException("Não existe definição de tipo na classe " + type.getName());
        }

        if (!canConvertTo(origin, type)) {
            throw new BeanConverterException("A classe " + type.getName() + " não pode ser convertida a partir da classe " + origin.getClass().getName());
        }

        try {
            T result = type.newInstance();

            processor.setValue("origin", origin);

            Field[] fields = type.getDeclaredFields();
            for (Field field : fields) {
                convertField(result, field);
            }

            return result;

        } catch (InstantiationException e) {
            throw new BeanConverterException(e);
        } catch (IllegalAccessException e) {
            throw new BeanConverterException(e);
        }

    }

    private <T> void convertField(T result, Field field) throws IllegalAccessException {
        if (!field.isAnnotationPresent(PropertyMapping.class)) {
            return;
        }

        PropertyMapping ann = field.getDeclaredAnnotation(PropertyMapping.class);
        field.setAccessible(true);
        field.set(result, processor.getValue(ann.value(), field.getType()));
    }

    /**
     * Identify if origin object can be converted to type
     *
     * @param origin
     * @param type
     * @return
     * @throws BeanConverterException
     */
    public boolean canConvertTo(Object origin, Class<?> type) throws BeanConverterException {
        if (!type.isAnnotationPresent(ConvertFrom.class)) {
            return false;
        }

        ConvertFrom convertAnn = type.getDeclaredAnnotation(ConvertFrom.class);
        for (Class<?> aClass : convertAnn.value()) {
            if (aClass.isInstance(origin)) {
                return true;
            }
        }
        return false;
    }

}
