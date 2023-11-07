package com.sophswrath.gui.questline;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.advancement.AdvancementTab;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import java.util.Objects;

@Environment(EnvType.CLIENT)
public class QuestScreen extends Screen {

    private double originX;
    private double originY;
    private boolean initialized;

    public QuestScreen() {
        super(Text.translatable("quests.title"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.drawBackground(context, this.width / 2 - 117, this.height / 2 - 52);
        drawQuestWindow(context, this.width / 2 - 126, this.height / 2 - 70);
    }

    public void drawQuestWindow(DrawContext context, int x, int y) {
        RenderSystem.enableBlend();
        context.drawTexture(new Identifier("minecraft:textures/gui/advancements/window.png"), x, y, 0, 0, 252, 140);
        context.drawText(this.textRenderer, super.title, x + 8, y + 6, 4210752, false);
    }

    public void drawBackground(DrawContext context, int x, int y) {
        if (!this.initialized) {
            this.originX = (double)(117 - 34 / 2);
            this.originY = (double)(56 - 12 / 2);
            this.initialized = true;
        }

        context.enableScissor(x, y, x + 234, y + 113);
        context.getMatrices().push();
        context.getMatrices().translate((float)x, (float)y, 0.0F);
        Identifier identifier = new Identifier("minecraft:textures/block/dirt.png");
        int i = MathHelper.floor(this.originX);
        int j = MathHelper.floor(this.originY);
        int k = i % 16;
        int l = j % 16;

        for(int m = -1; m <= 15; ++m) {
            for(int n = -1; n <= 8; ++n) {
                context.drawTexture(identifier, k + 16 * m, l + 16 * n, 0.0F, 0.0F, 16, 16, 16, 16);
            }
        }

        context.getMatrices().pop();
        context.disableScissor();
    }

    private void move() {

    }

}
