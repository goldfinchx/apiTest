package ru.goldfinch.apitest.commands.greetings_command;

import com.dndcraft.atlas.Atlas;
import com.dndcraft.atlas.util.AtlasColor;
import org.bukkit.entity.Player;
import ru.goldfinch.apitest.commands.BaseCommand;

public class CommandGreetingMeSub extends BaseCommand {

    public void invoke(Player player) {
        player.sendMessage(Atlas.get().componentBuilder()
                .append("Hello ")
                .append(player.getName())
                .append("!")
                .color(AtlasColor.PUMPKIN)
                .build()
        );
    }

}
