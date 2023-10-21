package com.example.hello_mod.Command;

import com.example.hello_mod.Main;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.Util;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Player;

import java.util.Objects;

public class TestCommand implements Command<CommandSourceStack> {
    public static TestCommand instance = new TestCommand();

    @Override
    public int run(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        String passwd = StringArgumentType.getString(context,"password");
         Player player = context.getSource().getPlayerOrException();
         if(Objects.equals(passwd, "12345")) {
             player.sendMessage(new TranslatableComponent("cmd." + Main.MOD_ID + ".hello"), Util.NIL_UUID);
         } else {
             player.sendMessage(new TranslatableComponent("cmd." + Main.MOD_ID + ".passwd_wrong"), Util.NIL_UUID);
         }
        return 0;
    }
}
