package com.hee.heediscordbot;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.Permissions;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.RequestBuffer;

/**
 * Hello world!
 *
 */
public class App 
{

    public static final String PREFIX = "/";

    public static void main( String[] args )
    {
        IDiscordClient client = new ClientBuilder()
                    .withToken("NDkxODAyNzEwODMyNzA5NjYy.DoNK8g.3wXXGGRdeE0Jl1s5K4fhjawGRuY").build();



        client.getDispatcher().registerListener(new botEvents());
        client.login();
    }

    public static void sendMessage(final IChannel channel, String msg){
        RequestBuffer.request(() -> {
            try{
                channel.sendMessage(msg);
            } catch (DiscordException e) {
                System.err.println("Message could not be sent with error: ");
                e.printStackTrace();
            }


        });
    }

}
