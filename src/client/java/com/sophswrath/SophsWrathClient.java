package com.sophswrath;

import com.sophswrath.gui.QuestLineGui;
import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class SophsWrathClient implements ClientModInitializer {

	private static KeyBinding toggleQuests;

	@Override
	public void onInitializeClient() {
		toggleQuests = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.sophswrath.togglequestline",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_K,
				"category.sophswrath"
		));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (toggleQuests.wasPressed()) {
				client.setScreen(new CottonClientScreen(new QuestLineGui()));
			}
		});
	}
}