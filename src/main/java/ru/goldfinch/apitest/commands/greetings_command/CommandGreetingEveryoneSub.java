package ru.goldfinch.apitest.commands.greetings_command;

import com.dndcraft.atlas.Atlas;
import com.dndcraft.atlas.util.AtlasColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import ru.goldfinch.apitest.commands.BaseCommand;

public class CommandGreetingEveryoneSub extends BaseCommand {

    public void invoke() {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.sendMessage(Atlas.get().componentBuilder()
                    .append("Hello Everyone!")
                    .color(AtlasColor.GOLD)
                    .build()
            );
        }
    }

}
