package ru.goldfinch.apitest.commands.food_command;

import com.dndcraft.atlas.Atlas;
import com.dndcraft.atlas.command.annotations.Cmd;
import com.dndcraft.atlas.util.AtlasColor;
import com.dndcraft.atlas.util.ItemUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import ru.goldfinch.apitest.commands.BaseCommand;

import java.util.concurrent.ThreadLocalRandom;

public class CommandFood extends BaseCommand {

    private final CommandFoodCheckSub checkSub = new CommandFoodCheckSub();

    @Override
    protected void invoke() {
        Player player = Bukkit.getPlayer(getSender().getName());

        int generatedNumber = ThreadLocalRandom.current().nextInt(-5000, 5000);

        player.sendMessage(Atlas.get().componentBuilder()
                .append("I give you bread with random number in its NBT!")
                .build());
        player.sendMessage(Atlas.get().componentBuilder()
                .append("Generated number is - ")
                .append(generatedNumber, AtlasColor.GOLD)
                .build());
        player.sendMessage(Atlas.get().componentBuilder()
                .append("You can check it with ")
                .append("/food check", AtlasColor.GOLD)
                .build());

        ItemStack foodStack = ItemUtil.make(Material.BREAD, Atlas.get().componentBuilder()
                .append("Atlas Bread", AtlasColor.RED)
                .build()
        );

        ItemUtil.setTag(foodStack, "randomNumber", generatedNumber);

        player.getInventory().addItem(foodStack);
    }

    @Cmd(value = "Check if the food has NBT tag")
    public BaseCommand check() {return checkSub;}

}
