class Teacher extends Person{
    protected String subject;
    public Teacher (String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject (String subject) {
        this.subject = subject;
    }
    public String toString () {
        return "Name : "+name+", Age : "+age+", Subject : "+subject;
    }
}