package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Dictionary;
import java.util.HashMap;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class files {
	FileWriter file;
	String user;
	Boolean avail =true;
	public HashMap<String, Integer> wigDict = new HashMap<String, Integer>();
	
	Path p1 = Paths.get("txt/Wig.txt");
	Path p2 = Paths.get("txt/Wigtemp.txt");
	Path p3 = Paths.get("txt/WigDict.txt");
	
	
	
	//File wigFile = new File("C:\\WigBot\\Wig.txt");
	//File tmpFile = new File("C:\\WigBot\\Wigtemp.txt");
	
	File wigFile = p1.toFile();
	File tmpFile = p2.toFile();
	File dicttmp = p3.toFile();
	
	
	
	files(String userId, Integer WigCount) throws IOException{ //adds a string to a file
		
		//assigning variables
		
		//int n = Integer.parseInt(index);
		user=userId;
		
		//creating file if it doesnt exist
		
		File myObj = wigFile;
	      try {
			if (myObj.createNewFile()) {
			    System.out.println("File created: " + myObj.getName());
			  }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		//System.out.println(myObj.getPath());
		// writing and over writing files
		
		
		File tempFile = tmpFile;
		
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(tempFile)));
		
		
		BufferedReader br = null;
		FileReader reader = null;
		try {
		    reader = new FileReader(wigFile);
		    br = new BufferedReader(reader);
		    String line;
		    int count = 0;
		    int ind;
		    boolean replaced = false;
			//System.out.println((";;;;;;;;;;;;;;;;" + index));
		    //System.out.println(index);
		    while ((line = br.readLine()) != null) {
		        if (line.split(" ")[0].equals(userId)) {
		        	//System.out.println("test");
		            

		        	Integer Wigcount = Integer.parseInt(line.split(" ")[1]); //parses and int from the second part of the
		        	//line
		        	Wigcount+= WigCount;
		        	System.out.println(Wigcount);
		        	String Newline =line.split(" ")[0]+" "+(Wigcount);
		        	line.replace(line, Newline+"\n" );
		        	replaced = true;
		        	line = Newline;
		        	//line = line.replace(line,"\n"); Original Replaceline from discspire
		            
		        }
		        // Always write the line, whether you changed it or not.
		        System.out.println(line);
		        writer.println(line);
		        
		        count +=1;
		        //System.out.println("test2");
		        
		    }
		    if(!replaced) {
			    ind = count;
			    System.out.println(count);
			    while(count<= ind) {
			    	System.out.println("Loop!");
			    	if(count==ind) {
			    		System.out.println("write!");
			    		writer.println(userId+" "+"1");
			    	}else {
			    		writer.println("EMPTY");
			    	}
			    	count++;
			    }
			    
		    	
		    	
		    	
		    	
		    	
		    }

		    
		    
		    reader.close();
		    writer.close();
		    File realName = wigFile;
		    realName.delete(); // remove the old file
		    tempFile.renameTo(realName); // Rename temp file
		    

		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		    

		}
	
		
	}
	
	files(){ //gets file
		

		
		FileReader reader = null;
		try {
		    reader = new FileReader(wigFile);
		    BufferedReader br = new BufferedReader(reader);
		    String line;

		    
			//System.out.println((";;;;;;;;;;;;;;;;" + index));
		    //System.out.println(index);
		    while ((line = br.readLine()) != null) {
		    	
		    	String[] split = line.split(" ");
		    	
		    	String Id = split[0];
		    	Integer wigs = Integer.parseInt(split[1]);
		    	
		    	wigDict.put(Id, wigs);
		    	
		        // Always write the line, whether you changed it or not.
		        //System.out.println(line);
		        
		        //System.out.println(p1);
		        
		        //System.out.println("test2");
		        
		    }
		    reader.close();
		    br.close();
		    
		    
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		    

		}
		
	}


	public Integer wigCount(String userID) {
		
		//assigning variables
		
				//int n = Integer.parseInt(index);
				String user=userID;
				
				//creating file if it doesnt exist
				
				File myObj = wigFile;
			      try {
					if (myObj.createNewFile()) {
					    System.out.println("File created: " + myObj.getName());
					  }
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
		
		
		
	
		
		System.out.println(myObj.getPath());
		// writing and over writing files
		
		
		
		
		
		
		
		
		FileReader reader = null;
		try {
		    reader = new FileReader(wigFile);
		    try (BufferedReader br = new BufferedReader(reader)) {
				String line;
				
				//System.out.println((";;;;;;;;;;;;;;;;" + index));
				//System.out.println(index);
				while ((line = br.readLine()) != null) {
				    if (line.split(" ")[0].equals(user)) {

				        

				    	Integer Wigcount = Integer.parseInt(line.split(" ")[1]); //parses and int from the second part of the
				    	//line
				    	System.out.println(Wigcount);
				    	return(Wigcount);

				        
				    }
				    // Always write the line, whether you changed it or not.
				    System.out.println(line);
				    
				    
				    
				    //System.out.println("test2");
				    
				}
				reader.close();
				br.close();
			}
		    
		    
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		    

		}
		
		
		
		
		
		
		
		
		return(null);
	}
	
	public Integer total() throws IOException {
		Integer tot=0;
		
		File myObj = wigFile;
	      try {
			if (myObj.createNewFile()) {
			    System.out.println("File created: " + myObj.getName());
			  }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
				
		
		
		
		
		
		System.out.println(myObj.getPath());
		// writing and over writing files
		
		
		
		
		
		
		
		BufferedReader br = null;
		FileReader reader = null;
		try {
		  reader = new FileReader(wigFile);
		  br = new BufferedReader(reader);
		  String line;
		
		  
			//System.out.println((";;;;;;;;;;;;;;;;" + index));
		  //System.out.println(index);
		  while ((line = br.readLine()) != null) {
		      
		      	//System.out.println("test");
		          

		      	Integer Wigcount = Integer.parseInt(line.split(" ")[1]); //parses and int from the second part of the
		      	//line
		      	tot +=Wigcount;
		      	System.out.println(Wigcount);
		      	System.out.println(tot);
		
		          
		      
		      // Always write the line, whether you changed it or not.
		      System.out.println(line);
		      
		      
		      
		      //System.out.println("test2");
		      
		  }
		} catch (FileNotFoundException e) {
		  e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		  
		
		}
		
		br.close();
		reader.close();
		
		System.out.println("total:"+tot);
		
		return(tot);
		
		
	}
	
	public void Increment(GuildMessageReceivedEvent event) throws IOException {
		avail = false;
		
		tmpFile.delete(); //clears old file to be sade just in case
		

				user=event.getAuthor().getId();
				
				File myObj = wigFile;
			      try {
					if (myObj.createNewFile()) {
					    System.out.println("File created: " + myObj.getName());
					  }
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
				//System.out.println(myObj.getPath());
				// writing and over writing files
				
				
				File tempFile = tmpFile;
				
				PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(tempFile)));
				
				
				BufferedReader br = null;
				FileReader reader = null;
				try {
				    reader = new FileReader(wigFile);
				    br = new BufferedReader(reader);
				    String line;
				    int count = 0;
				    int ind;
				    boolean replaced = false;

				    while ((line = br.readLine()) != null) {
				        if (line.split(" ")[0].equals(user)) {				            
				        	
				        	Integer Wigcount = Integer.parseInt(line.split(" ")[1]); //parses and int from the second part of the
				        	
				        	Wigcount+= 1;
				        	System.out.println(Wigcount);
				        	String Newline =line.split(" ")[0]+" "+(Wigcount);
				        	line.replace(line, Newline+"\n" );
				        	replaced = true;
				        	line = Newline;
				            
				        }
				        // Always write the line, whether you changed it or not.
				        System.out.println(line);
				        writer.println(line);
				        
				        count +=1;
				        
				    }
				    if(!replaced) {
					    ind = count;
					    count=0;
					    System.out.println(count);
					    while(count<= ind) {
					    	System.out.println("Loop!");
					    	if(count==ind) {
					    		System.out.println("write!");
					    		writer.println(user+" "+"1");
					    	}else {
					    		//writer.println("EMPTY");
					    	}
					    	count++;
					    }
					    
				    	
				    	
				    	
				    	
				    	
				    }

				    
				    
				    reader.close();
				    writer.close();
				    File realName = wigFile;
				    //realName.delete();
				    //realName.delete(); // remove the old file
				    Boolean deleted = false;
				    int loopcount = 0;
				    do {
				    	deleted = realName.delete();
				    	System.out.println("delloop");
				    	loopcount++;
				    	if(loopcount >100) {
				    		br.close();
					    	throw new Exception();
					    }
					    
				    }while(!deleted);
				    
				    
				    
				    tempFile.renameTo(realName); // Rename temp file
				    

				} catch (FileNotFoundException e) {
				    e.printStackTrace();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
				    

				}
			
		avail = true;
		
	}
	
	public void DictReplace(GuildMessageReceivedEvent event) throws Exception {

		// writing and over writing files
		
		
		File tempFile = dicttmp;
		//tempFile.delete();
		
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(tempFile)));

		try {

		    
		    
		    String line;
		    
		    for(String lines: wigDict.keySet()) {
		    	
		    	String user = lines;
		    	
		    	String newLine = user+" "+wigDict.get(user);

		    	line = newLine;
		    	
		        // Always write the line, whether you changed it or not.
		        System.out.println(line);
		        writer.println(line);
		    	
		    	
		    	
		    	
		    }
		    
		    /*
		    while ((line = br.readLine()) != null) {
		    	String user = line.split(" ")[0];
		    	
		    	String newLine = user+" "+wigDict.get(user);

		    	line = newLine;
		    	
		        // Always write the line, whether you changed it or not.
		        System.out.println(line);
		        writer.println(line);
		        

		        
		    }*/


		    writer.close();
		    File realName = wigFile.getAbsoluteFile();
		    boolean deleted;
		    int loopcount = 0;

		    do {
		    	deleted = realName.delete();
		    	System.out.println("delloop");
		    	loopcount++;
		    	if(loopcount >100) {

			    	throw new Exception();
			    }
			    
		    }while(!deleted);
		    
		    
		    
		    
		    tempFile.renameTo(realName); // Rename temp file
		    

		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		    

		}
	
		
	}
	
	
	
	
	
}





