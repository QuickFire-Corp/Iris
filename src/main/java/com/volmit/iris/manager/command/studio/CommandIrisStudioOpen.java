/*
 * Iris is a World Generator for Minecraft Bukkit Servers
 * Copyright (c) 2021 Arcane Arts (Volmit Software)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.volmit.iris.manager.command.studio;

import com.volmit.iris.Iris;
import com.volmit.iris.IrisSettings;
import com.volmit.iris.util.KList;
import com.volmit.iris.util.MortarCommand;
import com.volmit.iris.util.MortarSender;

public class CommandIrisStudioOpen extends MortarCommand {
    public CommandIrisStudioOpen() {
        super("open", "o");
        requiresPermission(Iris.perm.studio);
        setDescription("Create a new temporary world to design a dimension.");
        setCategory("Studio");
    }

    @Override
    public void addTabOptions(MortarSender sender, String[] args, KList<String> list) {

    }

    @Override
    public boolean handle(MortarSender sender, String[] args) {
        if (!IrisSettings.get().isStudio()) {
            sender.sendMessage("To use Iris Studio, please enable studio in Iris/settings.json");
            return true;
        }

        if (args.length < 1) {
            sender.sendMessage("/iris std open <DIMENSION> (file name without .json)");
            return true;
        }

        Iris.proj.open(sender, args[0]);
        return true;
    }

    @Override
    protected String getArgsUsage() {
        return "[dimension]";
    }
}
