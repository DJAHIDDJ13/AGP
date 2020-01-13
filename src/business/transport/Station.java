package business.transport;

/**
 * Should use prototype pattern
 */
public abstract class Station {

	private int id;
	private float latitude;
	private float longitude;
	
	public Station() {
		
	}
	
	public Station(int id, float lat, float lng) {
		this.id = id;
		this.setLatitude(lat);
		this.setLongitude(lng);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public abstract boolean isBusStation();
	public abstract boolean isBoatStation();

	public float distanceFrom(Station v) {
		return 1; // TODO: Heversine formula
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
}