package performance.designpatterns;

import lombok.Getter;
import lombok.Setter;

public class PrototypePattern {

    @Getter
    @Setter
    static class Student implements Cloneable {

        private String name;

        private Teacher teacher;

        //重写clone方法
        public Student clone(){
            Student student = null;
            try{
                student = (Student) super.clone();
                Teacher teacherClone = teacher.clone();
                student.setTeacher(teacherClone);
            }catch(CloneNotSupportedException e){
                e.printStackTrace();
            }
            return student;
        }

        public void showName() {
            System.out.println("name is " + getName());
        }
    }

    @Setter
    @Getter
    static class Teacher implements Cloneable {
        private String name;

        public Teacher clone() {
            Teacher teacher= null;
            try {
                teacher = (Teacher) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return teacher;
        }

    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("rs");
        Teacher teacher = new Teacher();
        teacher.setName("chen");
        student.setTeacher(teacher);
        for(int i=0; i< 10; i++){
            Student cloneCp = student.clone();
            cloneCp.getTeacher().setName("ls");
            cloneCp.showName();
        }
        System.out.println("The teacher is " + student.getTeacher().getName());
    }

}
