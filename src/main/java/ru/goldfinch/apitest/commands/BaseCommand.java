package ru.goldfinch.apitest.commands;

import com.dndcraft.atlas.command.CommandTemplate;
import ru.goldfinch.apitest.APITest;

public class BaseCommand extends CommandTemplate {

    protected final APITest instance = APITest.getInstance();
}
