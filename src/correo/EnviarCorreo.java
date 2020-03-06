package correo;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class EnviarCorreo {
	public EnviarCorreo() {
		
	}
	
	public void enviarCorreo() {
		Properties propiedad = new Properties();
		propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
		propiedad.setProperty("mail.smtp.starttls.enable", "true");
		propiedad.setProperty("mail.smtp.port", "587");
		propiedad.setProperty("mail.smtp.auth", "true");

		Session sesion = Session.getDefaultInstance(propiedad);
		String correoEnvia = "mile.120501@gmail.com";
		String contrasena = "macanuda1205";
		String receptor = "cristianthrashx@gmail.com";
		String asunto = "Correo Desde Java";
		String mensaje = "Hola Cristian si funciona el codigo "; 

		MimeMessage mail = new MimeMessage(sesion);
		try {
			mail.setFrom(new InternetAddress(correoEnvia));
			mail.addRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
			mail.setSubject(asunto);
			mail.setText(mensaje);

			Transport transportar = sesion.getTransport("smtp");
			transportar.connect(correoEnvia, contrasena);
			transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
			transportar.close();

			JOptionPane.showMessageDialog(null, "Listo, revise su correo");

		} catch (AddressException ex) {
		} catch (MessagingException ex) {
		}
	}
	public static void main(String[] args) {
		EnviarCorreo a = new EnviarCorreo();
		a.enviarCorreo();
	}

}
