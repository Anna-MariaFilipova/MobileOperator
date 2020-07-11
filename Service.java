package mobileOperator;

public class Service {     	
private int id;	

private String typeService ;
private double	price;
private int userId;
private String end ; 

private boolean isActivated;

Service(String typeService,double price, String end,int userId,boolean isActivated){
	this.typeService=typeService;
	this.price=price;
	this.end=end;
	this.userId=userId;
	this.isActivated=isActivated;
}

public void setIsActivated(boolean isActivated) {
	this.isActivated=isActivated;
}

public void setId(int id) {
	this.id=id;
}
public void setUserId(int userId) {
	this.userId=userId;
}
public void setTypeService(String typeService) {
 this.typeService=typeService;
}

public void setPrice(double price) {
	this.price=price;
}

public void setEnd(String end) {
	this.end=end;
}



public int getId() {
	return id;
}

public String getTypeService() {
	return typeService;
}

public double getPrice() {
	return price;
}

public int getUserId()
{
	return userId;
}

public String getEnd() {
	return end;
}



public boolean getIsActivated() {
	return isActivated;
}
}
