package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ChainedStream {

	public static void main(String[] args) throws Exception {
		Path fromFilePath = Paths.get("D:/repos/practice/tmp/forReadData.txt");
		Path toFilePath = Paths.get("D:/repos/practice/tmp/forWriteData.txt");
		if (!Files.exists(fromFilePath, LinkOption.NOFOLLOW_LINKS) && Files.exists(toFilePath, LinkOption.NOFOLLOW_LINKS)) {
			System.out.println("forReadData.txt 檔案不見了! 需先補回檔案");
			return;
		}
		if (!Files.exists(toFilePath, LinkOption.NOFOLLOW_LINKS)) {
			Files.createFile(toFilePath);
		}
		try (BufferedReader br = new BufferedReader(new FileReader(fromFilePath.toString()));
			BufferedWriter bw = new BufferedWriter(new FileWriter(toFilePath.toString()))
		) {
			String line;
			while ((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();				
			}
		} catch (Exception e) {
			System.out.print(e);
		}
	
	}

}
