package com.sophswrath.gui;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.minecraft.client.util.math.MatrixStack;
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
        getRootPanel().setBackgroundPainter(BackgroundPainter.createNinePatch(new Identifier("minecraft:textures/block/dirt.png")));
    }

}
