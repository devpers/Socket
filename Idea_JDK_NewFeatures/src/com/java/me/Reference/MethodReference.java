package com.java.me.Reference;

import com.java.me.Reference.Modle.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReference {


    public static void main(String args[]){
        reference();
    }

    /**
     * 定义的函数式接口MathInterface，必须要与其引用的静态方法，具有同样的返回值和入参。
     */
    public static void reference(){
        List<Integer> ints = Arrays.asList(1,9,3,6,8,2,4,0,6);
        //lambada
        List<Integer> o1 = ints.stream().sorted(Integer::compare).collect(Collectors.toList());
        //静态方法引用   用法：ClassName::staticMethod
        List<Integer> o2 = ints.stream().sorted((e1, e2) -> e2 - e1).collect(Collectors.toList());
        System.out.println(o1+"------"+o2);

//        FunctionInterface caluA = Math::pow;
//        System.out.println(caluA.calculate(1.2,2.6));
//
//        FunctionInterface caluB = Math::max;
//        System.out.println(caluB.calculate(1.2,2.6));

        //实例方法引用
        String str = "InstanceReference";
//        FunctionInterface strA = str::length;
//        System.out.println(strA.lengthNew());

//        FunctionInterface strB = str::concat;
//        System.out.println(strB.transform(str));

        //构造方法引用
        FunctionInterface person = Person::new;
        Person p = person.create("Mr Choia","1234567890");
        System.out.println(p.getName()+"------"+p.getIdCard());
    }
}
