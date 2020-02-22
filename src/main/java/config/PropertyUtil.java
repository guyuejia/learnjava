package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertyUtil {
    static Logger logger =Logger.getLogger("Client");
    //第一种方法，直接采用文件流的方法读取配置文件的路径
    public static String getPropertiesByPath(String name){
        logger.info("执行开始");
        Properties properties = new Properties();
        //使用文件流读取，执行main方法和中间件加载执行正常
        File file = new File("C:\\Users\\hushishuai\\IdeaProjects\\learnjava\\src\\resource\\config.properties");
        try {
            InputStream in = new FileInputStream(file);
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("执行结束"+properties.getProperty(name));
        return properties.getProperty(name);
    }
    //第二种方法推荐，直接从classpath读取配置文件,该配置文件需要放在resource目录下
    public static String getPropertiesByClasspath(String name){
        logger.info("执行开始");
        Properties properties = new Properties();
        String propFileName = "config.properties";
        //使用类加载器读取文件，前提是要把配置文件所在目录设置为resource类型
        InputStream in = PropertyUtil.class.getClassLoader().getResourceAsStream(propFileName);
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("执行结束"+properties.getProperty(name));
        //打印出配置文件中的所有配置项的名称
        System.out.println(properties.keySet());
        return properties.getProperty(name);
    }
    public static void main(String[] args) {
        System.out.println(getPropertiesByClasspath("name"));
    }

}
