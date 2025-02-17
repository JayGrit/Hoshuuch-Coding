import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

// 6. name起个名字，
//    version指示版本号，
//    mixinStandardHelpOptions自动生成--help和--version
@Command(name="calculater",version="0.0.1",mixinStandardHelpOptions = true)
public class Demo2 implements Runnable {

    // 7. 可以指定多个名字,
    //    required要求必须输入，
    //    description描述，显示在help信息中
    //    interactive要求交互式输入 (interactive + arity="0..1" 可以实现交互式/直接式传参)
    //    echo在jar运行环境中不隐藏输入
    //    prompt指定提示信息

    @Option(names = {"-o","--operator"},required = true,description = "Specify the operator",interactive = true,prompt = "请输入运算符",echo=true)
    String operator;

    // 8. arity指定多值情况下的个数(无需重复-n)
    @Option(names = "-n",arity="2")
    int[] operand;


    // 9. Parameters注解指定位置参数（通常用于必填的顺序敏感的参数，不需要引出，在相应位置键入）
    //    paramLabel类似描述，显示在help中
    @Parameters(paramLabel = "message",defaultValue = "The Calculator")
    String message;


    @Override
    public void run() {
        System.out.println(message);
        System.out.println(operand[0] + operator + operand[1] + "=?");
    }


    // 10. execute 返回一个退出代码，可以用于向调用方表示成功或失败
    public static void main(String[] args) {
        String[] myArgs = new String[]{"-o","-n","1","2","Here are the calculate:"};
        int exitCode = new CommandLine(new Demo2()).execute(myArgs);
        System.exit(exitCode);
    }
}
