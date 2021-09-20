package aop.framework.autoproxy;

import aop.*;
import aop.aspectj.AspectJExpressionPointcutAdvisor;
import aop.framework.ProxyFactory;
import beans.exception.BeansException;
import beans.factory.BeanFactory;
import beans.factory.BeanFactoryAware;
import beans.factory.config.BeanDefinition;
import beans.factory.config.InstantiationAwareBeanPostProcessor;
import beans.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.Collection;

public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private DefaultListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (isInfrastructureClass(beanClass)) {
            return null;
        }

        Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeanOfType(AspectJExpressionPointcutAdvisor.class).values();
        try {
            for (AspectJExpressionPointcutAdvisor advisor: advisors) {
                ClassFilter classFilter = advisor.getPointcut().getClassFilter();
                if (classFilter.matches(beanClass)) {
                    AdvisedSupport advisedSupport = new AdvisedSupport();
                    BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                    Object bean = beanFactory.getInstantiationStrategy().instantiate(beanDefinition);
                    TargetSource targetSource = new TargetSource(bean);
                    advisedSupport.setTargetSource(targetSource);
                    advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
                    advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
                    return new ProxyFactory(advisedSupport).getProxy();
                }
            }
        } catch (Exception e) {
            throw new BeansException("Error create proxy bean for: " + beanName, e);
        }
        return null;
    }

    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advice.class.isAssignableFrom(beanClass)
                || Pointcut.class.isAssignableFrom(beanClass)
                || Advisor.class.isAssignableFrom(beanClass);
    }
}

