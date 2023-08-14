package java.com.appleyk.demoController;

import com.appleyk.entity.SumNumDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.lang.reflect.Field;

@RestController
public class CalNumSumController {


    @PostMapping("/add")
    public Integer calNum(@RequestBody SumNumDto sumNumDto) {
        int num1 = sumNumDto.getNum1();
        int num2 = sumNumDto.getNum2();
        int sum = sumNumDto.getNum1() + sumNumDto.getNum2();
        //save
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("num1:").append(num1).append("num2:").append(num2).append("sum :").append(sum);
        writeReport(stringBuilder.toString(),"C:\\Users\\王圣辉\\Desktop\\sum.txt");
        return sumNumDto.getNum1() + sumNumDto.getNum2();
    }


    public static void writeReport(String content, String filePath) {
        BufferedWriter out = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            //编码格式可自己更换
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(filePath, true), "UTF-8"));
            out.write(content + "\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();

            } catch (IOException e) {
                e.printStackTrace();

            }
        }

    }

}
