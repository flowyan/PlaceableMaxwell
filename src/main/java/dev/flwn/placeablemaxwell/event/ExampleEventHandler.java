package dev.flwn.placeablemaxwell.event;

import dev.flwn.placeablemaxwell.MaxwellMod;
import net.minecraft.server.level.ServerPlayer;

public class ExampleEventHandler {

	public static void onPlayerHurt(ServerPlayer player) {
		MaxwellMod.LOGGER.info("{} took damage. PVP is sixsevenn.", player.getDisplayName());
	}
}
