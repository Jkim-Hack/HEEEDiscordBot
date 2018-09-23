package com.hee.heediscordbot;

import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.handle.obj.IVoiceChannel;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;
import sx.blah.discord.util.RequestBuffer;
import sx.blah.discord.util.audio.AudioPlayer;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;


public class botMethods {


    public AudioPlayer audioPlayer(IGuild guild){
        return AudioPlayer.getAudioPlayerForGuild(guild);
    }
   public void joinVC(IChannel channel, IUser user) throws RateLimitException, DiscordException,
           MissingPermissionsException {

        if(user.getVoiceStates().size() < 1){
            channel.sendMessage("You're not in a VC");
        } else {
            IVoiceChannel voiceChannel = user.getVoiceStateForGuild(channel.getGuild()).getChannel();
            voiceChannel.join();
        }

    }

    public void queueLink(IChannel channel, final String id){
        String name = System.getProperty("os.name").contains("Windows") ? "C:\\youtube2mp3\\youtube-dl.exe" : "youtube-dl";
        ProcessBuilder builder = new ProcessBuilder(name, "-q", "-f", "worstaudio",
                "--exec", "C:\\youtube2mp3\\ffmpeg -hide_banner -nostats -loglevel panic -y -i {} -vn -q:a 5 -f mp3 pipe:1", "-o",
                "%(id)s", "--", id);

        try {
            Process process = builder.start();
            try {
                //CompletableFuture.runAsync(() -> logStream(process.getErrorStream()));
                audioPlayer(channel.getGuild()).queue(AudioSystem.getAudioInputStream(process.getInputStream()));

            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
                process.destroyForcibly();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void queueLink(IChannel channel, final String id, long fastfowardamt){
        String name = System.getProperty("os.name").contains("Windows") ? "C:\\youtube2mp3\\youtube-dl.exe" : "youtube-dl";
        ProcessBuilder builder = new ProcessBuilder(name, "-q", "-f", "worstaudio",
                "--exec", "C:\\youtube2mp3\\ffmpeg -hide_banner -nostats -loglevel panic -y -i {} -vn -q:a 5 -f mp3 pipe:1", "-o",
                "%(id)s", "--", id);

        try {
            Process process = builder.start();
            try {
                //CompletableFuture.runAsync(() -> logStream(process.getErrorStream()));
                audioPlayer(channel.getGuild()).queue(AudioSystem.getAudioInputStream(process.getInputStream()));
                audioPlayer(channel.getGuild()).getCurrentTrack().fastForwardTo(fastfowardamt);

            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
                process.destroyForcibly();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

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
    public static void sendMessageWithMention(final IChannel channel, String msg){
        RequestBuffer.request(() -> {
            try{
                channel.sendMessage(msg);
            } catch (DiscordException e) {
                System.err.println("Message could not be sent with error: ");
                e.printStackTrace();
            }


        });
    }

    public static void sendMessageWithImage(final IChannel channel, String filePath){
        RequestBuffer.request(() -> {
            try{
                channel.sendFile(new File("C:\\Users\\Kim\\Desktop\\Wilson_Stoned.png"));
            } catch (DiscordException e) {
                System.err.println("Message could not be sent with error: ");
                e.printStackTrace();
            } catch (FileNotFoundException e1){
                System.err.println("No pic found");
            }


        });
    }


}
