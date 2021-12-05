package me.mwon.discordminecraftlinker;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DiscordMinecraftLinker implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("DiscordMinecraftLinker");

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
	}
}
