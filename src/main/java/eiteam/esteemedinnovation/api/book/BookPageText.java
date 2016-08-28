package eiteam.esteemedinnovation.api.book;

import eiteam.esteemedinnovation.Config;
import eiteam.esteemedinnovation.gui.GuiJournal;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.resources.I18n;

public class BookPageText extends BookPage {
    private String text;

    public BookPageText(String string, String string2) {
        super(string);
        text = string2;
    }

    public BookPageText(String string, String string2, boolean title) {
        super(string, title);
        text = string2;
    }

    @Override
    public void renderPage(int x, int y, FontRenderer fontRenderer, GuiJournal book, RenderItem renderer, boolean isFirstPage, int mx, int my) {
        super.renderPage(x, y, fontRenderer, book, renderer, isFirstPage, mx, my);
        if (!BookPageItem.lastViewing.equals(GuiJournal.viewing)) {
            BookPageItem.abdoName = Minecraft.getMinecraft().thePlayer.worldObj.rand.nextInt(7);
            BookPageItem.lastViewing = GuiJournal.viewing;
        }
        int yOffset = y + 30;
        if (isFirstPage || shouldDisplayTitle) {
            yOffset = y + 40;
        }

        String stringLeft = I18n.format(text);
        while (stringLeft.contains("<br>")) {
            String output = stringLeft.substring(0, stringLeft.indexOf("<br>"));
            if ((Minecraft.getMinecraft().gameSettings.thirdPersonView != 0 ||
              Minecraft.getMinecraft().thePlayer.getDisplayNameString().equals("MasterAbdoTGM50")) && Config.easterEggs) {
                output = BookPageItem.doLizbeth(output);
            }
            fontRenderer.drawSplitString(output, x + 40, yOffset, 110, 0);
            yOffset += 10;
            stringLeft = stringLeft.substring(stringLeft.indexOf("<br>") + 4, stringLeft.length());
        }

        String output = stringLeft;
        if ((Minecraft.getMinecraft().gameSettings.thirdPersonView != 0 ||
          Minecraft.getMinecraft().thePlayer.getDisplayNameString().equals("MasterAbdoTGM50")) && Config.easterEggs) {
            output = BookPageItem.doLizbeth(output);
        }
        fontRenderer.drawSplitString(output, x + 40, yOffset, 110, 0);
    }
}