package Hash;
public record Student(int studentId, String studentName){
@Override
public String toString() {
    return "Hash.Student{" +
            "studentId=" + studentId +
            ", studentName='" + studentName + '\'' +
            '}';
}}