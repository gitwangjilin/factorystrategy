## spring源码1

AnnotationConfigApplicationContext（测试化环境） 继承 GenericApplicationContext 



AnnotatedBeanDefinitionReader 读取被加了注解的类别实例化的

ClassPathBeanDefinitionScanner 扫描实例化bean

BeanDefinitionRegistry 注册器（将类转换成spring识别的key-value）

BeanDefinition 描述bean

Annotated 注解

processCommonDefinitionAnnotations 校验是否加了注解

BeanDefinitionHolder

applicationContext.refresh();

this.prepareBeanFactory(beanFactory); 注册和扩展

beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this)); 添加一个后置处理器

ApplicationContextAwareProcessor 继承BeanPostProcessor（接口）： 后置处理器

BeanPostProcessor：

​	是spring  

### 第三节

nomal

importSelect

ImportBeanDefinitionRegistrat



@MapperScan(把接口变成一个对象，在spring容器中) 扫描mapper

### 第四节  

判断当前bd中存在的类是不是加了@Configruation注解

如果存在spring认为是**全注解**

isFullConfigurationCandidate

​	设置为full

判断是否加了以下注解 为isLite

component  componentscan  import   importresource

不存在configuration注解。spring则认为是一个**部分注解类**

isLiteConfigurationCandidate

```java
指定配置文件
//@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:sysconfig.yml")
```