public class GirlFriend {
    private String name;
    private int age;
    public GirlFriend(){
    }
    public GirlFriend(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void setName(String name) {
        int len = name.length();
        if(len < 3 || len > 10) {
            throw new NameFormatException(name + "格式有误，长度应该为：3~10");
        }
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age) {
        if(age < 18 || age > 40) {
            throw new AgeOutOfBoundsException(age + "超出了范围");
        }
        this.age = age;
    }
    public int getAge(){
        return age;
    }
}
