package Main;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class BotStartup {
	static String prefix = new Commands().prefix;
	
	
	
	
	static String token = new token().token;
	public static void main(String[] args) throws LoginException {
		
		System.out.print(new Commands().wiggy.p1.toString());
		System.out.println("TEST");
		
		JDABuilder jda = JDABuilder.createDefault(token);
		jda.setActivity(Activity.listening(prefix+"help"));
		jda.setStatus(OnlineStatus.ONLINE);
		jda.addEventListeners(new Commands());
		jda.build();
	}

	
	
	
}
