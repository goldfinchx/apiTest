package ru.goldfinch.apitest.commands.greetings_command;

import com.dndcraft.atlas.Atlas;
import com.dndcraft.atlas.menu.MenuBuilder;
import com.dndcraft.atlas.menu.icon.SimpleButton;
import com.dndcraft.atlas.util.AtlasColor;
import com.dndcraft.atlas.util.ItemUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public record MenuGreetings(Player player) {

    public void open() {
        MenuBuilder menuBuilder = new MenuBuilder("Greetings Menu", 3);
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            menuBuilder.icon(new SimpleButton(
                    ItemUtil.make(
                            Material.PLAYER_HEAD,
                            Atlas.get().componentBuilder()
                                    .append(onlinePlayer.getName())
                                    .color(AtlasColor.GOLD)
                                    .build()
                    ),
                    (menuAction) -> {
                        onlinePlayer.sendMessage(Atlas.get().componentBuilder()
                                .append("Player ", AtlasColor.GOLD)
                                .append(menuAction.getPlayer().getName(), AtlasColor.DANDELION)
                                .append(" send you his/her greetings!", AtlasColor.GOLD)
                                .build());

                        menuAction.getPlayer().sendMessage(Atlas.get().componentBuilder()
                                .append("You send your greetings to the ", AtlasColor.GRAY)
                                .append(onlinePlayer.getName(), AtlasColor.WHITE)
                                .build()
                        );
                    }
            ));
        }

        menuBuilder.pad(22, ItemUtil.make(
                Material.BARRIER,
                Atlas.get().componentBuilder()
                        .append("Info", AtlasColor.GOLD)
                        .build(),
                new ArrayList<>() {{
                    add(Atlas.get().componentBuilder()
                            .append("Choose the player,", AtlasColor.GRAY)
                            .build());
                    add(Atlas.get().componentBuilder()
                            .append("you want to send", AtlasColor.GRAY)
                            .build());
                    add(Atlas.get().componentBuilder()
                            .append("your greetings!", AtlasColor.GRAY)
                            .build());
                }}
                )

        );

        menuBuilder.build().openSession(player);
    }

}
