package cn.jpush.example;

import cn.jpush.api.CustomMessageParams;
import cn.jpush.api.DeviceEnum;
import cn.jpush.api.ErrorCodeEnum;
import cn.jpush.api.JPushClient;
import cn.jpush.api.MessageResult;
import cn.jpush.api.NotifyMessageParams;
import cn.jpush.api.ReceiverTypeEnum;

public class JpushClientExample {
	
	private static final String username = "username";
	private static final String password = "password";
	private static final String callbackUrl = "";//没有的话，填写空字符串
	private static JPushClient client = null;
	
	public static void main(String[] args) {
		//初始化
		client = new JPushClient(username, password, callbackUrl);
		
		//发送消息或者通知
		testSendNotifyMessageWithAppKey();

		//连接池概念，根据相应需求释放链接资源
		client.shutdown();
	}
	
	public static void testSendNotificationWithImei() {
		String imei = "860949003474563";
		String appKey = "466f7032ac604e02fb7bda89";
		int sendNo = 1;
		String sendDescription = "title";
		String msgTitle = "title";
		String msgContent = "write something...";
		MessageResult msgResult = client.sendNotificationWithImei(imei,
									appKey, sendNo, sendDescription,
									msgTitle, msgContent,
									DeviceEnum.Android,
									DeviceEnum.IOS);
		
		dumpMessageResult(msgResult);
	}
	
	public static void testSendCustomMessageWithImei() {
		String imei = "860949003474563";
		String appKey = "466f7032ac604e02fb7bda89";
		int sendNo = 1;
		String sendDescription = "title";
		String msgTitle = "title";
		String msgContent = "write something...";
		MessageResult msgResult = client.sendCustomMessageWithImei(imei, 
									appKey, sendNo, sendDescription,
									msgTitle, msgContent,
									DeviceEnum.Android);
		
		dumpMessageResult(msgResult);
	}
	
	public static void testSendNotifyMessageWithAppKey() {
		String appKey = "466f7032ac604e02fb7bda89";
		int sendNo = 1;
		String sendDescription = "title";
		String msgTitle = "title";
		String msgContent = "write something...";
		MessageResult msgResult = client.sendNotificationWithAppKey(
									appKey, sendNo, sendDescription,
									msgTitle, msgContent,
									DeviceEnum.Android);
		
		dumpMessageResult(msgResult);
	}
	
	public static void testSendCustomMessageWithAppKey() {
		String appKey = "466f7032ac604e02fb7bda89";
		int sendNo = 1;
		String sendDescription = "title";
		String msgTitle = "title";
		String msgContent = "write something...";
		MessageResult msgResult = client.sendCustomMessageWithAppKey(
									appKey, sendNo, sendDescription,
									msgTitle, msgContent,
									DeviceEnum.Android);
		
		dumpMessageResult(msgResult);
	}
	
	public static void testSendNotifyMessageWithTag() {
		String tag = "fruit";
		String appKey = "fa1fa9091f2e5c786a87ecae";
		int sendNo = 1;
		String sendDescription = "title";
		String msgTitle = "title";
		String msgContent = "write something...";
		MessageResult msgResult = client.sendNotificationWithTag(tag,
									appKey, sendNo, sendDescription,
									msgTitle, msgContent,
									DeviceEnum.Android);
		
		dumpMessageResult(msgResult);
	}
	
	public static void testSendCustomMessageWithTag() {
		String tag = "fruit";
		String appKey = "fa1fa9091f2e5c786a87ecae";
		int sendNo = 1;
		String sendDescription = "title";
		String msgTitle = "title";
		String msgContent = "write something...";
		MessageResult msgResult = client.sendCustomMessageWithTag(tag,
									appKey, sendNo, sendDescription,
									msgTitle, msgContent,
									DeviceEnum.Android);
		
		dumpMessageResult(msgResult);
	}
	
	public static void testSendNotifyMessageWithAlias() {
		String alias = "alias1";
		String appKey = "fa1fa9091f2e5c786a87ecae";
		int sendNo = 1;
		String sendDescription = "title";
		String msgTitle = "title";
		String msgContent = "write something...";
		MessageResult msgResult = client.sendNotificationWithAlias(alias,
									appKey, sendNo, sendDescription,
									msgTitle, msgContent,
									DeviceEnum.Android);
		
		dumpMessageResult(msgResult);
	}
	
	public static void testSendCustomMessageWithAlias() {
		String alias = "alias1";
		String appKey = "fa1fa9091f2e5c786a87ecae";
		int sendNo = 1;
		String sendDescription = "title";
		String msgTitle = "title";
		String msgContent = "write something...";
		MessageResult msgResult = client.sendCustomMessageWithAlias(alias,
									appKey, sendNo, sendDescription,
									msgTitle, msgContent,
									DeviceEnum.Android);
		
		dumpMessageResult(msgResult);
	}
	
	public static void testSendNotifyMessage() {
		NotifyMessageParams params = new NotifyMessageParams();
		params.setAppKeys("466f7032ac604e02fb7bda89");
		params.setSendNo(1);
		params.setSendDescription("description");
		params.addReceiverType(ReceiverTypeEnum.IMEI);
		params.addReceiverValue("860949003474563");
		params.addPlatform(DeviceEnum.Android);
		params.addPlatform(DeviceEnum.IOS);
		params.getMsgContent().setTitle("notification title");
		params.getMsgContent().setMessage("notification message");
		params.getMsgContent().setBuilderId("0");
		
		MessageResult msgResult = client.sendNotification(params);
		
		dumpMessageResult(msgResult);
	}
	
	public static void testSendCustomMessage() {
		CustomMessageParams params = new CustomMessageParams();
		//请不要省略以下参数
		params.setAppKeys("466f7032ac604e02fb7bda89");
		params.setSendNo(1);
		params.setSendDescription("description");
		params.addReceiverType(ReceiverTypeEnum.IMEI);
		params.addReceiverValue("860949003474563");
		params.addPlatform(DeviceEnum.Android);
		params.addPlatform(DeviceEnum.IOS);
		params.getMsgContent().setTitle("notification title");
		params.getMsgContent().setMessage("notification message");
		params.getMsgContent().setContentType("0");
		//extra是推送给客户端的json数据，开发者根据自己的需求定义
		params.getMsgContent().setExtra(new java.util.HashMap<String, Object>());
		
		MessageResult msgResult = client.sendCustomMessage(params);

		dumpMessageResult(msgResult);
	}
	
	private static void dumpMessageResult(MessageResult msgResult) {
		if (null != msgResult) {
			if (msgResult.getErrcode() == ErrorCodeEnum.NOERROR.value()) {
				System.out.println("发送成功， sendNo=" + msgResult.getSendno());
			} else {
				System.out.println("发送失败， 错误代码=" + msgResult.getErrcode() + ", 错误消息=" + msgResult.getErrmsg());
			}
		} else {
			System.out.println("无法获取服务器返回的数据");
		}
	}
}