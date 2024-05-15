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
}
