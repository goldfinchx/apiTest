package ru.goldfinch.apitest.commands.greetings_command;

import com.dndcraft.atlas.Atlas;
import com.dndcraft.atlas.command.annotations.Cmd;
import com.dndcraft.atlas.util.AtlasColor;
import ru.goldfinch.apitest.commands.BaseCommand;

public class CommandGreetings extends BaseCommand {

    private final CommandGreetingMeSub greetingMeSubnode = new CommandGreetingMeSub();
    private final CommandGreetingEveryoneSub greetingEveryoneSubnode = new CommandGreetingEveryoneSub();
    private final CommandGreetingMenuSub greetingMenuSubnode = new CommandGreetingMenuSub();

    @Override
    protected void invoke() {
        getSender().sendMessage(Atlas.get().componentBuilder()
                .append("Hello World!")
                .color(AtlasColor.BABY_BLUE)
                .build()
        );
    }

    @Cmd(value = "Greet yourself")
    public BaseCommand me() {return greetingMeSubnode;}

    @Cmd(value = "Greet to every player on the server")
    public BaseCommand everyone() {return greetingEveryoneSubnode;}

    @Cmd(value = "Opens greetings menu")
    public BaseCommand menu() {return greetingMenuSubnode;}
}

