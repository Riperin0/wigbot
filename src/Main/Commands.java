package Main;


import java.io.IOException;
import java.nio.channels.Channel;
import java.util.HashMap;
import java.util.Random;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
//import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;




public class Commands extends ListenerAdapter {
	
	User Ripley = User.fromId("944747583539130381");
	
	User Nina = User.fromId("338443523974234112");
	
	User Seth = User.fromId("640244695951212545");
	
	//https://discord.com/channels/489256996709728256/489262238331305985/943363774813982781
	
	
	Random randy = new Random();
	
	public files wiggy = new files();

	
	public final static String prefix = "&";
	
	public HashMap<String, Integer> wigDict = wiggy.wigDict;
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		
		if(event.getAuthor().equals(Seth) && randy.nextInt(2)==0) {
			event.getChannel().sendMessage("https://discord.com/channels/489256996709728256/489262238331305985/943363774813982781").queue();
			event.getChannel().sendMessage("Enjoy Men").queue();
			
		}
		
		String user = event.getAuthor().getId();
		
		int softWig = 0;
		int totalWig = 0;
		
		int softMax = 6;
		
		//System.out.println("TEST!"); TODO this is where I have it say test
		
		System.out.println(event.getMessage().getContentRaw());
		
		//event.getMessage().reply("Test").queue();;
		
		String[] args = event.getMessage().getContentRaw().split(" ");
		// hello i am ripley
		//[hello][i][am][ripley]
		//[&command][arguments][etc][etc]
		
		
		for (String word: args) {
			
			
			if(word.toLowerCase().equals("wig")){
				totalWig++;
				
				if(totalWig >= softMax) {
					totalWig = 1;
					softWig -= 1;
					continue;
					
				}
				try {
				if(wigDict.get(event.getAuthor().getId()) + softWig== wigDict.get(Nina.getId())) {
					totalWig -=1;
					break;
				}
				} catch (NullPointerException e) {
					
					String ID = event.getAuthor().getId();
					
					wigDict.put(ID, totalWig);
					
					System.out.print(e);
					
					
					
				}
				
				
				System.out.println("Dict:"+wiggy.wigDict.get(user));
				
				
				
				

			}
			
		}
		//// HERE
		
		if(totalWig !=0 || softWig != 0) {
			
			try {
				Integer wigtemp = wiggy.wigDict.get(user);
				
				wiggy.wigDict.replace(user, wigtemp+totalWig+softWig);
				
				
				wiggy.DictReplace(event);
				} catch (NullPointerException e) {
					wiggy.wigDict.put(user, 1);
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
		}
		
		
		
		
		
		////
		switch (args[0]) { //checks for command to run
		
		
		case(prefix+"wig"):
			
			break;
		
		case (prefix+"help"):
			
			help(event);
			break;
			
		case (prefix+"set"):
			if(event.getAuthor().equals(Ripley)) {
				set(event, event.getMessage().getContentRaw());
			}
			
			//set(event, event.getMessage().getContentRaw());
			
			
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
			if(args.length == 1) {
				percent(event);
				break;
				
			}else {
				
				
				
				User bleh;
				
				System.out.println(args[1].substring(3, args[1].length()-1));
				
				bleh = fromMention(args[1]);
				
				percent(event,bleh);
				break;
				
			}

			
		case(prefix+"sync"):
			sync(event);
			break;
			
		case(prefix+"leaderboard"):
			leaderboard(event);
			break;		
			
		case(prefix+"message"):
			if(!event.getAuthor().equals(Ripley)) {
				break;
				
			}
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i< args.length;i++) {
			if(i!=0) {
				sb.append(args[i]+" ");
			}
			
		}
			System.out.println(sb.toString());
			message(event,sb.toString());
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

	}
	
	public void test(MessageReceivedEvent event) { //its a test
		
		EmbedBuilder embed = new EmbedBuilder();
		embed.setTitle("Test Title");
		embed.setDescription("Whoop, description");
		embed.addField("Embed field 1","this is a conent field",false);
		embed.addField("Embed field 2","this is a conent field",false);
		embed.setFooter("This was made by ripley");
		event.getChannel().sendMessageEmbeds(embed.build()).queue();;
		embed.clear();

	
		
	}
	
