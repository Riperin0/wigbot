package Main;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class BotStartup {
	static String prefixs = Commands.prefix;
	
	static String tokenz = token.tokens;
	public static void main(String[] args) throws LoginException {
		
		System.out.println(new files().p1) ;
		
		
		
		JDABuilder jda = JDABuilder.createDefault(tokenz);
		jda.setActivity(Activity.listening(prefixs+"help"));
		jda.setStatus(OnlineStatus.ONLINE);
		jda.addEventListeners(new Commands());
		jda.build();
	}
}
