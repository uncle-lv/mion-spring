package util;

import beans.exception.BeansException;

public interface StringValueResolver {
    String resolveStringValue(String strVal) throws BeansException;
}