	public void bread(MessageReceivedEvent event) { //lists all the gay in my computer
		
		EmbedBuilder embed = new EmbedBuilder();
		embed.setTitle("LGBTQ+");
		embed.setDescription("A list of Gay people in my computer");
		//embed.addField("Bread","Trans bread",false);
		embed.addField("Alan turing","Gay computer man, stan him",false);
		embed.addField("Pazarus","Gay computer man, stan him",false);
		embed.addField("Me","Trans bitch",false);
		//embed.addField("Symph","Trans egg",false);
		
		send(event,embed);

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

		 
		
	}
	
	
	
	public void percent(MessageReceivedEvent event) { //TODO refactor embed
		
		Integer totalWig;
		Float perc;
		
		Integer dictWig;
		
		String userId = event.getAuthor().getId();
		
		dictWig = wigDict.get(userId);
		
		
		
		totalWig = totalWig();
		
		 EmbedBuilder embed = new EmbedBuilder();
		
		
		perc =  dictWig.floatValue()/totalWig.floatValue();
		
		
		

		embed.setTitle("Wig");
		embed.setDescription("Wig counts");
		embed.addField("User", "you have said wig: "+dictWig+", times",false);
		embed.addField("Total","total count "+totalWig,false);
		embed.addField("Percent","percent wig:"+perc,false);
		
		
		send(event,embed);
		
		
		
		
		
	}
	
	public void percent(MessageReceivedEvent event, User user) { //Refactor for use w/ user commands
		
		Integer totalWig;
		Float perc;
		
		Integer dictWig;
		
		String userId = user.getId();
		
		dictWig = wigDict.get(userId);
		
		
		
		totalWig = totalWig();
		
		EmbedBuilder embed = new EmbedBuilder();
		
		
		perc =  dictWig.floatValue()/totalWig.floatValue();
		
		
		

		embed.setTitle("Wig");
		embed.setDescription("Wig counts");
		embed.addField("User",user.getAsMention()+" has said wig: "+dictWig+", times",false);
		embed.addField("Total","total count "+totalWig,false);
		embed.addField("Percent","percent wig:"+perc,false);
		
		
		send(event,embed);
		
		
		
		
		
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
		
		
		String Tag = Ripley.getAsMention();
		//String Tag = "<@!944747583539130381>";
		
		
		
		
		embed.addField("","This was made by ripley:"+ Tag, false);
		event.getChannel().sendMessageEmbeds(embed.build()).queue();;
		//event.getChannel().sendMessage(embed.build()).queue();;
		embed.clear();
		
		
		
	}
	
	public Integer totalWig(){
		
		Integer totalDict = 0;
		for(Integer wigCount: wigDict.values()) {
			 totalDict+= wigCount;
			 
		}
		
		return totalDict;
		
		
	}
	
	public Integer userWig(User user) { //TODO create
		
		return(wigDict.get(user.getId()));
		
	}
	
