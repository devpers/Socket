package com.java.me.Stream;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_Lambada {

    protected static List<Integer> integers = new ArrayList<Integer>();

    /**
     * 流
     * @param integers
     */
    public void me_stream(List<Integer> integers){

        //max/min    get max/min value
        Optional<Integer> max = integers.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("stream-max:"+max.get());

        //filter
        List<Integer> mixList = Arrays.asList(2,6,8,null,3,8,null,0,null);
        Stream<Integer>  pureList = mixList.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if(null==integer){
                    return false;
                }
                return true;
            }
        });
        List<Integer> pureListNew = mixList.stream().filter(integer -> integer!=null).collect(Collectors.toList());
        System.out.println("stream-filter:"+pureList.collect(Collectors.toList())+"------stream-lambada-filter"+pureListNew);

        List<String> mixString = Arrays.asList("China","America","Korea","Japan","Russia","Canada","Indian","Germany","Italy","United Kingdom");
        List<String> target = mixString.stream().filter(s -> s.indexOf("a")<0).collect(Collectors.toList());
        System.out.println("stream-filter:"+target);

        //合并流
        List<String> list = new ArrayList<String>();
        list.add("I am a boy");
        list.add("I love the girl");
        list.add("and also the girl loves me");

        Stream<String> all = list.stream().map(s -> s.split(" ")).flatMap(Arrays::stream);
        System.out.println(all.collect(Collectors.toList())+"那就在一起");
    }

    /**
     * 并发流
     * @param integers
     */
    public void me_parallelStream(List<Integer> integers){

        Optional<Integer> max = integers.parallelStream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("parallelStream-max:"+max.get());

    }

    /**
     * 并发流+lambda
     * @param integers
     */
    public void me_parallelStreamLambada(List<Integer> integers){
        //Optional<Integer> max = integers.parallelStream().max(Integer::max);
        Optional<Integer> max = integers.parallelStream().max((o1, o2) -> o1.compareTo(o2));
        System.out.println("parallelStreamLambada-max:"+max.get());
    }

    /**
     * 流+lambda
     * @param integers
     */
    public void me_streamLambada(List<Integer> integers){
        Optional<Integer> sl = integers.stream().max(Integer::min);

        Optional<Integer> sla = integers.stream().max((o1, o2) -> o1.compareTo(o2));
        System.out.println("streamLambada-max:"+sla.get());
    }

    public static void main(String args[]){
        Stream_Lambada sl = new Stream_Lambada();
        List<Integer> ints = sl.addElements(integers);

        sl.me_stream(ints);
        sl.me_parallelStream(ints);
        sl.me_parallelStreamLambada(ints);
        sl.me_streamLambada(ints);
        sl.MyStringUtils();
    }

    /**
     * 初始化integers
     * @param integers
     * @return
     */
    public List<Integer> addElements(List<Integer> integers){
        //integers = Arrays.asList();
        Random rdNum = new Random(10);

        for (int i = 0; i < 100; i++) {
            integers.add(rdNum.nextInt());
        }
        return integers;
    }

    public void MyStringUtils(){
        List<String> mixString = Arrays.asList("China","America","Korea","Japan","Russia","Canada","Indian","Germany","Italy","United Kingdom");

        mixString.forEach(s -> s.replace("a","me"));
        System.out.println("stream-filter-me:"+mixString);
        List<String> meString = new ArrayList<String>();
        mixString.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                meString.add("me"+s);
            }
        });
        System.out.println("foreach-lambada-me:"+meString);
    }
}











