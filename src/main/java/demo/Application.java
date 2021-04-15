package demo;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yuejia
 * @datetime: 2021/4/15 10:54
 */
@RestController
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("echo")
    public String echo(@RequestBody String content) {
        return content;
    }

    @RequestMapping("reverse")
    public static String reverse(@RequestBody String content) {
        if (content == null || content.length() == 1) return content;
        char[] chars = content.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char head = chars[i];
            char tail = chars[chars.length - i - 1];

            chars[i] = tail;
            chars[chars.length - i - 1] = head;
        }
        return new String(chars);
    }


    @Test
    public void reverseTest() throws Exception {
        Assert.assertEquals(reverse("abcd"), "dcba");
        Assert.assertEquals(reverse("abcde"), "edcba");
    }
}
