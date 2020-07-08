package testRhino;

import javax.annotation.processing.Filer;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * @author 张辉
 * @Description 测试脚本引擎执行javascript代码
 * @create 2020-07-07 20:09
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        // 获得脚本引擎对象
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");

        // 定义变量，存储到引擎上下文中，
        engine.put("msg", "zhangsan is a good man!");
        String str = "var user = {name: 'zhangsan', age:19, schools: ['清华大学','北京大学']};";
        str += "print(user.name)";

        // 执行脚本
        engine.eval(str);
        engine.eval("msg = 'zhangsan is a good man';");
        System.out.println(engine.get("msg"));
        System.out.println("##############################");


        // 定义js函数
        engine.eval("function add(a,b) {var sum = a + b; return sum;}");
         // 取得调用接口
        Invocable jsInvoke = (Invocable)engine;
        // 执行js脚本中定义的方法
        Object result = jsInvoke.invokeFunction("add", new Object[]{10,29});
        System.out.println(result);



        // 导入其他的java包，使用其他的Java类
        //String jsCode = "importPackage(java.util); var list = Arrays.asList([\"北京大学\",\"清华大学\"]);";
        //engine.eval(jsCode);
        //List<String> list2 = (List<String>) engine.get("list");
        //
        //for (String tmp: list2) {
        //    System.out.println(tmp);
        //}



        // 执行一个js文件（我们将a.js文件至于项目的src下即可）
        //URL url = Demo01.class.getClassLoader().getResource("testRhino/a.js");
        //FileReader fr = new FileReader(url.getPath());
        //engine.eval(fr);
        //fr.close(); // 由于只是测试，实际中必须要用try

    }
}
