import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Lab11Prob03 {
	public static void main(String[] args){
		File inputFile, outputFile, sortedFile, sortedObjectsFile;
		ArrayList<Person> PersonList = new ArrayList<Person>();
		
		inputFile = new File("src/people.dat");
		outputFile = new File("src/people-copy.dat");
		sortedFile = new File("src/people-salary-sorted.dat");
		sortedObjectsFile = new File("src/people-salary-sorted-objects.dat");
		
		if(!inputFile.exists()) {
			System.out.print("Input File " + inputFile + " does not exist." );
		}
		
		try(
				// Create a input stream
				DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"));

				// Create a output stream
				DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-copy.dat"));
				){
			int age, zipcode;
			String name, address;
			double salary;
			
			while(true) {
				age = input.readInt();
				output.writeInt(age);
				name = input.readUTF();
				output.writeUTF(name);
				address = input.readUTF();
				output.writeUTF(address);
				zipcode = input.readInt();
				output.writeInt(zipcode);
				salary = input.readDouble();
				output.writeDouble(salary);
				PersonList.add(new Person(age, name, address, zipcode, salary));
				System.out.printf("%d %s %s %d %.2f%n", age, name, address, 
						zipcode, salary);	
			}
		}
		catch(EOFException ex) {
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
		
		Collections.sort(PersonList);
		try(
				//create output stream for people-salary-sorted.dat
				DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-salary-sorted.dat"));
				){
			
			for(int i = 0; i < PersonList.size(); i++) {
				output.writeUTF(PersonList.get(i).toString());
				System.out.print(PersonList.get(i).toString());
			}
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
		
		try(
				//create output stream for people-salary-sorted-objects.dat
				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/people-salary-sorted-objects.dat"));
				){
			
			for(int i = 0; i < PersonList.size(); i++) {
				output.writeObject(PersonList.get(i));
				//System.out.print(PersonList.get(i));
			}
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
		
		
		
		
	}
}
