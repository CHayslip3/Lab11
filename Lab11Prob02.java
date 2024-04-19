import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Lab11Prob02 {
	public static void main(String[] args){
		File inputFile, outputFile;
		
		inputFile = new File("src/people.dat");
		outputFile = new File("src/people-copy.dat");
		
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
				System.out.printf("%d %s %s %d %.2f%n", age, name, address, 
						zipcode, salary);	
			}
		}
		catch(EOFException ex) {
			//System.out.println("Reached the end of the file");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
