package com.java.me.NewTime;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class Time_Date {
    /**
     * Instant、LocalDate、LocalTime、LocalDateTime etc
     */

    public static void main(String args[]){
        Time_Date td = new Time_Date();
        td.getTime();
        td.TimeUtils();
        td.getMonthEnum();
    }

    /**
     * 获取年、月、日、时、分、秒等
     */
    public void getTime(){

        //获取年月日
        LocalDate ytd = LocalDate.now();
        System.out.println("Year:"+ytd.getYear()+",Month:"+ytd.getMonthValue()+
                ",Day:"+ytd.getDayOfMonth()+",Month(English):"+ytd.getMonth());

        System.out.println(ytd.getDayOfWeek()+"----------"+ytd.getDayOfMonth());

        //获取时分秒
        LocalTime hms = LocalTime.now();
        System.out.println("Hour："+hms.getHour()+",Minute:"+hms.getMinute()+",Second"+hms.getSecond()+",Nano:"+hms.getNano());
        System.out.println(hms.isAfter(LocalTime.now())+"------"+hms.isBefore(LocalTime.now()));

        System.out.println(LocalDateTime.now());
        System.out.println("---------------------------------------------------------------");
    }

    /**
     * 时间工具
     */
    public void TimeUtils(){
        System.out.println(ZoneId.getAvailableZoneIds());
       //ChronoUnit
        LocalTime Shanghai = LocalTime.now(ZoneId.of("Asia/Shanghai"));
        LocalTime NewYork = LocalTime.now(ZoneId.of("America/New_York"));

        System.out.println(ZoneId.of("Asia/Shanghai").getRules()+"------"+ZoneId.of("America/New_York").getRules());
        System.out.println(ChronoUnit.HOURS.between(Shanghai,Shanghai));
        System.out.println("---------------------------------------------------------------");

        //Duration
        Instant ina = Instant.now();
        Instant inb = ina.plus(Duration.ofSeconds(10000000));
        System.out.println(Duration.between(ina,inb).toMillis()
                +"------"+Duration.between(ina,inb).toHours()+"------"+Duration.between(ina,inb).getUnits());
        LocalDate start = LocalDate.of(2017,7,14);
        LocalDate now = LocalDate.of(2017,11,3);
        //System.out.println(Duration.between(start,now).toHours());   //LocalDate 不支持秒，无法使用Duration
        System.out.println(ChronoUnit.DAYS.between(start,now));
        Temporal t1 = LocalTime.of(23,06);
        Temporal t2 = LocalTime.of(15,26);
        System.out.println(Duration.between(t1,t2));
        System.out.println("---------------------------------------------------------------");
        //Period
        LocalDate birthday = LocalDate.of(1991,8,23);
        Period p = Period.between(birthday,now);
        System.out.println("My birthday is"+ birthday);
        System.out.println("年龄："+p.getYears()+"year"+p.getMonths()+"month"+p.getDays()+"day");
        System.out.println("---------------------------------------------------------------");

    }

    public void getMonthEnum(){
        System.out.println(Month.values()+"------"+Month.valueOf("JUNE")+"------"+Month.valueOf(Month.class,"JUNE"));
    }


}
