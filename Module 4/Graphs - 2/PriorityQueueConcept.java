import java.util.Collections;
import java.util.PriorityQueue;

class Student {
    String name;
    int age;
    int marks;
    public Student(String name, int age, int marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
}

public class PriorityQueueConcept {

    public static void main(String[] args) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//
//        pq.add(10);
//        pq.add(3);
//        pq.add(2);
//        pq.add(11);
//
//        System.out.println(pq.peek());
//        System.out.println(pq.poll());
//        System.out.println(pq.poll());
//        System.out.println(pq.poll());
//        System.out.println(pq.peek());
//
//        //max heap
//        PriorityQueue<String> pqS = new PriorityQueue<>(Collections.reverseOrder());
//        pqS.add("for");
//        pqS.add("acciojob");
//        pqS.add("ironman");
//        pqS.add("Accio");
//
//        while(!pqS.isEmpty()) {
//            System.out.println(pqS.poll());
//        }

        PriorityQueue<Student> pqStudent = new PriorityQueue<>(
                // ascencing order based on age
                (a,b) -> b.marks - a.marks
        );
        pqStudent.add(new Student("Virat",36,78));
        pqStudent.add(new Student("Rohit",38,80));
        pqStudent.add(new Student("Bumrah",32,56));

        while(!pqStudent.isEmpty()) {
            System.out.println(pqStudent.poll().name);
        }

    }
}
