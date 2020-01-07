package logusage;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @Author: gujiayue
 * @Description:介绍log4j日志模块的用法
 * @Date: Created in 16:47 2020/1/2
 * @Modified By:
 */
public class Log4jUsage {
    private static Logger logger = Logger.getLogger(Log4jUsage.class);

    public static void main(String[] args) {
        //如果想要手动加载配置文件，该文件必须放在项目根目录下
        //PropertyConfigurator.configure("log4j.properties");

        //log4j包默认是自动加载的，类加载器的方式去classpath目录下加载
        System.out.println(logger);
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");

    }
}
