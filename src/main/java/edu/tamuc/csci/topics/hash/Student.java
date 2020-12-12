package edu.tamuc.csci.topics.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Demo on hashcode
 * Keep this in mind:
 * 1) If using raw type as key in map, remember to override both methods hashCode() & equals()
 * 2) Avoid using Double or Float as key in map!
 */

public class Student {
    private String lastName;
    private String firstName;
    private int id;
    private int cid;

    public Student(String lastName, String firstName, int id, int cid) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
        this.cid = cid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        final int BASE = 53;
        hash = hash * BASE + id; //KMP % M String Pattern Match id * 53^3 + cid * 53^2 + last * 53^1 + first * 1
        hash = hash * BASE + cid;
        hash = hash * BASE + lastName.hashCode();
        hash = hash * BASE + firstName.hashCode();
//        hash = id + cid;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        Student that = (Student) obj;
        return this.lastName.equals(that.lastName)
                && this.firstName.equals(that.firstName)
                && this.cid == that.cid
                && this.id == that.id;
    }

    public static void main(String[] args) {
        Student s1 = new Student("Li", "Luke", 0, 428);
        Student s2 = new Student("Tom", "Jerry", 1, 428);
        Student s3 = new Student("Tom", "Jerry", 1, 428);
        Student s4 = new Student("Tom", "Bob", 2, 427);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());

        //int , float, double, boolean
        List<Object> holder = new ArrayList<>();
        Map<Student, Integer> cls = new HashMap<>();
        cls.put(s1, 1);
        cls.put(s2, 5);
        cls.put(s3, 6);
        for(Map.Entry<Student, Integer> entry : cls.entrySet()) {
            holder.add(entry.getKey());
            System.out.println(entry.getKey() + " 's rank is " + entry.getValue());
        }

        //flating 1.5 == 3 / 2 ==> 1.49999999999.. (double, floating) xxx. xxxx
    }
}
