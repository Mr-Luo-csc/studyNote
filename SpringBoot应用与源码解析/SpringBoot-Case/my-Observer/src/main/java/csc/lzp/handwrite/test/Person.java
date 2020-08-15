package csc.lzp.handwrite.test;

/**
 * @Description: 模拟Java中的builder模式、自己的见解,可能有出入
 * @Author: luozhipeng
 * @Date: 2020/8/14
 **/
public class Person {

    private String name;
    private String gender;
    private Integer age;
    private String career;

    private Person(Builder builder) {
        this.name = builder.name;
        this.gender = builder.gender;
        this.age = builder.age;
        this.career = builder.career;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", career='" + career + '\'' +
                '}';
    }

    public static class Builder {
        private final String name;
        private final String gender;
        private Integer age;
        private String career;

        public Builder(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder career(String career) {
            this.career = career;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    //======主方法测试builder构建对象
    public static void main(String[] args) {
        Person person = new Person.Builder("罗志鹏", "男").age(21).career("程序员").build();
        System.out.println("输出: " + person.toString());
    }
}
