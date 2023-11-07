package com.sophswrath.gui;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.Identifier;

public class QuestLineGui extends LightweightGuiDescription {

    public QuestLineGui() {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(252, 140);
        root.setInsets(Insets.ROOT_PANEL);


        root.validate(this);
    }

    @Override
    public void addPainters() {
        BackgroundPainter backgroundPainter = ((context, left, top, root) -> {
            ScreenDrawing.drawGuiPanel(context, left, top, rootPanel.getWidth(), rootPanel.getHeight());
            ScreenDrawing.texturedGuiRect(context, left + 8, top + 16, rootPanel.getWidth() - 16, rootPanel.getHeight() - 24, new Identifier("minecraft:textures/block/dirt.png"), 0xFFFFFFFF);
            ScreenDrawing.drawBeveledPanel(context, left + 7, top + 15, rootPanel.getWidth() - 14, rootPanel.getHeight() - 22);
        });
        rootPanel.setBackgroundPainter(backgroundPainter);
    }

}
