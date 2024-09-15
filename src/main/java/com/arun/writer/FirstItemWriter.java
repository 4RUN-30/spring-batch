package com.arun.writer;

import com.arun.model.Student;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FirstItemWriter implements ItemWriter<Student> {

    @Override
    public void write(List<? extends Student> list) throws Exception {
        System.out.println("Inside Item Writer");
        list.forEach(e-> System.out.println(e));
    }

//    @Override
//    public void write(List<? extends Integer> list) throws Exception {
//        System.out.println("Inside Item Writer");
//        list.forEach(e-> System.out.println(e+100));
//    }
}
