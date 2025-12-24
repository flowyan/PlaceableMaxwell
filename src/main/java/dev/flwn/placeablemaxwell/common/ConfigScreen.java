package dev.flwn.placeablemaxwell.common;

//? if <=1.20.6 {

/*import com.mojang.blaze3d.platform.Window;
import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.OptionsList;
import net.minecraft.client.gui.screens.OptionsSubScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;

import java.nio.file.Path;
import java.util.List;

public class ConfigScreen extends OptionsSubScreen {
	private static final Component TITLE = Component.translatable("placeablemaxwell.configuration.title");
	private OptionsList list;

	public ConfigScreen(Minecraft minecraft, Screen parent) {
		super(parent, minecraft.options, TITLE);
	}

	@Override
	protected void init() {
		//? if >1.20.1 {
		this.list = this.addRenderableWidget(new OptionsList(this.minecraft, this.width, this.height, this));
		 //?} else {
		/^this.list = this.addRenderableWidget(new OptionsList(this.minecraft, this.width, this.height, 32, this.height - 32, 25));
		^///?}
		for (OptionInstance<?> option : Config.getOptions()) {
			this.list.addBig(option);
		}

		this.addWidget(this.list);
		this.addRenderableWidget(Button.builder(CommonComponents.GUI_DONE, (p_280842_) -> {
			this.minecraft.setScreen(this.lastScreen);
		}).bounds(this.width / 2 - 100, this.height - 27, 200, 20).build());
		super.init();
	}

	@Override
	public void onClose() {
		Config.SPEC.save();
		super.onClose();
	}

	//? if >1.20.1 {
	@Override
	protected void repositionElements() {
		super.repositionElements();
		this.list.updateSize(this.width, this.layout);
	}
	//?}


	//? if <=1.20.1 {
	/^@Override
	public void render(GuiGraphics guiGraphics, int i, int i1, float v) {
		this.basicListRender(guiGraphics, this.list, i, i1, v);
	}
	^///?}
}
*///?}





