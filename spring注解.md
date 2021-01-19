### 注解: https://blog.csdn.net/weixin_39805338/article/details/80770472



 @Configuration注解 

 该类等价 与XML中配置beans，相当于Ioc容器，它的某个方法头上如果注册了@Bean，就会作为这个Spring容器中的Bean，与xml中配置的bean意思一样 

 @Value注解  用法@Value(“${wx_appid}”)

为了简化从properties里取配置，可以使用@Value, 可以properties文件中的配置值。

 @Controller, @Service, @Repository,@Component 

目前4种注解意思是一样，并没有什么区别，区别只是名字不同。使用方法：

  @PostConstruct 和 @PreDestory  

bean的初始化和销毁

@PostConstruct：在构造方法和init方法（如果有的话）之间得到调用，且只会执行一次。

@PreDestory：注解的方法在destory()方法调用后得到执行。

引深一点，Spring 容器中的 Bean 是有生命周期的，Spring 允许在 Bean 在初始化完成后以及 Bean 销毁前执行特定的操作，常用的设定方式有以下三种：

1.通过实现 InitializingBean/DisposableBean 接口来定制初始化之后/销毁之前的操作方法；

2.通过 <bean> 元素的 init-method/destroy-method属性指定初始化之后 /销毁之前调用的操作方法；

3.在指定方法上加上@PostConstruct 或@PreDestroy注解来制定该方法是在初始化之后还是销毁之前调用

但他们之前并不等价。即使3个方法都用上了，也有先后顺序.

**Constructor > @PostConstruct >InitializingBean > init-method**

@Primary

自动装配时当出现多个Bean候选者时，被注解为@Primary的Bean将作为首选者，否则将抛出异常。

@Lazy(true)

  用于指定该Bean是否取消预初始化，用于注解类，延迟初始化。

 @Autowired

Autowired默认先按byType，如果发现找到多个bean，则，又按照byName方式比对，如果还有多个，则报出异常。

1.可以手动指定按byName方式注入，使用@Qualifier。

//通过此注解完成从spring配置文件中 查找满足Fruit的bean,然后按//@Qualifier指定pean

@Autowired

@Qualifier(“pean”)

public Fruit fruit;

2.如果要允许null 值，可以设置它的required属性为false，如：@Autowired(required=false) 

public Fruit fruit;

@Resource

默认按 byName自动注入,如果找不到再按byType找bean,如果还是找不到则抛异常，无论按byName还是byType如果找到多个，则抛异常。

可以手动指定bean,它有2个属性分别是name和type，使用name属性，则使用byName的自动注入，而使用type属性时则使用byType自动注入。

@Resource(name=”bean名字”)

或

@Resource(type=”bean的class”)

这个注解是属于J2EE的，减少了与spring的耦合。

 @Async 

线程

@Singleton

只要在类上加上这个注解，就可以实现一个单例类，不需要自己手动编写单例实现类。

 @Valid,@Valided 

全部参数校验如下：

空检查

@Null    验证对象是否为null

@NotNull  验证对象是否不为null, 无法查检长度为0的字符串

@NotBlank 检查约束字符串是不是Null还有被Trim的长度是否大于0,只对字符串,且会去掉前后空格.

@NotEmpty 检查约束元素是否为NULL或者是EMPTY.

 

Booelan检查

@AssertTrue   验证 Boolean 对象是否为 true 

@AssertFalse  验证 Boolean 对象是否为 false 

 

长度检查

@Size(min=, max=) 验证对象（Array,Collection,Map,String）长度是否在给定的范围之内 

@Length(min=, max=)验证注解的元素值长度在min和max区间内

日期检查

@Past      验证 Date 和 Calendar 对象是否在当前时间之前 

@Future   验证 Date 和 Calendar 对象是否在当前时间之后 

@Pattern  验证 String 对象是否符合正则表达式的规则

 

数值检查，建议使用在Stirng,Integer类型，不建议使用在int类型上，因为表单值为“”时无法转换为int，但可以转换为Stirng为”“,Integer为null

@Min(value=””)      验证 Number 和 String 对象是否大等于指定的值 

@Max(value=””)       验证 Number 和 String 对象是否小等于指定的值 

@DecimalMax(value=值) 被标注的值必须不大于约束中指定的最大值. 这个约束的参数是一个通过BigDecimal定义的最大值的字符串表示.小数存在精度

