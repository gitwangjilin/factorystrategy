package com.wjl.strategyfactory.spring.test;

import com.wjl.strategyfactory.spring.app.Appconfig;
import com.wjl.strategyfactory.spring.dao.IndexDao;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AutowireCandidateResolver;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.lang.ref.Reference;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*************************************************************************
 ******
 * - Copyright (c) 2021 redshield.com
 * - File Name: SpringTest
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/1/10   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class SpringTest {
    public static void main(String[] args) {
        /**
         *AnnotationConfigApplicationContext extends GenericApplicationContext  继承父类
         * GenericApplicationContext
         *  DefaultListableBeanFactory工厂集合
         *
         */
        //初始化bean
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IndexDao.class);
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(IndexDao.class);
        applicationContext.refresh();
        IndexDao bean = applicationContext.getBean(IndexDao.class);
        bean.query();
    }
/*  DefaultListableBeanFactory
    @Nullable
    private static Class<?> javaxInjectProviderClass;
    private static final Map<String, Reference<DefaultListableBeanFactory>> serializableFactories;
    @Nullable
    private String serializationId;
    private boolean allowBeanDefinitionOverriding = true;
    private boolean allowEagerClassLoading = true;
    @Nullable
    private Comparator<Object> dependencyComparator; 排序作用
    private AutowireCandidateResolver autowireCandidateResolver;
    private final Map<Class<?>, Object> resolvableDependencies;
    private final Map<String, BeanDefinition> beanDefinitionMap; 将类转换成bean
    private final Map<String, BeanDefinitionHolder> mergedBeanDefinitionHolders;
    private final Map<Class<?>, String[]> allBeanNamesByType;
    private final Map<Class<?>, String[]> singletonBeanNamesByType;
    private volatile List<String> beanDefinitionNames;  类的名字
    private volatile Set<String> manualSingletonNames;
    @Nullable
    private volatile String[] frozenBeanDefinitionNames;
    private volatile boolean configurationFrozen;*/
}
