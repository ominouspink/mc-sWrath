package com.sophswrath.gui.questline;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class QuestScreen extends Screen {

    public QuestScreen() {
        super(Text.translatable("quests.title"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, this.width / 2 - 124, this.height / 2 - 68);
        drawQuestWindow(context, this.width / 2 - 126, this.height / 2 - 70);
    }

    public void drawQuestWindow(DrawContext context, int x, int y) {
        RenderSystem.enableBlend();
        context.drawTexture(new Identifier("minecraft:textures/gui/advancements/window.png"), x, y, 0, 0, 252, 140);
        context.drawText(this.textRenderer, super.title, x + 8, y + 6, 4210752, false);
    }

    public void renderBackground(DrawContext context, int x, int y) {
        Identifier backgroundTexture = new Identifier("minecraft:textures/block/dirt.png");
        context.drawGuiTexture(backgroundTexture, x,  y, 248, 136);
    }
}
