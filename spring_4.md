### 初始化spring环境

```java
AnnotationConfigApplicationContext applicationContext = new  AnnotationConfigApplicationContext();

```

GenericApplicationContext类中 的 GenericApplicationContext方法

  1.调用父类中的DefaultListableBeanFactory（实例化工厂）

```java
  @Nullable
    private static Class<?> javaxInjectProviderClass;
    private static final Map<String, Reference<DefaultListableBeanFactory>> serializableFactories;
    @Nullable
    private String serializationId;
    private boolean allowBeanDefinitionOverriding = true;
    private boolean allowEagerClassLoading = true;
    @Nullable
    private Comparator<Object> dependencyComparator;  （排序）
    private AutowireCandidateResolver autowireCandidateResolver;（延迟加载）
    private final Map<Class<?>, Object> resolvableDependencies;
    private final Map<String, BeanDefinition> beanDefinitionMap;（放bean的名字和bean的描述）
    private final Map<String, BeanDefinitionHolder> mergedBeanDefinitionHolders;
    private final Map<Class<?>, String[]> allBeanNamesByType;
    private final Map<Class<?>, String[]> singletonBeanNamesByType;
    private volatile List<String> beanDefinitionNames;（放bean的名字集合）
    private volatile Set<String> manualSingletonNames;
    @Nullable
    private volatile String[] frozenBeanDefinitionNames;
    private volatile boolean configurationFrozen;
```

```
this.reader = new AnnotatedBeanDefinitionReader(this); 2   createAnnotatedBeanDefReader.end();   
this.scanner = new ClassPathBeanDefinitionScanner(this);3
```

2.AnnotationConfigApplicationContext 类的AnnotationConfigApplicationContext方法

2.1AnnotatedBeanDefinitionReader(读取器加了注解的，将类转换给DefaultListableBeanFactory)

```java
public class AnnotatedBeanDefinitionReader {   
    private final BeanDefinitionRegistry registry;（注册器）    
    private BeanNameGenerator beanNameGenerator;    
    private ScopeMetadataResolver scopeMetadataResolver;    
    private ConditionEvaluator conditionEvaluator;    
```

2.2.AnnotatedBeanDefinitionReader类中的 AnnotatedBeanDefinitionReader

```
public class AnnotatedBeanDefinitionReader {    
	private final BeanDefinitionRegistry registry;    
	private BeanNameGenerator beanNameGenerator;    
	private ScopeMetadataResolver scopeMetadataResolver;    
	private ConditionEvaluator conditionEvaluator;
```

2.3.AnnotationConfigUtils 类中的 registerAnnotationConfigProcessors---**registerAnnotationConfigProcessors**（1.排序。2.延迟加载。）

```java
    public static Set<BeanDefinitionHolder> registerAnnotationConfigProcessors(BeanDefinitionRegistry registry, @Nullable Object source) {
        DefaultListableBeanFactory beanFactory = unwrapDefaultListableBeanFactory(registry);（是整个bean加载的核心部分，是 Spring 注册及加载 bean 的默认实现。）
             //排序
        if (beanFactory != null) {
            if (!(beanFactory.getDependencyComparator() instanceof AnnotationAwareOrderComparator)) {
               beanFactory.setDependencyComparator(AnnotationAwareOrderComparator.INSTANCE);
            }
//延迟加载
            if (!(beanFactory.getAutowireCandidateResolver() instanceof ContextAnnotationAutowireCandidateResolver)) {
                beanFactory.setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver());
            }
        }
//BeanDefinitionHolder 方便传参
        Set<BeanDefinitionHolder> beanDefs = new LinkedHashSet(8);
        RootBeanDefinition def;
        //BeanDefinition 的注册，需要解析注册每个bean类型
        if (!registry.containsBeanDefinition("org.springframework.context.annotation.internalConfigurationAnnotationProcessor")) {
            //ConfigurationClassPostProcessor 的类型是BeanDefinitionRegistryPostProcessor
            //BeanDefinitionRegistryPostProcessor最终实现BeanFactoryPostProcessor这个接口
            def = new RootBeanDefinition(ConfigurationClassPostProcessor.class);
            def.setSource(source);
            //registerPostProcessor 这个方法注册进入
            beanDefs.add(registerPostProcessor(registry, def, "org.springframework.context.annotation.internalConfigurationAnnotationProcessor"));
        }
//注册所需要的类
        if (!registry.containsBeanDefinition("org.springframework.context.annotation.internalAutowiredAnnotationProcessor")) {
            def = new RootBeanDefinition(AutowiredAnnotationBeanPostProcessor.class);
            def.setSource(source);
            beanDefs.add(registerPostProcessor(registry, def, "org.springframework.context.annotation.internalAutowiredAnnotationProcessor"));
        }
//注册所需要的类
        if (jsr250Present && !registry.containsBeanDefinition("org.springframework.context.annotation.internalCommonAnnotationProcessor")) {
            def = new RootBeanDefinition(CommonAnnotationBeanPostProcessor.class);
            def.setSource(source);
            beanDefs.add(registerPostProcessor(registry, def, "org.springframework.context.annotation.internalCommonAnnotationProcessor"));
        }
//注册所需要的类
        if (jpaPresent && !registry.containsBeanDefinition("org.springframework.context.annotation.internalPersistenceAnnotationProcessor")) {
            def = new RootBeanDefinition();

            try {
                def.setBeanClass(ClassUtils.forName("org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor", AnnotationConfigUtils.class.getClassLoader()));
            } catch (ClassNotFoundException var6) {
                throw new IllegalStateException("Cannot load optional framework class: org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor", var6);
            }

            def.setSource(source);
            beanDefs.add(registerPostProcessor(registry, def, "org.springframework.context.annotation.internalPersistenceAnnotationProcessor"));
        }

        if (!registry.containsBeanDefinition("org.springframework.context.event.internalEventListenerProcessor")) {
            def = new RootBeanDefinition(EventListenerMethodProcessor.class);
            def.setSource(source);
            beanDefs.add(registerPostProcessor(registry, def, "org.springframework.context.event.internalEventListenerProcessor"));
        }

        if (!registry.containsBeanDefinition("org.springframework.context.event.internalEventListenerFactory")) {
            def = new RootBeanDefinition(DefaultEventListenerFactory.class);
            def.setSource(source);
            beanDefs.add(registerPostProcessor(registry, def, "org.springframework.context.event.internalEventListenerFactory"));
        }

        return beanDefs;
    }
```

