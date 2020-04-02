import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    // 姓名,语文成绩,数学成绩,总分
    private String name;
    private int chinese;
    private int math;
    private int total;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

public class Test {
    public static void main(String[] args) throws IOException {
        //1：键盘输入数据，把数据封装成学生对象，存储到集合中
        //2: 创建学生集合
        ArrayList<Student> students = new ArrayList<Student>();
        for (int i = 0; i < 3; i++) {
            Scanner sc = new Scanner(System.in);
            //键盘输入数据
            System.out.println("请输入学生姓名：");
            String name = sc.nextLine();
            System.out.println("请输入语文成绩：");
            int chinese = sc.nextInt();
            System.out.println("请输入数学成绩：");
            int math = sc.nextInt();
            //把数据封装成学生对象
            Student s = new Student();
            s.setName(name);
            s.setChinese(chinese);
            s.setMath(math);
            s.setTotal(math + chinese);
            //存储到集合中
            students.add(s);
        }
        //3：目的地Student.txt
        File destPath = new File("C:\\Users\\80626\\Desktop\\Student.txt");
        // 获取集合中的每一个Student对象
        BufferedWriter bw = new BufferedWriter(new FileWriter(destPath));
        bw.write("学生姓名\t");
        bw.write("语文成绩\t");
        bw.write("数学成绩\t");
        bw.write("总分\t");
        bw.newLine();
        bw.flush();

        for (Student s : students) {
            //6: 把Student信息存储到文本文件中
            //数据源Student s
            //目的地Student.txt
            String name = s.getName();
            int chinese = s.getChinese();
            int math = s.getMath();
            int total = s.getTotal();

            bw.write(name + "\t");
            bw.write(chinese + "\t");
            bw.write(math + "\t");
            bw.write(total + "\t");
            bw.newLine();
            bw.flush();
        }
        //释放资源
        bw.close();
    }
}
