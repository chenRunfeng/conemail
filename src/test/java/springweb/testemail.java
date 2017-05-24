package springweb;


import entity.Email;
import service.*;

public class testemail {
 
	public static void main(String[] args)
 {
	  final String EMAIL_CONTENT="«Î≤Œº”";
	  Email email= new Email();
	  EmailService emailService=new EmailService();
	  email.setFromMail("1657479059@qq.com");
	  email.setMailTitle("≤‚ ‘” º˛");
	  email.setUser("1657479059@qq.com");
	  email.setPassword("nusadejsvrbbdbdf");
	  email.setMailContent(EMAIL_CONTENT);
	  email.setToMail("3257883277@qq.com");	  
	  emailService.setEmail(email);
	  try {
		  System.out.println("11");
		emailService.sendMail();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
