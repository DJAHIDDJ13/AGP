package dao;
import business.island.Island;

public interface IslandPersistence 
{
	void dataInit();
	int persist(Island island);

}
