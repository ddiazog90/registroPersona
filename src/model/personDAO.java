package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	//Leer los datos del archivo donde se almacena la informacion information.txt
	public List<person> readerPerson() throws IOException{
		//almacenar los datos de cada persona encontrados
		List<person> persons=new ArrayList();
		file.setFile(new File(mainPath,information));
		//leer los datos del archivo
		String [] data=file.readerFile().split("\n");
		for(String dataPerson:data) {
			String [] info=dataPerson.split(";");
			person p=new person();
			p.setNames(info[0]);
			p.setAge(Integer.parseInt(info[1]));
			p.setDNI(info[2]);
			p.setGender(info[3]);
			p.setStudiesLevel(info[4]);
			p.setHobbies(info[5].split(","));
			p.setPathImage(info[6]);
			//agregar cada persona registrada
			persons.add(p);
		}
		
		
		
		return persons;
	}

	
}
