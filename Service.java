package mobileOperator;

import java.sql.Date;

public class Service {

	private int id;
	private String serviceName;
	private Date serviceStart;
	private Date serviceEnd;
	private int countMinutes;
	private int countSMS;
	private int countMegabytes;
	private double price;
	private int userId;
	private boolean isActivated;
	private Date lastPaymentDate;

	Service(String serviceName, java.sql.Date serviceEnd, java.sql.Date lastPaymentDate, int countMinutes, int countSMS,
			int countMegabytes, double price, int userId, boolean isActivated) {
		this.serviceName = serviceName;
		this.serviceEnd = serviceEnd;
		this.lastPaymentDate = lastPaymentDate;
		this.countMinutes = countMinutes;
		this.countSMS = countSMS;
		this.countMegabytes = countMegabytes;
		this.price = price;
		this.userId = userId;
		this.isActivated = isActivated;
	}

	public Service(String typeService2, Date lastPaymentDate2, Date endService2, int smsCount, int minutesCount,
			int megabytesCount, boolean isActive) {

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

	public void setServiceStart(Date serviceStart) {
		this.serviceStart = serviceStart;
	}

	public void setServiceEnd(java.sql.Date serviceEnd) {
		this.serviceEnd = serviceEnd;
	}

	public void setLastPaymentDate(java.sql.Date lastPaymentDate) {
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

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getServiceName() {
		return serviceName;
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

	public Date getServiceStart() {
		return serviceStart;
	}

	public Date getServiceEnd() {
		return serviceEnd;
	}

	public boolean getIsActivated() {
		return isActivated;
	}

}
