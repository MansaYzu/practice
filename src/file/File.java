package file;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class File {

	public static void main(String[] args) {
		FileSystem fs = FileSystems.getDefault();
		Path path1 = fs.getPath("D:/test1.txt");
		Path path2 = Paths.get("D:", ".", "test2.txt");
		System.out.println("file1 name: " +  path1.getFileName());
		System.out.println("file2 name: " +  path2.getFileName());
		System.out.println("file2 to file1 path: " +  path1.relativize(path2));
		System.out.println("file1 exists? " + Files.exists(path1));
		System.out.println("file2 not exists? " + Files.notExists(path2));
		
		Path norPath2 = path2.normalize();
		System.out.println("norPath2 path: " +  norPath2.toAbsolutePath());
		System.out.println();
		
		Path projDirP = Paths.get("D:\\repos\\practice");
		Path readmePath = projDirP.resolve("README.md");
		System.out.println("README path: " +  readmePath.toAbsolutePath());
		System.out.println("README exists? " + Files.exists(readmePath));
		
		Path link1p = readmePath.resolve(Paths.get("../testLink")).normalize();
		System.out.println("link to readme: " + link1p);
		try {
			if (Files.notExists(link1p, LinkOption.NOFOLLOW_LINKS)) {
				Files.createSymbolicLink(link1p, readmePath);				
			}
			System.out.println("is link RegularFile: " + Files.isRegularFile(link1p));
			System.out.println("is link SymbolicLink: " + Files.isSymbolicLink(link1p));
			System.out.println("is link same to target file: " + Files.isSameFile(link1p, readmePath));
			System.out.println("target file path" + Files.readSymbolicLink(link1p));
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Path link2p = readmePath.resolve(Paths.get("../testLink2")).normalize();
		System.out.println("link2 to readme: " + link2p);
		try {
			if (Files.notExists(link2p, LinkOption.NOFOLLOW_LINKS)) {
				Files.createLink(link2p, link1p);				
			}
			System.out.println("is link RegularFile: " + Files.isRegularFile(link2p));
			System.out.println("is link SymbolicLink: " + Files.isSymbolicLink(link2p));
			System.out.println("is link same to target file: " + Files.isSameFile(link2p, readmePath));
			System.out.println("is link same to testLink: " + Files.isSameFile(link2p, link1p));
			System.out.println("target file path" + Files.readSymbolicLink(link2p));
			
			String linkData = new String(Files.readAllBytes(link2p));
	        System.out.println("Linked file content: " + linkData);
			System.out.println();
			Files.delete(link2p);
			Files.delete(link1p);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Path genDirP = projDirP.resolve("testDir/testSubDir");
			Path genFileP = genDirP.resolve("genFile.txt");
			Path copyFile1P = genDirP.resolve("readme.md");
			if (Files.notExists(genFileP)) {
				Files.createDirectories(genDirP);
				Files.createFile(genFileP);		
				Files.copy(readmePath, copyFile1P, StandardCopyOption.REPLACE_EXISTING);
			} else {
				Files.delete(genFileP);
				Files.delete(copyFile1P);
				Files.deleteIfExists(genDirP);
				Files.deleteIfExists(Paths.get("D:/").resolve(genDirP.subpath(0, genDirP.getNameCount() - 1)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Path copyUrlHtmlfilePath = projDirP.resolve("copied.html");
		URI uri = URI.create("http://www.oracle.com/");
		try (InputStream ins = uri.toURL().openStream()) {
			if (Files.notExists(copyUrlHtmlfilePath)) {
				Files.copy(ins, copyUrlHtmlfilePath);
			} else {
				Files.delete(copyUrlHtmlfilePath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Path projSrcPath = projDirP.resolve("src");
		try(DirectoryStream<Path> ds = Files.newDirectoryStream(projSrcPath, "*")) {
			System.out.println("files in " + projSrcPath);
			for (Path filePath: ds) {
				System.out.println((Files.isDirectory(filePath) ? "[dir] " : "[file] ") + filePath.getFileName());
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
