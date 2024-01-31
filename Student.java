class Student extends Person {
    protected int grade;
    public Student (String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade (int grade) {
        this.grade = grade;
    }
    public String toString () {
        return "Name : "+name+", Age : "+age+", Grade : "+grade;
    }
}