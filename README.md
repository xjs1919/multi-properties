# multi-properties
SpringBoot引入多个配置文件

## 1.自定义EnvironmentPostProcessor的实现类，在回调中加载自定义的配置文件
## 2.在META-INF/spring.factories中添加配置：
org.springframework.boot.env.EnvironmentPostProcessor=com.github.xujsh.springboot.config.EnvPostProcessor
