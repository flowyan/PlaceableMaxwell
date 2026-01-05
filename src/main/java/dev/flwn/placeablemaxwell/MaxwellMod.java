package dev.flwn.placeablemaxwell;

import dev.flwn.placeablemaxwell.platform.Platform;

import dev.flwn.placeablemaxwell.platform.neoforge.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//? fabric {
/*import com.example.modtemplate.platform.fabric.FabricPlatform;
*///?} neoforge {
import dev.flwn.placeablemaxwell.platform.neoforge.NeoforgePlatform;
 //?} forge {
/*import dev.flwn.placeablemaxwell.platform.forge.ForgePlatform;
*///?}

@SuppressWarnings("LoggingSimilarMessage")
public class MaxwellMod {

	public static final String MOD_ID = /*$ mod_id*/ "placeablemaxwell";
	public static final String MOD_VERSION = /*$ mod_version*/ "2.1.2";
	public static final String MOD_FRIENDLY_NAME = /*$ mod_name*/ "Maxwell the placeable cat";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final Platform PLATFORM = createPlatformInstance();

	public static void onInitialize() {
		LOGGER.info("Initializing {} on {}. Meow!", MOD_ID, MaxwellMod.xplat().loader());
		LOGGER.debug("{}: { version: {}; friendly_name: {} }", MOD_ID, MOD_VERSION, MOD_FRIENDLY_NAME);
	}

	public static void onInitializeClient() {
		LOGGER.info("Initializing {} Client on {}. Meow!", MOD_ID, MaxwellMod.xplat().loader());
		LOGGER.debug("{}: { version: {}; friendly_name: {} }", MOD_ID, MOD_VERSION, MOD_FRIENDLY_NAME);
	}

	static Platform xplat() {
		return PLATFORM;
	}

	private static Platform createPlatformInstance() {
		//? fabric {
		/*return new FabricPlatform();
		*///?} neoforge {
		return new NeoforgePlatform();
		 //?} forge {
		/*return new ForgePlatform();
		*///?}
	}
}
