package Main;


import java.io.IOException;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;




public class Commands extends ListenerAdapter {
	
	
	public files wiggy = new files();

	
	public final String prefix = "&";
	
	
	
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		//event.getMessage().reply("Test").queue();;
		
		String[] args = event.getMessage().getContentRaw().split(" ");
		// hello i am ripley
		//[hello][i][am][ripley]
		//[&command][arguments][etc][etc]
		
		
		switch (args[0]) { //checks for command to run
		
		case("wig"):
			
			String user = event.getAuthor().getId();
			
			Integer wigtemp = wiggy.wigDict.get(user);
			
			wiggy.wigDict.replace(user, wigtemp+1);
			
			try {
				
				if (wiggy.avail) {
					wiggy.Increment(event);
				}else {
					while(!wiggy.avail) {
					 Thread.sleep(10);
					}
					
					wiggy.Increment(event);
					
					
					
				}
				
				
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Dict:"+wiggy.wigDict.get(user));
			
			break;
		
		case(prefix+"wig"):
			
			break;
		
		case (prefix+"help"):
			
			help(event);
			break;

		case (prefix+"test"):
			
			//test(event);
			
			break;

		case(prefix+"bread"):
			bread(event);
			break;
			
		case(prefix+"count"):
			userCount(event);
			break;
		
		case(prefix+"percent"):
			percent(event);
			break;
			

		}
		

		
		
	
		
	}
	
	
	
	public void help(GuildMessageReceivedEvent event) { //sends list of public commands
		EmbedBuilder embed = new EmbedBuilder();
		embed.setTitle("Command Help");
		embed.setDescription("A list of what each command does");
		embed.addField(prefix+"count","returns a user's wig count",false);
		embed.addField(prefix+"percent","returns a user's percent wigs in regard to recorded wigs",false);
		embed.setFooter("This was made by ripley, ~Ripley#7880 <@!138365418669604864>");
		event.getChannel().sendMessage(embed.build()).queue();
		embed.clear();
		
	}
	
	public void test(GuildMessageReceivedEvent event) { //its a test
		
		EmbedBuilder embed = new EmbedBuilder();
		embed.setTitle("Test Title");
		embed.setDescription("Whoop, description");
		embed.addField("Embed field 1","this is a conent field",false);
		embed.addField("Embed field 2","this is a conent field",false);
		embed.setFooter("This was made by ripley");
		event.getChannel().sendMessage(embed.build()).queue();;
		embed.clear();
		try {
			files test = new files(event.getAuthor().getId(),1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void bread(GuildMessageReceivedEvent event) { //lists all the gay in my computer
		
		EmbedBuilder embed = new EmbedBuilder();
		embed.setTitle("LGBTQ+");
		embed.setDescription("A list of Gay people in my computer");
		embed.addField("Bread","Trans bread",false);
		embed.addField("Alan turing","Gay computer man, stan him",false);
		embed.addField("Me","Trans bitch",false);
		embed.addField("Symph","Trans egg",false);
		embed.setFooter("This was made by ripley, ~Ripley#7880 <@!138365418669604864>");
		event.getChannel().sendMessage(embed.build()).queue();
		embed.clear();
		
	}
	
	public void userCount(GuildMessageReceivedEvent event) {
		files test = new files();
		
		 Integer userCount =test.wigCount(event.getAuthor().getId());
		 Integer totalCount=test.total();
		 
		 
		 EmbedBuilder embed = new EmbedBuilder();
			embed.setTitle("Wig");
			embed.setDescription("Wig counts");
			embed.addField("User","User count "+userCount,false);
			embed.addField("Total","total count "+totalCount,false);
			
			embed.setFooter("This was made by ripley");
			event.getChannel().sendMessage(embed.build()).queue();;
			embed.clear();
		 
		 
		
	}
	
	public void percent(GuildMessageReceivedEvent event) {
		
		Integer userWig;
		Integer totalWig;
		Float perc;
		
		userWig = wiggy.wigCount(event.getAuthor().getId());
		totalWig= wiggy.total();
		perc =  userWig.floatValue()/totalWig.floatValue();
		
		
		
		 EmbedBuilder embed = new EmbedBuilder();
			embed.setTitle("Wig");
			embed.setDescription("Wig counts");
			embed.addField("User","User count "+userWig,false);
			embed.addField("Total","total count "+totalWig,false);
			embed.addField("Percent","percent wig:"+perc,false);
			
			embed.setFooter("This was made by ripley");
			event.getChannel().sendMessage(embed.build()).queue();;
			embed.clear();
		
		
		
		
		
		
	}
	
	
	

}
