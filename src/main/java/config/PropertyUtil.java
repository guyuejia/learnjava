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
    public static String getProperties1(String name){
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
    //第二种方法，直接采用文件流的方法读取配置文件的路径
    public static String getProperties2(String name){
        logger.info("执行开始");
        Properties properties = new Properties();
        String propFileName = "src/resource/config.properties";
        //使用类加载器读取文件，执行main方法报空指针，但是中间件加载执行正常
        InputStream in = PropertyUtil.class.getResourceAsStream(propFileName);
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("执行结束"+properties.getProperty(name));
        return properties.getProperty(name);
    }
    public static void main(String[] args) {
        System.out.println(getProperties2("name"));
    }

}
