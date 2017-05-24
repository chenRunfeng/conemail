package service;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import entity.Email;
import entity.Email_Authenticator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Autowired
	private Email email;
	private Message message;
	
	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}    
    /**
     * �����ʼ������˵�ַ <���˷���>
     * @param list
     * @throws MessagingException 
     * @throws AddressException 
     */
    public String setRecipients(List<String> recs) throws AddressException, MessagingException{
        if(recs.isEmpty()){
            return "�����˵�ַΪ��!";
        }
        for(String str:recs){
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(str));
        }
        return "��������˵�ַ�ɹ�!";
    }
    /**
     * �����ʼ������˵�ַ <���˷���>
     * @param StringBuffer<parms,parms2,parms.....>
     * @throws MessagingException 
     * @throws AddressException 
     */
    @SuppressWarnings("static-access")
    public String setRecipients(StringBuffer sb) throws AddressException, MessagingException{
        if(sb==null||"".equals(sb)){
            return "�ַ�������Ϊ��!";
        }
        Address []address = new InternetAddress().parse(sb.toString());
        mimeMessage.addRecipients(Message.RecipientType.TO, address);
        return "�ռ��˼���ɹ�";
    }
	public  void sendMail() throws Exception {  
	Properties props = new Properties(); //���Լ���һ�������ļ�  
	// ʹ��smtp�����ʼ�����Э��  
	props.put("mail.smtp.host", "smtp.qq.com");//�洢�����ʼ�����������Ϣ  
	props.put("mail.smtp.auth", "true");//ͬʱͨ����֤  
	props.put("mail.smtp.port", "465");
	props.put("mail.transport.protocol", "smtp");
	props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	props.put("mail.smtp.socketFactory.port", "465");
//	props.put("mail.smtp.ssl.enable", "true");
	//props.put("mail.smtp.ssl.socketFactory", msf);
	Authenticator authenticator = new Email_Authenticator("1657479059@qq.com", "nusadejsvrbbdbdf");
	Session session = Session.getInstance(props,authenticator);//���������½�һ���ʼ��Ự  
	//session.setDebug(true); //�������ӡһЩ������Ϣ��  
	
	MimeMessage message = new MimeMessage(session);//���ʼ��Ự�½�һ����Ϣ����  
	message.setFrom(new InternetAddress(email.getFromMail()));//���÷����˵ĵ�ַ  
	message.setRecipient(Message.RecipientType.TO, new InternetAddress(email.getToMail()));//�����ռ���,���������������ΪTO  
	message.setSubject(email.getMailTitle());//���ñ���  
	//�����ż�����  
	//message.setText(mailContent); //���� ���ı� �ʼ� todo  
	message.setContent(email.getMailContent(), "text/html;charset=gbk"); //����HTML�ʼ���������ʽ�ȽϷḻ  
	message.setSentDate(new Date());//���÷���ʱ��  
	message.saveChanges();//�洢�ʼ���Ϣ  
	
	//�����ʼ�  
//	//Transport transport = session.getTransport("smtp");  
//	Transport transport = session.getTransport();  
//	transport.connect(email.getUser(), email.getPassword());  
//	transport.sendMessage(message, message.getAllRecipients());//�����ʼ�,���еڶ�����������������õ��ռ��˵�ַ  
//	transport.close();  
	Transport.send(message);
}  
}
