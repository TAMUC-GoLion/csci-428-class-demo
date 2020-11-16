package edu.tamuc.csci.topics.hash;

/**
 * Demo on hashcode
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
        hash = hash * BASE + id;
        hash = hash * BASE + cid;
        hash = hash * BASE + lastName.hashCode();
        hash = hash * BASE + firstName.hashCode();
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

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
    }
}
