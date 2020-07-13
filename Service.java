package mobileOperator;

import java.util.Date;

public class Service {

	private int id;
	private String typeService;
	private Date startService;
	private Date endService;
	private Date lastPaymentDate;
	private int countMinutes;
	private int countSMS;
	private int countMegabytes;
	private double price;
	private int userId;
	private boolean isActivated;

	Service(String typeService, Date endService, Date lastPaymentDate, int countMinutes, int countSMS,
			int countMegabytes, double price, int userId, boolean isActivated) {
		this.typeService = typeService;
		this.endService = endService;
		this.lastPaymentDate = lastPaymentDate;
		this.countMinutes = countMinutes;
		this.countSMS = countSMS;
		this.countMegabytes = countMegabytes;
		this.price = price;
		this.userId = userId;
		this.isActivated = isActivated;
	}

	public void setCountMinutes(int countMinutes) {
		this.countMinutes = countMinutes;
	}

	public void setCountSMS(int countSMS) {
		this.countSMS = countSMS;
	}

	public void setCountMegabytes(int countMegabytes) {
		this.countMegabytes = countMegabytes;
		;
	}

	public void setStartService(Date startService) {
		this.startService = startService;
	}

	public void setEndService(Date endService) {
		this.endService = endService;
	}

	public void setLastPaymentDate(Date lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}

	public void setIsActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setTypeService(String typeService) {
		this.typeService = typeService;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public int getUserId() {
		return userId;
	}

	public Date getLastPaymentDate() {
		return lastPaymentDate;
	}

	public int getCountMinutes() {
		return countMinutes;
	}

	public int getCountSMS() {
		return countSMS;
	}

	public int getCountMegabytes() {
		return countMegabytes;
	}

	public Date getStartService() {
		return startService;
	}

	public Date getEndService() {
		return endService;
	}

	public boolean getIsActivated() {
		return isActivated;
	}

}