@DecimalMin(value=值) 被标注的值必须不小于约束中指定的最小值. 这个约束的参数是一个通过BigDecimal定义的最小值的字符串表示.小数存在精度

@Digits   验证 Number 和 String 的构成是否合法 

@Digits(integer=,fraction=)验证字符串是否是符合指定格式的数字，interger指定整数精度，fraction指定小数精度。

 

@Range(min=, max=) 检查数字是否介于min和max之间.

@Range(min=10000,max=50000,message=”range.bean.wage”)

private BigDecimal wage;

 

@Valid 递归的对关联对象进行校验, 如果关联对象是个集合或者数组,那么对其中的元素进行递归校验,如果是一个map,则对其中的值部分进行校验.(是否进行递归验证)

@CreditCardNumber信用卡验证

@Email 验证是否是邮件地址，如果为null,不进行验证，算通过验证。

@ScriptAssert(lang=,script=, alias=)

@URL(protocol=,host=,port=,regexp=, flags=)

@CrossOrigin 解决跨越 https://www.cnblogs.com/mmzs/p/9167743.html

是Cross-Origin ResourceSharing（跨域资源共享）的简写

  作用是解决跨域访问的问题，在Spring4.2以上的版本可直接使用。在类上或方法上添加该注解

@RequestParam

作用是提取和解析请求中的参数。@RequestParam支持类型转换，类型转换目前支持所有的基本Java类型

 **@PathVariable：**处理requet uri部分,当使用@RequestMapping URI template 样式映射时， 即someUrl/{paramId}, 这时的paramId可通过 @Pathvariable注解绑定它传过来的值到方法的参数上 

@RequestHeader，@CookieValue:** 处理request header部分的注解 

@Scope

配置bean的作用域。

默认是单例模式，即@Scope(“singleton”),

prototype：多对象，每一次请求都会产生一个新的bean实例，Spring不无法对一个prototype bean的整个生命周期负责，容器在初始化、配置、装饰或者是装配完一个prototype实例后，将它交给客户端，由程序员负责销毁该对象，不管何种作用域，容器都会调用所有对象的初始化生命周期回调方法，而对prototype而言，任何配置好的析构生命周期回调方法都将不会被调用

request：对每一次HTTP请求都会产生一个新的bean，同时该bean仅在当前HTTP request内有效

@ResponseStatus

@ResponseStatus用于修饰一个类或者一个方法，修饰一个类的时候，一般修饰的是一个异常类,当处理器的方法被调用时，@ResponseStatus指定的code和reason会被返回给前端。value属性是http状态码，比如404，500等。reason是错误信息

当修改类或方法时，只要该类得到调用，那么value和reason都会被添加到response里

@RestController

@RestController = @Controller + @ResponseBody。

是2个注解的合并效果，即指定了该controller是组件，又指定方法返回的是String或json类型数据，不会解决成jsp页面，注定不够灵活，如果一个Controller即有SpringMVC返回视图的方法，又有返回json数据的方法即使用@RestController太死板。



@Retention @Target @Document @Inherited四种

元注解是指注解的注解，比如我们看到的 ControllerAdvice 注解定义如下。

@Retention: 定义注解的保留策略：

@Retention(RetentionPolicy.SOURCE)  //注解仅存在于源码中，在class字节码文件中不包含

@Retention(RetentionPolicy.CLASS)   //默认的保留策略，注解会在class字节码文件中存在，但运行时无法获得，

@Retention(RetentionPolicy.RUNTIME) //注解会在class字节码文件中存在，在运行时可以通过反射获取到

@Target：定义注解的作用目标:

@Target(ElementType.TYPE)  //接口、类、枚举、注解

@Target(ElementType.FIELD) //字段、枚举的常量

@Target(ElementType.METHOD) //方法

@Target(ElementType.PARAMETER) //方法参数

@Target(ElementType.CONSTRUCTOR) //构造函数

@Target(ElementType.LOCAL_VARIABLE)//局部变量

@Target(ElementType.ANNOTATION_TYPE)//注解

@Target(ElementType.PACKAGE) ///包  

 由以上的源码可以知道，他的elementType 可以有多个，一个注解可以为类的，方法的，字段的等等

@Document：说明该注解将被包含在javadoc中

@Inherited：说明子类可以继承父类中的该注解