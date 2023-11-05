package com.sophswrath.gui;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
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
            ScreenDrawing.texturedGuiRect(context, 1, 1, rootPanel.getWidth() - rootPanel.getWidth() / 8, rootPanel.getHeight() - rootPanel.getHeight() / 8, new Identifier("minecraft:textures/block/dirt.png"), 0xFFFFFFFF);
        });
        rootPanel.setBackgroundPainter(backgroundPainter);
    }

}
