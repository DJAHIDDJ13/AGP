package bde.lucene.core;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import bde.lucene.persistence.LuceneConstants;

public class LuceneBuilder {
	
	private String filePathLuceneData;
	private String fileDescription; 
	
	public LuceneBuilder(String luceneDataPath,String descriptionPath) {
		this.filePathLuceneData = luceneDataPath;
		this.fileDescription = descriptionPath;	
		try {
			this.createFiles();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Prends le fichier description.csv, et retourne son contenu en un seul String
	private String readFileDescription() throws IOException {
		String line = null;
		InputStream is =  new FileInputStream(fileDescription);
		@SuppressWarnings("resource")
		BufferedReader buf = new BufferedReader(new InputStreamReader(is));
		line = buf.readLine();
		StringBuilder sb = new StringBuilder();
		
		while(line != null)
		{
		   sb.append(line).append("\n");
		   line = buf.readLine();
		}
		return sb.toString();
	}

	// Prends le contenu du fichier description.csv, et le split, et ecris chaque ligne dans le fichier correspondant
	private void WriteFiles(String FileStringContent) throws IOException {
		int i=0;
		String[] FilesContent = FileStringContent.split("\n");
		for (String string : FilesContent) 
		{ 
			i++;
			// Check ligne non null
			if (!string.equals(i + "$") || string.length() > 5) {	
				EcritureFichierId(string.split("\\$")[1],i);
			}
		}
	}

	// Prends un content et son id, ecrit le fichier du nom id avec le contenu content
	private void EcritureFichierId(String content, int id) throws IOException {
	    String PathWriteFiles = filePathLuceneData+id+".txt";
	    BufferedWriter writer = new BufferedWriter(new FileWriter(PathWriteFiles));
	    writer.write(content);
	    writer.close();
	}
	 
	public void createFiles() throws IOException {
		String FileStringContent = readFileDescription();
		WriteFiles(FileStringContent);
	}

	public String getFilePathLuceneData() {
		return filePathLuceneData;
	}

	public void setFilePathLuceneData(String filePathLuceneData) {
		this.filePathLuceneData = filePathLuceneData;
	}

	public String getFileDescription() {
		return fileDescription;
	}

	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}

}
