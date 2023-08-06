package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Stream {

	public static void main(String[] args) {
		try (FileInputStream fin = new FileInputStream("D:/test1.txt");
			FileOutputStream fout = new FileOutputStream("D:/test2.txt")) {
			System.out.println ("Bytes available: " + fin.available());
			byte[] buffer = new byte[5];
			int readCount, totalReadBytesCount = 0;
			do {
				readCount = fin.read(buffer);
				totalReadBytesCount += readCount;
				fout.write(buffer);
				System.out.println("buffer: " + Arrays.toString(buffer));
			} while(readCount != -1);
			System.out.println("read file " + totalReadBytesCount + " bytes.");
		} catch(FileNotFoundException e) {
			System.out.print("file not found!" + e + "\n");
		} catch (IOException e) {
			System.out.printf("IO exception! %s", e);
		}

	}

}
