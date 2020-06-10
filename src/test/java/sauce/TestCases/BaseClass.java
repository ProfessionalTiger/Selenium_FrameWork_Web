package sauce.TestCases;

import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import sauce.Utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getbaseURL();
	public String username = readconfig.getusername();
	public String pwd = readconfig.getpasswrod();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String broswer) throws InterruptedException {

		logger = Logger.getLogger("SauceDemo");
		
		
		
		
		PropertyConfigurator.configure("log4j.properties");

		if (broswer.equals("chorme")) {

			System.setProperty("webdriver.chrome.driver", readconfig.getchorompath());
			driver = new ChromeDriver();

		} else if (broswer.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxpath());
			driver = new FirefoxDriver();

		} else if (broswer.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getiepath());
			driver = new EdgeDriver();
			

		}
		
		driver.get(baseURL);		
		logger.info("URL Loaded");
	}

	@AfterClass
	public void tearDown() {
		sentMail();
		logger.info("Mail Sent");
		driver.quit();

	}
	
	public static void captureScreenShort(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot tst= ((TakesScreenshot) driver);
		
		
		File source=tst.getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		File destination=new File(System.getProperty("user.dir")+"\\ScreenShots\\"+tname+timestamp+".png");
		//FileHandler.copy(source,destination);
		FileUtils.copyFile(source, destination, true);
		System.out.println("Screenshot taken and file is created");
		
	}
	
	

	public static void sentMail()
	{
		  Properties props = new Properties();
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.socketFactory.port", "465");
		    props.put("mail.smtp.socketFactory.class",
		        "javax.net.ssl.SSLSocketFactory");
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.port", "465");

		    Session session = Session.getDefaultInstance(props,
		        new javax.mail.Authenticator() {
		          protected PasswordAuthentication getPasswordAuthentication() {
		            return new PasswordAuthentication(
		            "aamirsaleem.sqa@gmail.com",
		            "vTouch-12");// change accordingly
		          }
		        });

		    // compose message
		    try {
		      MimeMessage message = new MimeMessage(session);
		      message.setFrom(new InternetAddress("aamirsaleem.sqa@gmail.com"));// change accordingly
		      message.setFrom(new InternetAddress("aamirsaleem.sqa@gmail.com"));
		      message.addRecipient(Message.RecipientType.TO,
		          new InternetAddress("aamirsaleem.sqa@gmail.com"));
		      /*
		       * for (String cc : ccs)
		       * message.addRecipient(Message.RecipientType.CC,new
		       * InternetAddress(cc));
		       */
		      
		      
		      message.setSubject("Test Report");
		      // Option 1: To send normal text message
		      // message.setText(text);
		      // Option 2: Send the actual HTML message, as big as you like
		      // message.setContent("<h1>This is actual message</h1></br></hr>" +
		      // text, "text/html");

		      // Set the attachment path
		     		    
		      
		      String filename = "E:\\Selenium_Test\\saucedemo.V1\\test-reports\\Test Report.html";

		      BodyPart objMessageBodyPart = new MimeBodyPart();
		      // Option 3: Send text along with attachment
		      objMessageBodyPart.setContent(
		          "<h1>Mail from Selenium Project!</h1></br>" + "Test Report", "text/html");
		      Multipart multipart = new MimeMultipart();
		      multipart.addBodyPart(objMessageBodyPart);

		      objMessageBodyPart = new MimeBodyPart();
		      DataSource source = new FileDataSource(filename);
		      objMessageBodyPart.setDataHandler(new DataHandler(source));
		      objMessageBodyPart.setFileName(filename);
		      multipart.addBodyPart(objMessageBodyPart);
		      message.setContent(multipart);

		      // send message
		      Transport.send(message);

		      System.out.println("Mail sent successfully");

		    } catch (MessagingException e) {
		      throw new RuntimeException(e);
		    }

		
	}
	
}
