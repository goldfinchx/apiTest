package ru.goldfinch.apitest.commands.food_command;

import com.dndcraft.atlas.Atlas;
import com.dndcraft.atlas.util.AtlasColor;
import com.dndcraft.atlas.util.ItemUtil;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import ru.goldfinch.apitest.commands.BaseCommand;

public class CommandFoodCheckSub extends BaseCommand {

    public void invoke(Player player) {
        ItemStack itemInHand = player.getInventory().getItemInMainHand();

        if (ItemUtil.exists(itemInHand))
            return;


        if (!ItemUtil.hasTag(itemInHand, "randomNumber"))
            return;

        player.sendMessage(Atlas.get().componentBuilder()
                .append("This item random number is ")
                .append(ItemUtil.getIntTag(itemInHand, "randomNumber"), AtlasColor.GOLD)
                .build());
    }
}
