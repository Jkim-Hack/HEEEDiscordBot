package com.hee.heediscordbot;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

public class botEvents {

    @EventSubscriber
    public void onMessageRecieved(MessageReceivedEvent event){
        if(event.getMessage().getContent().startsWith(App.PREFIX + "test"))
            App.sendMessage(event.getChannel(), "Wisone is GEIIIII");
    }

}
