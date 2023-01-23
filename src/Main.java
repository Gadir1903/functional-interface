import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var students = Arrays.asList(
          new Students("Joe" , 22,13313,3),
          new Students("Dan",20,13323,2),
          new Students("Ashley",26,13313,2),
          new Students("Michael",23,13345,4)
        );

        students.stream().map(students1 -> students1.getAge()> 23).collect(Collectors.toList());

        students = filterStudents(students,student ->
                (student.getAge() > 20) && student.getCourse() > 2 && (student.getGroup() == 13313));

        sortStudents(students, Comparator.comparing(Students::getGroup));

        students.forEach(System.out::println);
    }
    static List<Students> filterStudents(List<Students> list,Predicate<Students> predicate){
        return list.stream().filter(predicate).collect(Collectors.toList());
    }
    static void sortStudents(List<Students> list, Comparator<Students>comparator){
        list.sort(comparator);
    }
}