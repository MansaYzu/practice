package file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CharacterStream {
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
		
		char[] buff = new char[10];
		int readCount;
		try (FileReader fr = new FileReader(fromFilePath.toString());
			FileWriter fw = new FileWriter(toFilePath.toString());
		) {
			while ((readCount = fr.read(buff)) != -1) {
				if (readCount < buff.length) {
					fw.write(buff, 0, readCount);
				} else {
					fw.write(buff);					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