3.ClassPathBeanDefinitionScanner  扫描一个类、包并且转换成bd

**BeanFactoryPostProcessor**可插上springbean工厂

**BeanDefinitionRegistryPostProcessor** 实现 **BeanFactoryPostProcessor**

AbstractApplicationContext类中的 refresh 准备好bean工厂

     public static void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory, List<BeanFactoryPostProcessor> beanFactoryPostProcessors) {
            Set<String> processedBeans = new HashSet();
            ArrayList regularPostProcessors;
            ArrayList registryProcessors;
            int var9;
            ArrayList currentRegistryProcessors;
            String[] postProcessorNames;
            //注解不走这里，手动new走
            if (beanFactory instanceof BeanDefinitionRegistry) {
                BeanDefinitionRegistry registry = (BeanDefinitionRegistry)beanFactory;
                regularPostProcessors = new ArrayList();
                registryProcessors = new ArrayList();
                Iterator var6 = beanFactoryPostProcessors.iterator();
    
                while(var6.hasNext()) {
                    BeanFactoryPostProcessor postProcessor = (BeanFactoryPostProcessor)var6.next();
                    if (postProcessor instanceof BeanDefinitionRegistryPostProcessor) {
                        BeanDefinitionRegistryPostProcessor registryProcessor = (BeanDefinitionRegistryPostProcessor)postProcessor;
                        registryProcessor.postProcessBeanDefinitionRegistry(registry);
                        registryProcessors.add(registryProcessor);
                    } else {
                        regularPostProcessors.add(postProcessor);
                    }
                }
    
                currentRegistryProcessors = new ArrayList();
                postProcessorNames = beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false);
                String[] var16 = postProcessorNames;
                var9 = postProcessorNames.length;
    
                int var10;
                String ppName;
                for(var10 = 0; var10 < var9; ++var10) {
                    ppName = var16[var10];
                    if (beanFactory.isTypeMatch(ppName, PriorityOrdered.class)) {
                        currentRegistryProcessors.add(beanFactory.getBean(ppName, BeanDefinitionRegistryPostProcessor.class));
                        processedBeans.add(ppName);
                    }
                }
    
                sortPostProcessors(currentRegistryProcessors, beanFactory);
                registryProcessors.addAll(currentRegistryProcessors);
                invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry, beanFactory.getApplicationStartup());
                currentRegistryProcessors.clear();
                postProcessorNames = beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false);
                var16 = postProcessorNames;
                var9 = postProcessorNames.length;
    
                for(var10 = 0; var10 < var9; ++var10) {
                    ppName = var16[var10];
                    if (!processedBeans.contains(ppName) && beanFactory.isTypeMatch(ppName, Ordered.class)) {
                        currentRegistryProcessors.add(beanFactory.getBean(ppName, BeanDefinitionRegistryPostProcessor.class));
                        processedBeans.add(ppName);
                    }
                }
    
                sortPostProcessors(currentRegistryProcessors, beanFactory);
                registryProcessors.addAll(currentRegistryProcessors);
                invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry, beanFactory.getApplicationStartup());
                currentRegistryProcessors.clear();
                boolean reiterate = true;
    
                while(reiterate) {
                    reiterate = false;
                    postProcessorNames = beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false);
                    String[] var19 = postProcessorNames;
                    var10 = postProcessorNames.length;
    
                    for(int var26 = 0; var26 < var10; ++var26) {
                        String ppName = var19[var26];
                        if (!processedBeans.contains(ppName)) {
                            currentRegistryProcessors.add(beanFactory.getBean(ppName, BeanDefinitionRegistryPostProcessor.class));
                            processedBeans.add(ppName);
                            reiterate = true;
                        }
                    }
    
                    sortPostProcessors(currentRegistryProcessors, beanFactory);
                    registryProcessors.addAll(currentRegistryProcessors);
                    invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry, beanFactory.getApplicationStartup());
                    currentRegistryProcessors.clear();
                }
    
                invokeBeanFactoryPostProcessors((Collection)registryProcessors, (ConfigurableListableBeanFactory)beanFactory);
                invokeBeanFactoryPostProcessors((Collection)regularPostProcessors, (ConfigurableListableBeanFactory)beanFactory);
            } else {
                invokeBeanFactoryPostProcessors((Collection)beanFactoryPostProcessors, (ConfigurableListableBeanFactory)beanFactory);
            }
    
            String[] postProcessorNames = beanFactory.getBeanNamesForType(BeanFactoryPostProcessor.class, true, false);
            regularPostProcessors = new ArrayList();
            registryProcessors = new ArrayList();
            currentRegistryProcessors = new ArrayList();
            postProcessorNames = postProcessorNames;
            int var20 = postProcessorNames.length;
    
            String ppName;
            for(var9 = 0; var9 < var20; ++var9) {
                ppName = postProcessorNames[var9];
                if (!processedBeans.contains(ppName)) {
                    if (beanFactory.isTypeMatch(ppName, PriorityOrdered.class)) {
                        regularPostProcessors.add(beanFactory.getBean(ppName, BeanFactoryPostProcessor.class));
                    } else if (beanFactory.isTypeMatch(ppName, Ordered.class)) {
                        registryProcessors.add(ppName);
                    } else {
                        currentRegistryProcessors.add(ppName);
                    }
                }
            }
    
            sortPostProcessors(regularPostProcessors, beanFactory);
            invokeBeanFactoryPostProcessors((Collection)regularPostProcessors, (ConfigurableListableBeanFactory)beanFactory);
            List<BeanFactoryPostProcessor> orderedPostProcessors = new ArrayList(registryProcessors.size());
            Iterator var21 = registryProcessors.iterator();
    
            while(var21.hasNext()) {
                String postProcessorName = (String)var21.next();
                orderedPostProcessors.add(beanFactory.getBean(postProcessorName, BeanFactoryPostProcessor.class));
            }
    
            sortPostProcessors(orderedPostProcessors, beanFactory);
            invokeBeanFactoryPostProcessors((Collection)orderedPostProcessors, (ConfigurableListableBeanFactory)beanFactory);
            List<BeanFactoryPostProcessor> nonOrderedPostProcessors = new ArrayList(currentRegistryProcessors.size());
            Iterator var24 = currentRegistryProcessors.iterator();
    
            while(var24.hasNext()) {
                ppName = (String)var24.next();
                nonOrderedPostProcessors.add(beanFactory.getBean(ppName, BeanFactoryPostProcessor.class));
            }
    
            invokeBeanFactoryPostProcessors((Collection)nonOrderedPostProcessors, (ConfigurableListableBeanFactory)beanFactory);
            beanFactory.clearMetadataCache();
        }

### 类描述

**beanDefinition** 放bean的名字和bean的描述

**BeanNameGenerator** 为某个bean生成名字，参数为BeanDefinition 和 BeanDefinitionRegistry 类型。此处可以反映出spring需要的bean结构是BeanDefinition。 

**BeanDefinitionHolder** 实现了BeanMetadataElement接口*

**AnnotatedBeanDefinitionReader** 读取器加了注解的，将类转换给DefaultListableBeanFactory)

**BeanFactoryPostProcessor**可插上springbean工厂

**sortPostProcessors** 排序

### 注解

#### 将自己的类交给spring建设

1.加注解ComponentScan   				需要类

2.直接注入类						 				需要类

3.ImportBeanDefinitionRegistrar

@MapperScan（）将接口变成对象，放在spring中

@ComponentScan主要就是定义**扫描的路径**从中找出标识了**需要装配**的类自动装配到spring的bean容器中



### @Configuration



1、import直接填class数组方式
2、ImportSelector方式【重点】
3、ImportBeanDefinitionRegistrar方式 

```
org.springframework.context.annotation.ConfigurationClassPostProcessor类中的enhanceConfigurationClasses
```