import java.util.*;

public class Runner {
    static ArrayList<Person>p = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void displayMenu () {
        System.out.println("------Menu------");
        System.out.println("1. Add a person");
        System.out.println("2. Edit a person");
        System.out.println("3. Delete a person");
        System.out.println("4. Search a person");
        System.out.println("5. List all People");
        System.out.println("6. Exit");
    }

    public static void addPerson () {
        boolean valid;
        boolean valid2;
        int input = 0;
        String name;
        int age;
        do {
            valid2 = true;
            try{
                do {
                    valid = true;
                    System.out.println("1. Teacher");
                    System.out.println("2. Student");
                    input = sc.nextInt();
                    if (input != 1 && input != 2) {
                        valid = false;
                        System.out.println("Invalid Entry");

                    }
                }while(!valid);
            }
            catch (InputMismatchException e) {
                valid2 = false;
                System.out.println("Incorrect character!");
                sc.nextLine();
            }
        }while(!valid2);
        System.out.println("Enter Name : ");
        name = sc.next();
        System.out.println("Enter age : ");
        age = sc.nextInt();
        if (input == 1) {
            System.out.println("Enter Subject : ");
            String subject  = sc.next();
            p.add(new Teacher(name, age, subject));
        }
        if (input == 2) {
            System.out.println("Enter grade ");
            int grade = sc.nextInt();
            p.add(new Student(name, age, grade));
        }
    }

    public static void editPerson() {
        boolean exit = false;
        boolean exit2;
        int choice;
        String name;
        int age;
        int index;
        do {
            exit2 = true;
            listPeople();
            System.out.println("Enter index of person : ");
            index = sc.nextInt();
            if (index < 1 || index > p.size()) {
                exit2 = false;
                System.out.println("Invalid Entry");
            }
        }while(!exit2);
        index -= 1;
        Person p2 = p.get(index);
        if (p.get(index) instanceof Teacher) {
            Teacher t = (Teacher) p2;
            String subject;
            do {
                System.out.println("1. Change name : ");
                System.out.println("2. Change age : ");
                System.out.println("3. Change Subject : ");
                System.out.println("4. Exit");
                choice = sc.nextInt();
                switch (choice) {
                    case 1 :
                        System.out.println("Enter new name : ");
                        name  = sc.next();
                        t.setName(name);
                        break;
                    case 2 :
                        System.out.println("Enter new age : ");
                        age = sc.nextInt();
                        t.setAge(age);
                        break;
                    case 3 :
                        System.out.println("Enter new Subject : ");
                        subject = sc.next();
                        t.setSubject(subject);
                        break;
                    case 4 :
                        exit = true;
                        break;
                    default :
                        System.out.println("Invalid Entry");
                }
            }while (!exit);
        }
        if (p.get(index) instanceof Student) {

            Student s = (Student) p2;
            int grade;
            do {
                System.out.println("1. Change name : ");
                System.out.println("2. Change age : ");
                System.out.println("3. Change grade : ");
                System.out.println("4. Exit");
                choice = sc.nextInt();
                switch (choice) {
                    case 1 :
                        System.out.println("Enter new name : ");
                        name  = sc.next();
                        s.setName(name);
                        break;
                    case 2 :
                        System.out.println("Enter new age : ");
                        age = sc.nextInt();
                        s.setAge(age);
                        break;
                    case 3 :
                        System.out.println("Enter new grade : ");
                        grade = sc.nextInt();
                        s.setGrade(grade);
                        break;
                    case 4 :
                        exit = true;
                        break;
                    default :
                        System.out.println("Invalid Entry");
                }
            }while (!exit);
        }
    }

    private static void deletePerson() {
        listPeople();
        boolean exit2;
        int index;
        do {
            exit2 = true;
            listPeople();
            System.out.println("Enter index of person : ");
            index = sc.nextInt();
            if (index < 1 || index > p.size()) {
                exit2 = false;
                System.out.println("Invalid Entry");
            }
        }while(!exit2);
        index -= 1;
        p.remove(index);
    }

    private static void searchPerson() {
        System.out.println("Enter name : ");
        String name = sc.next();
        boolean found = false;
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getName().equalsIgnoreCase(name)) {
                found = true;
                System.out.println("Person found!");
                System.out.println(p.get(i));
            }
        }
        if (!found) {
            System.out.println("Person not found!");
        }
    }

    public static void listPeople() {
        int count = 1;
        for (Person a :p) {
            System.out.println("Index : "+count+", "+a);
            count++;
        }
    }
    public static void main (String args[]) {
        boolean exit = false;
        int choice;
        do {
            displayMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1 :
                    addPerson();
                    break;
                case 2 :
                    editPerson();
                    break;
                case 3 :
                    deletePerson();
                    break;
                case 4 :
                    searchPerson();
                    break;
                case 5 :
                    listPeople();
                    break;
                case 6 :
                    exit = true;
                    break;
                default :
                    System.out.println("Invalid entry");
                    break;
            }
        }while (!exit);
    }
}