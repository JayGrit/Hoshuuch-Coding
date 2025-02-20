import java.io.*;

public class TerminalRunner {

    public static void run(String command) throws IOException, InterruptedException {
        String projectPath = System.getProperty("user.dir");

        // ProcessBuilder 类用来创建和关系系统进程(Progress)
        // ProcessBuilder 接受字符串列表，故首先对命令进行拆解
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));

        // 设定该进程运行的目录
        processBuilder.directory(new File(projectPath));

        // 通过调用start()方法启动一个新的进程
        Process process = processBuilder.start();

        // Java两类字节流 InputStream、OutputStream
        // 值得注意的是，这里的IO以Java为核心，Input->Java->Output
        // 获取进程的输出流(作为Java的输入流)
        InputStream inputStream = process.getInputStream();

        // InputStreamReader 将字节流转化为字符流
        // BufferedReader 实现高效读取字符流(意味着可以不用，但性能会较差)
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        // 从缓冲区打印数据
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        // 待进程运行结束再继续执行代码
        int exitCode = process.waitFor();

        // 0->成功 1->失败
        System.out.println("Exit code: " + exitCode);
    }

}
