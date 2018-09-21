package com.hee.heediscordbot;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

public class botEvents {

    @EventSubscriber
    public void onMessageRecieved(MessageReceivedEvent event){
        if(event.getMessage().getContent().startsWith(App.PREFIX + "test"))
            App.sendMessage(event.getChannel(), "Wistond is Stonnned");
        if(event.getMessage().getContent().startsWith(App.PREFIX + "straights"))
            App.sendMessage(event.getChannel(),  event.getGuild().getUsersByName("Huge-Dick Horny Hitler").
                    get(0).getNicknameForGuild(event.getGuild())+" & " + event.getGuild().getUsersByName("Jizz Joey").
                    get(0).getNicknameForGuild(event.getGuild()) +" is and always will be straight");
    }

}
