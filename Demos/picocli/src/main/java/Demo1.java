import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;


@Command
// 1. 需要实现 Runnable/Callable
public class Demo1 implements Runnable {

    // 2. Option注解指定选项（通常用于非必须的可选项，在names后引出）
    @Option(names = "-o")
    String operator;

    // 3. 支持多值(多次-n)
    @Option(names = "-n")
    int[] operand;

    // 4. 实现run方法，在里面写具体逻辑
    @Override
    public void run() {
        System.out.println(operand[0] + operator + operand[1] + "=?");
    }

    // 5. main函数中，新建对象，传入新的CommandLine，执行其execute方法
    public static void main(String[] args) {
        String[] myArgs = new String[]{"-o", "+", "-n", "1", "-n","2"};
        Demo1 demo = new Demo1();
        CommandLine commandLine = new CommandLine(demo);
        commandLine.execute(myArgs);
    }
}