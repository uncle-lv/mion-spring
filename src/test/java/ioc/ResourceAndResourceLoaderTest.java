package ioc;

import cn.hutool.core.io.IoUtil;
import io.DefaultResourceLoader;
import io.FileSystemResource;
import io.Resource;
import io.UrlResource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ResourceAndResourceLoaderTest {

    @Test
    public void testResourceLoader() throws Exception {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

        Resource resource = resourceLoader.getResource("classpath:hello.txt");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        Assertions.assertEquals("Hello, World!", content);

        resource = resourceLoader.getResource("src/test/resources/hello.txt");
        Assertions.assertTrue(resource instanceof FileSystemResource);
        inputStream = resource.getInputStream();
        content = IoUtil.readUtf8(inputStream);
        Assertions.assertEquals("Hello, World!", content);

        resource = resourceLoader.getResource("https://github.com/uncle-lv/mion-spring/blob/main/README.md");
        Assertions.assertTrue(resource instanceof UrlResource);
        inputStream = resource.getInputStream();
        content = IoUtil.readUtf8(inputStream);
        System.out.println(content);

        Assertions.assertThrows(FileNotFoundException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Resource resource = resourceLoader.getResource("classpath:test.txt");
                InputStream inputStream = resource.getInputStream();
            }
        });
    }
}
