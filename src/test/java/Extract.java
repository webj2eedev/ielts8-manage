import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
public class Extract {
    @Test
    public void regex(){
        Pattern p = Pattern.compile("解析：([A-Z]+)");
        String s = "解析：C《工会新旧会计制度有关衔接问题的处理规定》代管经费是指其他组织委托工会代管的有指定用途的、不属于工会收入的资金，如代管的社团活动费、职工互助保险等。代管经费要严格按照资金的用途使用，并严格履行规定的报批程序。属于收入性质业务范畴的，如工会收到的各种救灾、救助捐赠款项，需统一调配使用的，不应在代管经费中核算，要计入工会收入，纳入工会预算收支统一管理。";
        Matcher m = p.matcher(s);
        m.find();
        String a = m.group(1);
        System.out.println(a);
    }
    @Test
    public void regex2(){
        System.out.println("A. 宏观全面".matches("[A-Z].[\\S\\s]+"));
    }

    @Test
    public void extract01() throws IOException, JSONException {
        // 正文
        // 选项
        // 答案
        // 解析
        ClassPathResource cpr = new ClassPathResource("0100-07-1会计制度-衔接单选（定稿）20题.txt");
        byte[] bytes = IOUtils.toByteArray(cpr.getInputStream());
        String text = new String(bytes, StandardCharsets.UTF_8);

        String[] questions = text.trim().split("\\d+、");
        System.out.println("题目总量:"+questions.length);

        JSONArray table = new JSONArray();
        for (int i = 0; i < questions.length; i++) {
            String q = questions[i].trim();
            if(q == null || q.equals("")){
                continue;
            }
            String[] lines = q.split("\\r\\n");
            if(lines.length != 3){
                throw new RuntimeException("Question["+(i)+"][\n\n\n"+q+"\n\n\n]分割异常【"+lines.length+"】");
            }

            JSONObject o = new JSONObject();
            o.put("正文", lines[0].trim());
            o.put("选项", lines[1].trim());

            try {
                Pattern p = Pattern.compile("解析：\\s*([A-Z]+)");
                String s = lines[2].trim();
                Matcher m = p.matcher(s);
                m.find();
                String a = m.group(1);
                o.put("答案", a);
            }catch(IllegalStateException ex){
                throw new RuntimeException("答案抽取异常：[\n\n\n"+lines[2].trim()+"]\n\n\n");
            }

            o.put("解析", lines[2].trim());
            table.put(o);
        }

        FileOutputStream fos = new FileOutputStream("001.json");
        fos.write(table.toString().getBytes(StandardCharsets.UTF_8));
        fos.close();
    }

    @Test
    public void extract02() throws IOException, JSONException {
        // 正文
        // 选项
        // 答案
        // 解析
        ClassPathResource cpr = new ClassPathResource("0100-07-2会计制度-衔接判断（定稿）76题.txt");
        byte[] bytes = IOUtils.toByteArray(cpr.getInputStream());
        String text = new String(bytes, StandardCharsets.UTF_8);

        String[] questions = text.trim().split("\\d+、");
        System.out.println("题目总量:"+questions.length);

        JSONArray table = new JSONArray();
        for (int i = 0; i < questions.length; i++) {
            String q = questions[i].trim();
            if(q == null || q.equals("")){
                continue;
            }
            String[] lines = q.split("\\r\\n");
            if(lines.length != 2){
                throw new RuntimeException("Question["+(i)+"][\n\n\n"+q+"\n\n\n]分割异常【"+lines.length+"】");
            }

            JSONObject o = new JSONObject();
            o.put("正文", lines[0].trim());
            try {
                Pattern p = Pattern.compile("解析：\\s*((正确)|(错误))");
                String s = lines[1].trim();
                Matcher m = p.matcher(s);
                m.find();
                String a = m.group(1);
                o.put("答案", a);
            }catch(IllegalStateException ex){
                throw new RuntimeException("答案抽取异常：[\n\n\n"+lines[2].trim()+"]\n\n\n");
            }

            o.put("解析", lines[1].trim());
            table.put(o);
        }

        FileOutputStream fos = new FileOutputStream("002.json");
        fos.write(table.toString().getBytes(StandardCharsets.UTF_8));
        fos.close();
    }

    @Test
    public void extract03() throws IOException, JSONException {
        // 正文
        // 选项
        // 答案
        // 解析
        ClassPathResource cpr = new ClassPathResource("0100-07-3会计制度-衔接多选（定稿）59题.txt");
        byte[] bytes = IOUtils.toByteArray(cpr.getInputStream());
        String text = new String(bytes, StandardCharsets.UTF_8);

        String[] questions = text.trim().split("\\d+、");
        System.out.println("题目总量:"+questions.length);

        JSONArray table = new JSONArray();
        for (int i = 0; i < questions.length; i++) {
            String q = questions[i].trim();
            if(q == null || q.equals("")){
                continue;
            }
            String[] lines = q.split("\\r\\n");
            if(lines.length != 3){
                throw new RuntimeException("Question["+(i)+"][\n\n\n"+q+"\n\n\n]分割异常【"+lines.length+"】");
            }

            JSONObject o = new JSONObject();
            o.put("正文", lines[0].trim());
            o.put("选项", lines[1].trim());

            try {
                Pattern p = Pattern.compile("解析：\\s*([A-Z]+)");
                String s = lines[2].trim();
                Matcher m = p.matcher(s);
                m.find();
                String a = m.group(1);
                o.put("答案", a);
            }catch(IllegalStateException ex){
                throw new RuntimeException("答案抽取异常：[\n\n\n"+lines[2].trim()+"]\n\n\n");
            }

            o.put("解析", lines[2].trim());
            table.put(o);
        }

        FileOutputStream fos = new FileOutputStream("003.json");
        fos.write(table.toString().getBytes(StandardCharsets.UTF_8));
        fos.close();
    }

