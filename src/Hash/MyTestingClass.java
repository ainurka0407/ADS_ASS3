package Hash;
public class MyTestingClass {

    private final int id;
    private final String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyTestingClass that = (MyTestingClass) o;

        if (id != that.id) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        for (int i = 0; i < name.length(); i++) {
            result = 31 * result + name.charAt(i);
        }
        return result;
    }

    @Override
    public String toString() {
        return "MyTestingClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static class MyTestingClassFactory {
        public static MyTestingClass createMyTestingClass(int id, String name) {
            return new MyTestingClass(id, name);
        }
    }

    public static class MyTestingClassEquals {
        public static boolean equals(MyTestingClass obj1, MyTestingClass obj2) {
            if (obj1 == obj2) return true;
            if (obj2 == null || obj1.getClass() != obj2.getClass()) return false;

            MyTestingClass that = obj2;

            if (obj1.id != that.id) return false;
            return obj1.name != null ? obj1.name.equals(that.name) : that.name == null;
        }
    }

    public static class MyTestingClassHashCode {
        public static int hashCode(MyTestingClass obj) {
            int result = 17;
            result = 31 * result + obj.id;
            for (int i = 0; i < obj.name.length(); i++) {
                result = 31 * result + obj.name.charAt(i);
            }
            return result;
        }
    }

    public static class MyTestingClassToString {
        public static String toString(MyTestingClass obj) {
            return "MyTestingClass{" +
                    "id=" + obj.id +
                    ", name='" + obj.name + '\'' +
                    '}';
        }
    }
}
