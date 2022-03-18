package ru.goldfinch.apitest.commands.greetings_command;

import org.bukkit.entity.Player;
import ru.goldfinch.apitest.commands.BaseCommand;

public class CommandGreetingMenuSub extends BaseCommand {

    public void invoke(Player player) {
        new MenuGreetings(player).open();
    }

}
