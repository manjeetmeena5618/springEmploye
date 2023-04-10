package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Manjeeet","Manjeet","Mahendra","Ishwar","Puran", "Rajkumar","Praveen","Manjeet");

        list.stream().filter(name-> name.startsWith("M") && name.endsWith("t")).collect(Collectors.toSet()).forEach(System.out :: println);


    }

}
