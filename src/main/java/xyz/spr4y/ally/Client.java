package xyz.spr4y.ally;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import xyz.spr4y.ally.commands.fun.QualidadeCommand;
import xyz.spr4y.ally.commands.fun.SayCommand;
import xyz.spr4y.ally.commands.info.*;

import javax.security.auth.login.LoginException;


public class Client {

    String token = Config.get("TOKEN");

    private Client() throws LoginException {

        JDA jda = JDABuilder.createDefault(token).build();
        CommandClientBuilder builder = new CommandClientBuilder();

        builder.setPrefix("a!");
        builder.setOwnerId("836345581424738354");
        builder.setActivity(Activity.listening("Online"));

        CommandClient client = builder.build();
        //Registrando comandos
        client.addCommand(new PingCommand());
        client.addCommand(new HelpCommand());
        client.addCommand(new BotinfoCommand());
        client.addCommand(new ServerInfoCommand());
        client.addCommand(new QualidadeCommand());
        client.addCommand(new InviteCommand());
        client.addCommand(new SayCommand());

        jda.addEventListener(client);
    }

    public static void main(String[] args) throws LoginException {
        long enable = System.currentTimeMillis();
        new Client();
        System.out.println("O bot foi iniciado em " + (System.currentTimeMillis() - enable) + "ms!");
    }
}