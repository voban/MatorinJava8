package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by Владимир on 20.12.2016.
 */
public class Application {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Vladimir", 20));
        list.add(new Person("Egor", 35));
        list.add(new Person("Alexandr", 45));
        list.add(new Person("Dmitriy", 50));
        list.add(new Person("Jack", 60));
        Map<String, Integer> map = Streams.of(list)
                .filter(p -> p.getAge() > 40)
                .transform(p -> new Person(p.getName(), p.getAge() + 30))
                .toMap(p -> p.getName(), p -> p.getAge());
        for (Map.Entry<String, Integer> pair: map.entrySet())
            System.out.println(pair.getKey() + "  " + pair.getValue());
        System.out.println(list.size()); //5, dont change
    }

}
