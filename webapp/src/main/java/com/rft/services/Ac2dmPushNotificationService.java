package com.rft.services;

import java.io.IOException;
import java.util.List;

import javax.management.Notification;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;

public interface Ac2dmPushNotificationService {
	
	public void pushNotification(Notification notification);
	
	public void pushNotifications(List<Notification> notifications);
	
	void doSendNotification(Notification notification, String token, HttpClient client) throws HttpException, IOException;
	
	public void setSendingRoleAccount(String sendingRoleAccount);
	
	public void setSendingRolePassword(String sendingRolePassword);
	
}
