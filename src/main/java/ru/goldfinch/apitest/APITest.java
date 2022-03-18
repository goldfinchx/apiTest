package ru.goldfinch.apitest;

import com.dndcraft.atlas.AtlasPaper;
import com.dndcraft.atlas.command.Commands;
import com.dndcraft.atlas.command.exception.InvalidPluginCommandException;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import ru.goldfinch.apitest.commands.food_command.CommandFood;
import ru.goldfinch.apitest.commands.greetings_command.CommandGreetings;

public final class APITest extends JavaPlugin {

    @Getter
    private static APITest instance;

    @Override
    public void onEnable() {
        instance = this;
        System.out.println(AtlasPaper.get());

        registerCommands();
    }

    public void registerCommands(){
        try {
            Commands.build(getCommand("hello"), CommandGreetings::new);
            Commands.build(getCommand("FOOD"), CommandFood::new);
        } catch (InvalidPluginCommandException invalidPluginCommand) {
            invalidPluginCommand.printStackTrace();
        }
    }


    @Override
    public void onDisable() {

    }
}
