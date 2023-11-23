/*
 * gc-opencommand
 * Copyright (C) 2022  jie65535
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.github.jie65535.opencommand.socket.packet.player;

import com.github.jie65535.opencommand.socket.SocketServer;
import com.github.jie65535.opencommand.socket.packet.BasePacket;
import com.github.jie65535.opencommand.socket.packet.PacketEnum;
import emu.grasscutter.utils.JsonUtils;

// 玩家操作类
public class Player extends BasePacket {
    public PlayerEnum type;
    public int uid;
    public String data;

    @Override
    public String getPacket() {
        return JsonUtils.encode(this);
    }

    @Override
    public PacketEnum getType() {
        return PacketEnum.Player;
    }

    public static void dropMessage(int uid, String str) {
        Player p = new Player();
        p.type = PlayerEnum.DropMessage;
        p.uid = uid;
        p.data = str;
        SocketServer.sendUidPacket(uid, p);
    }
}
