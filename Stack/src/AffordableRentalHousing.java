public class AffordableRentalHousing {
	// declaration  
	private String CommunityAreaName;
	private int CommunityAreaNumber;
	private String propertyType;
	private String address;
	private int zipCode;
	private String location;
	public AffordableRentalHousing(){ // First constructor in order to initialize my variables; 
		CommunityAreaName = "";
		CommunityAreaNumber = 0;
		propertyType = "";
		address  = "";
		zipCode = 0;
		location = "";
		
	}
	public AffordableRentalHousing(String info []){ //Second constructor in order to put them in an array of the data
		CommunityAreaName = info[0];
		CommunityAreaNumber = Integer.parseInt(info[1]); // convert to Integer
		propertyType =  info[2];
		address  =  info[4];
		zipCode = Integer.parseInt(info[5]); // convert to integer as well 
		location = info[13];
	}
	// setters and getters methods
	public int getCommunityAreaNumber() {
		return CommunityAreaNumber;
	}
	public void setCommunityAreaNumber(int communityAreaNumber) {
		CommunityAreaNumber = communityAreaNumber;
	}
	public String getCommunityAreaName() {
		return CommunityAreaName;
	}
	public void setCommunityAreaName(String communityAreaName) {
		CommunityAreaName = communityAreaName;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	// to storing methods
	public String toString() {
		return "AffordableRentalHousing [CommunityAreaName=" + CommunityAreaName + ", CommunityAreaNumber="
				+ CommunityAreaNumber + ", propertyType=" + propertyType + ", address=" + address + ", zipCode="
				+ zipCode + ", location=" + location + "]";
	}	
}
