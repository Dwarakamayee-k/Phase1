import java.io.*;

import java.util.*;


public class Operations {
    	static Scanner sn=new Scanner(System.in);
    		
		public static void FileOperations() {
		System.out.println("");
		System.out.println("Press 1 to Add a file");
		System.out.println("Press 2 to Delete a file");
		System.out.println("Press 3 to Search a file");
		System.out.println("Press 4 to go Back to the Main Menu");
		
		String choice = sn.nextLine();
		try {
			handle(choice);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void handle(String num)throws IOException {
		switch(num) {
			case "1":
				System.out.println("You selected Add Operation");
				add();
				break;
			case "2":
				System.out.println("You selected Delete Operation");
				delete();
				break;
			case "3":
				System.out.println("You selected Search Operation");
				search();
				break;
			case "4":
				System.out.println("Going Back to Main Menu");
				App.main();
				break;				
			default:
				System.out.println("Invalid input");
		}
		FileOperations();
	}
	
	// to add a file
	
	public static void add()throws IOException{
		String path="src/storage/";
		Scanner sc=new Scanner(System.in);
		ArrayList<String> al=new ArrayList<>();
		while(true) {
		System.out.println("enter the file name");
		String filename=sc.next();
		String finalfile=path+filename;
		File f=new File(finalfile);	
		boolean res=f.createNewFile();
		if(res==false) {
			System.out.println("file not created");
		}
		else {
			al.add(filename);
			System.out.println("file is created");
		}
		System.out.println(al);
		break;
	
	}
	}

		
	// to delete a file
	
	public static void delete() throws IOException{
		String path="src/storage/";
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the file name to be deleted:");
		String filedel=sc.next();
		String finalfile=path+filedel;
		File f=new File(finalfile);
		f.delete();
		System.out.println("file is deleted:");
		
		
	}

		
	//to search a file
	
	public static void search() throws IOException{
		String path="src/storage/";
		Scanner sc=new Scanner(System.in);
		File f=new File(path);
		System.out.println("enter the file name");
		String filesearch=sc.next();
		File filen[]=f.listFiles();
		int flag=0;
		for(File ff:filen) {
			if(ff.getName().equals(filesearch)) {
				flag=1;
				break;
			}
			else {
				flag=0;
			}
		}
		if(flag==1) {
			System.out.println("file is found");
		}
		else {
			System.out.println("file is not found");
		}
		
		
		
	}

}
