package exercise17_11;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirectorySummary {

	DirectoryStream<Path> dirStream;
	
	public DirectorySummary(Path dirPath) throws IOException {
		
		DirectoryStream<Path> dir= Files.newDirectoryStream(dirPath);
			
			setDirStream(dir);
		
		
	}
	
	public void setDirStream(DirectoryStream<Path> path) {
		
		this.dirStream = path;
	}
	
	public DirectoryStream<Path> getDirStream(){
		
		return dirStream;
	}
	
	
	public void dirSummarize(){
		
		getDirStream().iterator()
					  .next()
					  .forEach(path -> {
//						  if(Files.exists(path)) {
//							  try {
						  System.out.printf("%n%s exists%n", path.getFileName());
						  System.out.printf("%s a directory%n", Files.isDirectory(path)
						  ? "Is" : "Is not");
						  System.out.printf("%s an absolute path%n", path.isAbsolute()
						  ? "Is" : "Is not");
//						  System.out.printf("Last modified: %s%n", Files.getLastModifiedTime(path)
//						  );
//						  System.out.printf("Size: %s%n", Files.size(path));
						  System.out.printf("Path: %s%n", path);
						  System.out.printf("Absolute path: %s%n", path.toAbsolutePath());
//							  }
//							  catch(IOException e) {
//								  e.getMessage();
//							  }
//						  }
//						  else if(Files.isDirectory(path)){
//							  
//							  path.forEach(System.out::println);
//						  }
//						  else {
//							  System.out.println("Path doesnt exist");
//						  }
						  
					  }
							  
							  );
		
	}
}
