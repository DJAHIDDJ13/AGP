package bde.lucene.persistence;

public class LuceneConstants {
	
	public static final String CONTENTS = "contents";
	
	public static final String FILE_NAME = "filename";
	
	public static final String FILE_PATH = "filepath";
	
	private static final String PROJECT_LOCAL_PATH = "C:\\Users\\ayadi\\eclipse-workspace\\AGP";
	
	//maximum number of responses returned
	public static final int MAX_SEARCH = 10;
	
	public static String DESCRIPTION_FILE =PROJECT_LOCAL_PATH+"\\src\\bde\\persistence\\jdbc\\description.csv";
	
	//Configure Lucene
	public static String INDEX_FILE =PROJECT_LOCAL_PATH+"\\src\\luceneSRC\\index\\";
	public static String DATA_FILE =PROJECT_LOCAL_PATH+"\\src\\luceneSRC\\data\\";
	
	public static String TABLEDB_NAME ="site";
	public static String KEY_NAME ="id_site";
}
