package Main;


import java.io.IOException;
import java.util.HashMap;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
//import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;




public class Commands extends ListenerAdapter {
	
	
	
	
	public files wiggy = new files();

	
	public final static String prefix = "&";
	
	public HashMap<String, Integer> wigDict = wiggy.wigDict;
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		
		
		System.out.println("TEST!");
		
		System.out.println(event.getMessage().getContentRaw());
		
		//event.getMessage().reply("Test").queue();;
		
		String[] args = event.getMessage().getContentRaw().split(" ");
		// hello i am ripley
		//[hello][i][am][ripley]
		//[&command][arguments][etc][etc]
		
		
		for (String word: args) {
			
			
			if(word.toLowerCase().equals("wig")){
				
				
				String user = event.getAuthor().getId();
				
				try {
				Integer wigtemp = wiggy.wigDict.get(user);
				
				wiggy.wigDict.replace(user, wigtemp+1);
				} catch (NullPointerException e) {
					wiggy.wigDict.put(user, 1);
					e.printStackTrace();
				}
				
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
				
				
				
				

			}
			
		}
		
		
		switch (args[0]) { //checks for command to run
		
		
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
			if(args.length == 1) {
				userCount(event);
				break;
				
			}else {
				
				
				
				User bleh;
				
				System.out.println(args[1].substring(3, args[1].length()-1));
				
				bleh = User.fromId(args[1].substring(3, args[1].length()-1));
				
				userCount(event,bleh);
				break;
				
			}
		
		
		case(prefix+"percent"):
			percent(event);
			break;
			
		case(prefix+"sync"):
			sync(event);
			break;
			
		}
		

		
		
	
		
	}
	
	
	
	public void help(MessageReceivedEvent event) { //sends list of public commands
		EmbedBuilder embed = new EmbedBuilder();
		embed.setTitle("Command Help");
		embed.setDescription("A list of what each command does");
		embed.addField(prefix+"count","returns a user's wig count",false);
		embed.addField(prefix+"percent","returns a user's percent wigs in regard to recorded wigs",false);
		
		send(event,embed);
		/*
		embed.setFooter("This was made by ripley, ~Ripley#7880 <@!138365418669604864>");
		event.getChannel().sendMessageEmbeds(embed.build()).queue();;
		//event.getChannel().sendMessage(embed.build()).queue();
		embed.clear();
		*/
	}
	
	public void test(MessageReceivedEvent event) { //its a test
		
		EmbedBuilder embed = new EmbedBuilder();
		embed.setTitle("Test Title");
		embed.setDescription("Whoop, description");
		embed.addField("Embed field 1","this is a conent field",false);
		embed.addField("Embed field 2","this is a conent field",false);
		embed.setFooter("This was made by ripley");
		event.getChannel().sendMessageEmbeds(embed.build()).queue();;
		//event.getChannel().sendMessage(embed.build()).queue();;
		embed.clear();

	
		
	}
	
	public void bread(MessageReceivedEvent event) { //lists all the gay in my computer
		
		EmbedBuilder embed = new EmbedBuilder();
		embed.setTitle("LGBTQ+");
		embed.setDescription("A list of Gay people in my computer");
		//embed.addField("Bread","Trans bread",false);
		embed.addField("Alan turing","Gay computer man, stan him",false);
		embed.addField("Me","Trans bitch",false);
		//embed.addField("Symph","Trans egg",false);
		
		send(event,embed);
		/*
		embed.setFooter("This was made by ripley, ~Ripley#7880 <@!138365418669604864>");
		event.getChannel().sendMessageEmbeds(embed.build()).queue();;
		//event.getChannel().sendMessage(embed.build()).queue();
		embed.clear();
		*/
	}
	
	public void userCount(MessageReceivedEvent event) {

		 
		
		EmbedBuilder embed = new EmbedBuilder();
		
		Integer dictCount;
		
		try {
			dictCount = wigDict.get(event.getAuthor().getId());
			if(dictCount == null) {
				throw new Exception();
			}
			
			
			
		}catch (Exception e) {
			embed.setTitle("Error");
			embed.setDescription("Not a valid user");
			
			
			
			send(event,embed);
			
			/*
			embed.setFooter("This was made by ripley");
			event.getChannel().sendMessageEmbeds(embed.build()).queue();;
			//event.getChannel().sendMessage(embed.build()).queue();;
			embed.clear();
			*/
			
			return;
			
		}
		
		
		
		
		
		
		
		
		
		Integer totalDict = 0;
		Integer Users = wigDict.size();
		for(Integer wigCount: wigDict.values()) {
			 totalDict+= wigCount;
			 
		}
		 
		 
		 
		
		embed.setTitle("Wig");
		embed.setDescription("Wig counts");
		

		embed.addField("User","You have said wig: "+dictCount+", times",false);
		embed.addField("Total","total count "+totalDict
					+"\ntotal users "+Users,false);

		
		send(event,embed);
		/*
		embed.setFooter("This was made by ripley");
		event.getChannel().sendMessageEmbeds(embed.build()).queue();;
		//event.getChannel().sendMessage(embed.build()).queue();;
		embed.clear();
		 */
		 
		
	}
	
	public void userCount(MessageReceivedEvent event, User user) {

		EmbedBuilder embed = new EmbedBuilder();
		
		Integer dictCount;
		
		try {
			
			
			
			dictCount = wigDict.get(user.getId());
			
		}catch (Exception e) {
			embed.setTitle("Error");
			embed.setDescription("Not a valid user");
			
			
			send(event,embed);
			/*
			embed.setFooter("This was made by ripley");
			event.getChannel().sendMessageEmbeds(embed.build()).queue();;
			//event.getChannel().sendMessage(embed.build()).queue();;
			embed.clear();
			*/
			
			return;
			
		}
		
		Integer totalDict = 0;
		Integer Users = wigDict.size();
		for(Integer wigCount: wigDict.values()) {
			 totalDict+= wigCount;
			 
		}
		 
		 
		 
		
		embed.setTitle("Wig");
		embed.setDescription("Wig counts");
		

		embed.addField("User",user.getAsMention()+" has said wig: "+dictCount+", times",false);
		embed.addField("Total","total count "+totalDict
					+"\ntotal users "+Users,false);

		
		
		send(event,embed);
		/*
		embed.setFooter("This was made by ripley");
		event.getChannel().sendMessageEmbeds(embed.build()).queue();;
		//event.getChannel().sendMessage(embed.build()).queue();;
		embed.clear();
		 */
		 
		
	}
	
	
	
	public void percent(MessageReceivedEvent event) {
		
		Integer userWig;
		Integer totalWig;
		Float perc;
		
		 EmbedBuilder embed = new EmbedBuilder();
		
		
		userWig = wiggy.wigCount(event.getAuthor().getId());
		try {
			totalWig= wiggy.total();
		} catch (IOException e) {

			e.printStackTrace();
			totalWig = null;
			
			embed.setTitle("Err");
			embed.setDescription("Unable to get total");
			
			send(event,embed);
			/*
			embed.setFooter("This was made by ripley");
			event.getChannel().sendMessageEmbeds(embed.build()).queue();;
			//event.getChannel().sendMessage(embed.build()).queue();;
			embed.clear();
			*/
			
			
			return;
		}
		perc =  userWig.floatValue()/totalWig.floatValue();
		
		
		

			embed.setTitle("Wig");
			embed.setDescription("Wig counts");
			embed.addField("User","User count "+userWig,false);
			embed.addField("Total","total count "+totalWig,false);
			embed.addField("Percent","percent wig:"+perc,false);
			
			
			send(event,embed);
			/*
			embed.setFooter("This was made by ripley");
			event.getChannel().sendMessageEmbeds(embed.build()).queue();;
			//event.getChannel().sendMessage(embed.build()).queue();;
			embed.clear();
			*/
		
		
		
		
		
	}
	
	public void sync(MessageReceivedEvent event) {
		EmbedBuilder embed = new EmbedBuilder();
		
		try {
			wiggy.DictReplace(event);
		} catch (Exception e) {
			embed.setTitle("Error, Wig");
			embed.setDescription("Update failed :(");

			embed.setFooter("This was made by ripley");
			event.getChannel().sendMessageEmbeds(embed.build()).queue();;
			//event.getChannel().sendMessage(embed.build()).queue();;
			embed.clear();
			return;
			
		}
		embed.setTitle("Wig, Update");
		embed.setDescription("Successful (hopefully)");
		
		embed.setFooter("This was made by ripley");
		event.getChannel().sendMessageEmbeds(embed.build()).queue();;
		//event.getChannel().sendMessage(embed.build()).queue();;
		embed.clear();
	}
	
	public void send(MessageReceivedEvent event, EmbedBuilder embed) {
		
		String Tag = "<@!138365418669604864>";
		
		
		embed.addField("","This was made by ripley:"+ Tag, false);
		event.getChannel().sendMessageEmbeds(embed.build()).queue();;
		//event.getChannel().sendMessage(embed.build()).queue();;
		embed.clear();
		
		
		
	}
	
	
	

}
