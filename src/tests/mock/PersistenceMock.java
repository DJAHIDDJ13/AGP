package tests.mock;

import bde.lucene.persistence.LuceneConstants;
import bde.lucene.persistence.LucenePersistence;

public class PersistenceMock {
	
	private LucenePersistence lucene;
	
	public PersistenceMock() {
		lucene = new LucenePersistence(LuceneConstants.INDEX_FILE, LuceneConstants.DATA_FILE);
	}

	public LucenePersistence getLucene() {
		return lucene;
	}

	public void setLucene(LucenePersistence lucene) {
		this.lucene = lucene;
	}
}
