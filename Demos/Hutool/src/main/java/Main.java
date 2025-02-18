import cn.hutool.core.io.resource.ClassPathResource;

public class Main {



    public static void main(String[] args) {
        ClassPathResource classPathResource = new ClassPathResource("");
        System.out.println(classPathResource.getAbsolutePath());
    }

}
