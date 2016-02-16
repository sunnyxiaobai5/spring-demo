/*******************************************************************************
 * sunnyxiaobai5@gmail.com
 * <p>
 * <li>项目名称: spring-data-demo</li>
 * <li>完整包名: com.sunnyxiaobai5</li>
 * <li>文件名称: Application.java</li>
 * <li>内容摘要: </li>
 * <li>内容描述: </li>
 * <li>其他说明: </li>
 * <li>@author Xiangyong Zeng</li>
 ******************************************************************************/
package com.sunnyxiaobai5;

import com.sunnyxiaobai5.config.ApplicationProperties;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * Project: spring-data-demo
 * Package: com.sunnyxiaobai5.web
 * Title:   描述
 * Author:  Xiangyong Zeng
 * Date:    2015/10/12 16:02
 * Version: 1.0
 */

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackages = "com.sunnyxiaobai5")
//@ComponentScan
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan (main class 在root package的时候)
@EnableConfigurationProperties(ApplicationProperties.class) //多个类以“,”分割
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

//        SpringApplication app = new SpringApplication(Application.class);

//        Sets if the Spring banner should be displayed when the application runs. Defaults to true.
//        设置启动时是否显示Spring banner（命令行最开始部分）,默认为显示
//        若在properties文件中配置spring.main.show-banner=true/false，将以properties文件配置为准
//        app.setShowBanner(true);
//        app.run(args);
    }

    Logger Log= LoggerFactory.getLogger(this.getClass());

    @Bean
    public CommandLineRunner init(final RepositoryService repositoryService,
                                  final RuntimeService runtimeService,
                                  final TaskService taskService) {

        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                Log.info("【Activiti】Number of process definitions:" + repositoryService.createProcessDefinitionQuery().count());
                Log.info("【Activiti】Number of process Instances:" + runtimeService.createProcessInstanceQuery().count());
            }
        };

    }
}
