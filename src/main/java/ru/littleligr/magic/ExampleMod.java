package ru.littleligr.magic;

import io.wispforest.owo.registration.reflect.FieldRegistrationHandler;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.littleligr.magic.effects.MagicEffects;
import ru.littleligr.magic.item.ItemInit;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MODID = "magic";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		FieldRegistrationHandler.register(ItemInit.class, MODID, false);
		MagicEffects.register();
		LOGGER.info("Hello Fabric world!");
	}
}
