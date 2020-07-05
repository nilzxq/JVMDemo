package com.atguigu.java;

import java.util.Comparator;

/**
 * lambda 表达式的语法格式如下：
 *
 * (parameters) -> expression
 * 或
 * (parameters) ->{ statements; }
 *
 * @Author nilzxq
 * @Date 2020-07-05 15:38
 */
public class Java8Tester {
    final static String salution="hello";
    public static void main(String[] args) {
        Java8Tester tester=new Java8Tester();
        //类型声明
        MathOperation addition=(int a,int b)->a+b;
        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;
        //大括号中的返回语句
        MathOperation multiplication=(int a,int b)->{return a*b;};
        //没有大括号及返回语句
        MathOperation division=(int a,int b)->a/b;
        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        //不用括号
        GreetingService greetingService1=message->System.out.println("Hello"+message);
        //用括号
        GreetingService greetingService2=(message)->System.out.println("Hello"+message);
        greetingService1.sayMessage("world");
        greetingService2.sayMessage("Java8");
        //System.out.println(greetingService1);

        //1.
        GreetingService greetingService3=message -> System.out.println(salution+message);
        greetingService3.sayMessage("lambda 表达式只能引用标记了 final 的外层局部变量，这就是说不能在 lambda 内部修改定义在域外的局部变量，否则会编译错误。");

        //2.直接再lambda表达式中访问外层的局部变量
        final int num=1;
        Converter<Integer,String> converter1=(param)->System.out.println(String.valueOf(param+num));
        converter1.convert(2);

        //3.lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有 final 的语义）
//        int temp=1;
//        //Variable used in lambda expression should be final or effectively final
//        Converter<Integer,String> converter2=(param)->System.out.println(String.valueOf(param+temp));
//        converter2.convert(2);
//        temp=5;
        //4.在 Lambda 表达式当中不允许声明一个与局部变量同名的参数或者局部变量。
//        String first = "";
//        //Variable 'first' is already defined in the scope
//        Comparator<String> comparator = (first, second) -> Integer.compare(first.length(), second.length());  //编译会出错
    }

    interface MathOperation{
        int operation(int a,int b);
    }

    interface GreetingService{
        void sayMessage(String message);
    }

    interface Converter<T1,T2>{
        void convert(int i);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a,b);
    }
}


