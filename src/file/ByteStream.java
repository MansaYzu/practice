package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;

public class ByteStream {

	public static void main(String[] args) throws IOException {
		Path fromFilePath = Paths.get("D:/repos/practice/tmp/forReadData.txt");
		Path toFilePath = Paths.get("D:/repos/practice/tmp/forWriteData.txt");
		if (!Files.exists(fromFilePath, LinkOption.NOFOLLOW_LINKS) && Files.exists(toFilePath, LinkOption.NOFOLLOW_LINKS)) {
			System.out.println("forReadData.txt 檔案不見了! 需先補回檔案");
			return;
		}
		if (!Files.exists(toFilePath, LinkOption.NOFOLLOW_LINKS)) {
			Files.createFile(toFilePath);
		}

		try (FileInputStream fin = new FileInputStream(fromFilePath.toString());
			FileOutputStream fout = new FileOutputStream(toFilePath.toFile());
		) {
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
