package com.example.springdatabasicdemo.init;

import com.example.springdatabasicdemo.dtos.HotelsDto;
import com.example.springdatabasicdemo.services.HotelsService;
import com.example.springdatabasicdemo.services.StudentService;
import com.example.springdatabasicdemo.services.impl.ToursServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ToursServiceImpl toursServiceImpl;

    @Autowired
    private HotelsService hotelsService;

    @Override
    public void run(String... args) throws Exception {
        seedData();
        toursServiceImpl.getHotelsByTourId(1).forEach(System.out::println);
    }

    private void printAllStudentsByGroupName(String groupName) {
        studentService
                .findStudentsByGroup(groupName)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        //Добавление в БД записей
        /*GroupDto g1 = new GroupDto(0,"UVP-211");
        GroupDto g2 = new GroupDto(0,"UVP-212");
        HotelsDto h1 = new HotelsDto(0,"Bober","Pushkina 3",3);
        HotelsDto h2 = new HotelsDto(0,"Bogfds","Pushfdasina 3",9);
        HotelsDto h3 = new HotelsDto(0,"Aboba","Pushkina 7",7);*/
        HotelsDto h4 = new HotelsDto(2,"jija","Pushkina 2",4);

       /* h1=hotelsService.register(h1);
        h2=hotelsService.register(h2);
        h3=hotelsService.register(h3);*/
        h4=hotelsService.register(h4);

       /* StudentDto s1 = new StudentDto(0, "Petr Ivanov", g1);
        StudentDto s2 = new StudentDto(0, "Ivan Petrov", g2);

        s1 = studentService.register(s1);
        s2 = studentService.register(s2);

        printAllStudentsByGroupName("UVP-212");

        studentService.transfer(s1, s2.getGroup());
        printAllStudentsByGroupName("UVP-212");*/

    }
}
