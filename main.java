import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {

		try {

			ArrayList<Student> studentsObjects = new ArrayList<>();

			studentsObjects.add(new Student("Abdulrhman", 20818383, 3.7));
			studentsObjects.add(new Student("Abdo", 20818212, 2.7));
			studentsObjects.add(new Student("mohammed", 20183824, 3.2));
			studentsObjects.add(new Student("ryan", 2081121, 2.4));
			studentsObjects.add(new Student("nasser", 20818211, 3.1));
			// an arraylist of students objects that have 3 parameters name, id, gpa

			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("array.dat"));
			// using ObjectOutputStream and inside it is FileoutputStream that contains the path
			
			
			output.writeObject(studentsObjects);
			// we used the objectOutputStream to print the whole arrayList of objects without a loop
			output.close();

			ObjectInputStream input = new ObjectInputStream(new FileInputStream("array.dat"));
			// we used ObjectOutputStream to read the whole object at one time
			
			ArrayList<Student> newStudentsObjects = new ArrayList<>();

			newStudentsObjects = (ArrayList<Student>) (input.readObject());
			//we used the new arrayList and casted the input of type object to ArrayList<Student>

			input.close();

			for (int i = 0; i < 5; i++) {
				System.out.println(newStudentsObjects.get(i) + " ");
			}//for loop to print the arraylist using toString method of Student Object

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Student implements Serializable {

	String fullname;
	int id;
	double age;

	Student(String fullname, int id, double Age) {
		this.fullname = fullname;
		this.id = id;
		this.age = Age;
	}

	public String toString() {
		return fullname + " " + id + " " + age;
	}

}