    @Test
    public void extract170_3() throws IOException, JSONException {
        // 正文
        // 选项
        // 答案
        // 解析
        ClassPathResource cpr = new ClassPathResource("170-3.txt");
        byte[] bytes = IOUtils.toByteArray(cpr.getInputStream());
        String text = new String(bytes, StandardCharsets.UTF_8);

        String[] questions = text.trim().split("(?<![^\\x00-\\xff])\\d+[、\\.]");
        System.out.println("题目总量:"+questions.length);

        JSONArray table = new JSONArray();
        for (int i = 0; i < questions.length; i++) {
            String q = questions[i].trim();
            if(q == null || q.equals("")){
                continue;
            }
            String[] lines = q.split("\\r\\n");
            if(lines.length != 2){
                throw new RuntimeException("Question["+(i)+"][\n\n\n"+q+"\n\n\n]分割异常【"+lines.length+"】");
            }

            JSONObject o = new JSONObject();
            o.put("正文", lines[0].trim());
            try {
                Pattern p = Pattern.compile("解析：\\s*(√|×)");
                String s = lines[1].trim();
                Matcher m = p.matcher(s);
                m.find();
                String a = m.group(1);
                o.put("答案", a);
            }catch(IllegalStateException ex){
                throw new RuntimeException("答案抽取异常：[\n\n\n"+lines[2].trim()+"]\n\n\n");
            }

            o.put("解析", lines[1].trim());
            table.put(o);
        }

        FileOutputStream fos = new FileOutputStream("170-3.json");
        fos.write(table.toString().getBytes(StandardCharsets.UTF_8));
        fos.close();
    }

    @Test
    public void extract170_2() throws IOException, JSONException {
        // 正文
        // 选项
        // 答案
        // 解析
        ClassPathResource cpr = new ClassPathResource("170-2.txt");
        byte[] bytes = IOUtils.toByteArray(cpr.getInputStream());
        String text = new String(bytes, StandardCharsets.UTF_8);

        String[] questions = text.trim().split("(?<![^\\x00-\\xff])\\d+[、\\.]");
        System.out.println("题目总量:"+questions.length);

        JSONArray table = new JSONArray();
        for (int i = 0; i < questions.length; i++) {
            String q = questions[i].trim();
            if(q == null || q.equals("")){
                continue;
            }
            String[] lines = q.split("\\r\\n");

            JSONObject o = new JSONObject();

            StringBuffer s = new StringBuffer();
            StringBuffer y = new StringBuffer();
            for (int k = 0; k < lines.length; k++) {
                String line = lines[k].trim();
                if(k == 0){
                    o.put("正文", line);
                }else{
                    if(line.matches("[A-Z].[\\S\\s]+")){
                        s.append(line+"\n");
                    }else{
                        Pattern p = Pattern.compile("解析：\\s*([A-Z]+)");
                        Matcher m = p.matcher(line);
                        if(m.find()){
                            o.put("答案", m.group(1));
                        }
                        y.append(line+"\n");
                    }
                }
            }
            o.put("选项", s.toString());
            o.put("解析", y.toString());
            table.put(o);
        }

        FileOutputStream fos = new FileOutputStream("170-2.json");
        fos.write(table.toString().getBytes(StandardCharsets.UTF_8));
        fos.close();
    }

    @Test
    public void extract170_1() throws IOException, JSONException {
        // 正文
        // 选项
        // 答案
        // 解析
        ClassPathResource cpr = new ClassPathResource("170-1.txt");
        byte[] bytes = IOUtils.toByteArray(cpr.getInputStream());
        String text = new String(bytes, StandardCharsets.UTF_8);

        String[] questions = text.trim().split("(?<![^\\x00-\\xff])\\d+[、\\.]");
        System.out.println("题目总量:"+questions.length);

        JSONArray table = new JSONArray();
        for (int i = 0; i < questions.length; i++) {
            String q = questions[i].trim();
            if(q == null || q.equals("")){
                continue;
            }
            String[] lines = q.split("\\r\\n");

            JSONObject o = new JSONObject();

            StringBuffer s = new StringBuffer();
            StringBuffer y = new StringBuffer();
            for (int k = 0; k < lines.length; k++) {
                String line = lines[k].trim();
                if(k == 0){
                    o.put("正文", line);
                }else{
                    if(line.matches("[A-Z].[\\S\\s]+")){
                        s.append(line+"\n");
                    }else{
                        Pattern p = Pattern.compile("解析：\\s*([A-Z]+)");
                        Matcher m = p.matcher(line);
                        if(m.find()){
                            o.put("答案", m.group(1));
                        }
                        y.append(line+"\n");
                    }
                }
            }
            o.put("选项", s.toString());
            o.put("解析", y.toString());
            table.put(o);
        }

        FileOutputStream fos = new FileOutputStream("170-1.json");
        fos.write(table.toString().getBytes(StandardCharsets.UTF_8));
        fos.close();
    }
}
