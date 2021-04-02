## spring源码第一节

**1.初始化spring**

```java

```

##### 2.AnnotationConfigApplicationContext  注释配置应用程序上下文

（1）入口

```java
    //注释配置应用程序上下文
AnnotationConfigApplicationContext applicationContext = new          AnnotationConfigApplicationContext(Appconfig.class)
	public AnnotationConfigApplicationContext(Class... componentClasses) {
    	//1
        this();//调用父类构造方法 AnnotationConfigApplicationContext
        //2
    	this.register(componentClasses);
        //3
    	this.refresh();
    }
	1.1
    public AnnotationConfigApplicationContext() {
        //1.1.1
        //创建一个读取注解的bean定义读取器
        this.reader = new AnnotatedBeanDefinitionReader(this);
         //1.1.2
        this.scanner = new ClassPathBeanDefinitionScanner(this);
    }
1.1.1 带注释的Bean定义读取器
public class AnnotatedBeanDefinitionReader {
    private final BeanDefinitionRegistry registry;
    private BeanNameGenerator beanNameGenerator;
    private ScopeMetadataResolver scopeMetadataResolver;
    private ConditionEvaluator conditionEvaluator;

    public AnnotatedBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, getOrCreateEnvironment(registry));
    }

    public AnnotatedBeanDefinitionReader(BeanDefinitionRegistry registry, Environment environment) {
        this.beanNameGenerator = AnnotationBeanNameGenerator.INSTANCE;
        this.scopeMetadataResolver = new AnnotationScopeMetadataResolver();
        Assert.notNull(registry, "BeanDefinitionRegistry must not be null");
        Assert.notNull(environment, "Environment must not be null");
        this.registry = registry;
        this.conditionEvaluator = new ConditionEvaluator(registry, environment, (ResourceLoader)null);
        AnnotationConfigUtils.registerAnnotationConfigProcessors(this.registry);
}

```

![]()

![image-20210402164547949](C:\Users\Chinadaas\test\factorystrategy\src\main\java\com\wjl\strategyfactory\spring1\image\1617353193.jpg)