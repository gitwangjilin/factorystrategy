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

beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this)); 扩展入口

ApplicationContextAwareProcessor 继承BeanPostProcessor： 后置处理器

