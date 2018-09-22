package com.hee.heediscordbot;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IUser;

public class botEvents {

    @EventSubscriber
    public void onMessageRecieved(MessageReceivedEvent event){
        IGuild guild = event.getGuild();
        if(event.getMessage().getContent().startsWith(App.PREFIX + "test"))
            App.sendMessage(event.getChannel(), "Wisone is GEIIIII");
        if(event.getMessage().getContent().startsWith(App.PREFIX + "straights"))
            App.sendMessageWithMention(event.getChannel(), guild.getUsersByName("Huge-Dick Horny Hitler").get(0).mention()+ " & " +
                    guild.getUsersByName("Jizz Joey").get(0).mention()+" will always be straight");
        if(event.getMessage().getContent().startsWith(App.PREFIX + "gays"))
            App.sendMessage(event.getChannel(), "I can't find any ¯_(ツ)/¯");
        if(event.getMessage().getContent().startsWith(App.PREFIX + "createE"))
            App.sendMessage(event.getChannel(), "EEEE\nE\nEE\nE\nEEEE");

    }

}
