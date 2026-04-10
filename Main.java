import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");


            int choice = sc.nextInt();

            try {
                List<Student> students = FileHandler.read();


                switch (choice) {
                    case 1:
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        for (Student s : students) {
                            if (s.getId() == id) {
                                System.out.println("Duplicate ID");
                                continue;
                            }
                        }

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Marks: ");
                        double marks = sc.nextDouble();

                        if (name.isEmpty() || marks < 0 || marks > 100) {
                            System.out.println("Invalid input");
                            break;
                        }

                        students.add(new Student(id, name, marks));
                        FileHandler.write(students);
                        System.out.println("Added");
                        break;

                    case 2:
                        for (Student s : students) {
                            System.out.println(s);

                        }
                        break;

                    case 3:
                        System.out.print("Enter ID: ");
                        int sid = sc.nextInt();
                        boolean found = false;

                        for (Student s : students) {
                            if (s.getId() == sid) {
                                System.out.println(s);
                                found = true;
                                break;

                            }
                        }

                        if (!found) System.out.println("Not found");
                        break;


                    case 4:
                        System.out.print("Enter ID: ");
                        int uid = sc.nextInt();
                        sc.nextLine();



                        boolean updated = false;

                        for (Student s : students) {
                            if (s.getId() == uid) 
                                {
                                System.out.print("New Name: ");
                                s.setName(sc.nextLine());


                                System.out.print("New Marks: ");
                                s.setMarks(sc.nextDouble());

                                updated = true;
                                break;


                            }

                        }

                        if (updated) {
                            FileHandler.write(students);
                            System.out.println("Updated");
                        } else {
                            System.out.println("Not found");



                        }
                        break;

                    case 5:
                        System.out.print("Enter ID: ");

                        int did = sc.nextInt();

                        boolean deleted = students.removeIf(s -> s.getId() == did);

                        if (deleted) {
                            FileHandler.write(students);
                            System.out.println("Deleted");
                        } else {
                            System.out.println("Not found");
                        }
                        break;

                    case 6:
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("Error");
            }

        }
        
    }


}