package com.hee.heediscordbot;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.util.audio.AudioPlayer;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;

public class botEvents {

    @EventSubscriber
    public void onMessageRecieved(MessageReceivedEvent event){
        IGuild guild = event.getGuild();
        if(event.getMessage().getContent().startsWith(App.PREFIX + "test"))
            botMethods.sendMessage(event.getChannel(), "Wisone is GEIIIII");
        if(event.getMessage().getContent().startsWith(App.PREFIX + "straights"))
            botMethods.sendMessageWithMention(event.getChannel(), guild.getUserByID(188828815768813568L).mention()
                    +" will always be straight");
        if(event.getMessage().getContent().startsWith(App.PREFIX + "gays")) {
            String str = "I can't find any ¯\\\\_(ツ)_/¯ except for Mike";
            botMethods.sendMessage(event.getChannel(), str);
        }
        if(event.getMessage().getContent().startsWith(App.PREFIX + "createE"))
            botMethods.sendMessage(event.getChannel(), "EEEE\nE\nEE\nE\nEEEE");
        if(event.getMessage().getContent().startsWith(App.PREFIX + "stond"))
            botMethods.sendMessageWithImage(event.getChannel(), "");
        if(event.getMessage().getContent().startsWith(App.PREFIX + "rice")){
            botMethods botMethods = new botMethods();
            botMethods.audioPlayer(guild);
            botMethods.joinVC(event.getChannel(), event.getAuthor());
            // System.out.print(new URL("https://www.youtube.com/watch?v=i8a3gjt_Ar0"));
            botMethods.queueLink(event.getChannel(), "https://www.youtube.com/watch?v=i8a3gjt_Ar0");

        }
        if(event.getMessage().getContent().startsWith(App.PREFIX + "scream")){
            botMethods botMethods = new botMethods();
            botMethods.audioPlayer(guild);
            botMethods.joinVC(event.getChannel(), event.getAuthor());
            // System.out.print(new URL("https://www.youtube.com/watch?v=i8a3gjt_Ar0"));
            botMethods.queueLink(event.getChannel(), "https://www.youtube.com/watch?v=8hmOaKlDY1Q", 4);

        }



    }




}