	public void leaderboard(MessageReceivedEvent event) {
		
		EmbedBuilder embed = new EmbedBuilder();
		
		
		String first = "";
		Integer wigsone = 0;
		
		String second = "";
		Integer wigstwo = 0;
		
		String third = "";
		Integer wigsthree = 0;
		
		String fourth = "";
		Integer wigsfour = 0;
		
		String fifth ="";
		Integer wigsfive = 0;
		
		
		
		for(String user: wigDict.keySet() ) {
			
			int current = wigDict.get(user);
			
			
			if(current > wigsone) { //this is a terrible way to do it, lel
				
				wigsfive = wigsfour.intValue();
				fifth = fourth.toString();
				
				wigsfour= wigsthree.intValue();
				fourth = third.toString();
				
				wigsthree= wigstwo.intValue();
				third = second.toString();
				
				wigstwo= wigsone.intValue();
				second = first.toString();
				
				first = user;
				wigsone = wigDict.get(user);
				
			} else if(current > wigstwo) {
				
				wigsfive = wigsfour.intValue();
				fifth = fourth.toString();
				
				wigsfour= wigsthree.intValue();
				fourth = third.toString();
				
				wigsthree= wigstwo.intValue();
				third = second.toString();
				
				
				wigstwo = wigDict.get(user);
				second= user;
				
				
				
			} else if(current > wigsthree) {
				
				wigsfive = wigsfour.intValue();
				fifth = fourth.toString();
				
				wigsfour= wigsthree.intValue();
				fourth = third.toString();
				
				wigsthree= wigDict.get(user);
				third = user;
				
				
				
				
			} else if(current > wigsfour) {
				
				wigsfive = wigsfour.intValue();
				fifth = fourth.toString();
				
				wigsfour= wigDict.get(user);
				fourth = user;
				
				
				
				
			} else if(current > wigsfive) {
				
				wigsfive = wigDict.get(user);
				fifth = user;
				
				
				
			} 
			
		}
		
		
		
		embed.setTitle("Wig");
		embed.setDescription("Wig leaderboard");
		embed.addField("First", User.fromId(first).getAsMention()+":in first place with:"+wigsone+" wigs", false);
		embed.addField("Second", User.fromId(second).getAsMention()+":in second place with:"+wigstwo+" wigs", false);
		embed.addField("Third", User.fromId(third).getAsMention()+":in third place with:"+wigsthree+" wigs", false);
		embed.addField("Fourth", User.fromId(fourth).getAsMention()+":in fourth place with:"+wigsfour+" wigs", false);
		embed.addField("Fifth", User.fromId(fifth).getAsMention()+":in fifth place with:"+wigsfive+" wigs", false);
		

		
		send(event,embed);
		
		
		
		
		
		
	}
	public void set(MessageReceivedEvent event, String message) {
		
		EmbedBuilder embed = new EmbedBuilder();
		
		String[] args = message.split(" ");
		//System.out.println(args[1].substring(3, args[1].length()-1));
		//User user = User.fromId(args[1].substring(3, args[1].length()-1));
		User user;
		Integer replace;
		
		
		
		try {
		user = fromMention(args[1]);
		} catch (Exception e) {
			e.printStackTrace();
			embed.setTitle("Wig error");
			embed.setDescription("Please define a user using a mention, followed by the set ammount");
			send(event,embed);
			return;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		try {
		replace = Integer.parseInt(args[2]);
		} catch (Exception e) {
			
			e.printStackTrace();
			embed.setTitle("Wig error");
			embed.setDescription("Please define an ammount to set to");
			send(event,embed);
			return;
			
		}
		System.out.println(wigDict.get(user.getId()));
		
		
		wigDict.replace(user.getId(), replace);
		
		System.out.println(wigDict.get(user.getId()));
		
		
		try {
			wiggy.DictReplace(event);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			embed.setTitle("Wig error");
			embed.setDescription("Error Lel");
			send(event,embed);
		}
		
		
		embed.setTitle("Wig set!");
		embed.setDescription(user.getAsMention()+" has been set to: "+wigDict.get(user.getId())+ " wigs");
		
		send(event,embed);
		
	}
	
	public void message(MessageReceivedEvent event, String message) {
		
		//TextChannel txtChannel = event.getJDA().getTextChannelById("489266495877152768"); //Live channel
		
		TextChannel txtChannel = event.getJDA().getTextChannelById("934701000747515954"); //Test channel
		
		
		
		EmbedBuilder embed = new EmbedBuilder();
		
		
		
		String Tag = "<@!930680276101783592>";
		
		embed.addField("WigBot",message, false);
		
		embed.addField("","This was made by Me:"+ Tag, false);
		txtChannel.sendMessageEmbeds(embed.build()).queue();
		//event.getChannel().sendMessage(embed.build()).queue();;
		embed.clear();
		
		
		
		
	}
	
	public User fromMention(String mention) {
		String temp = mention.substring(3, mention.length()-1);
		return User.fromId(temp);
	}
	

}
