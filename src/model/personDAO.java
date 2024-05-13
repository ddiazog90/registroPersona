package model;

import java.io.File;
import java.io.IOException;

import libreriaVersion2.files;

public class personDAO implements settings{
	private files file;
	
	public personDAO() {
		file=new files(mainPath);
		file.create(0);
		
	}
	public boolean writerPerson(person p) throws IOException {
		//direccionar al archivo 
		file.setFile(new File(mainPath,information));
		return file.writerFile(p.personalInfo(), false);
		
	}
	

	
}
