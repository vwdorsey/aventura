package loader;

import java.io.IOException;
import java.net.URISyntaxException;

import com.valkryst.VTerminal.Panel;
import com.valkryst.VTerminal.builder.PanelBuilder;
import com.valkryst.VTerminal.component.Screen;
import com.valkryst.VTerminal.font.Font;
import com.valkryst.VTerminal.font.FontLoader;

public class testLoader {
    public static void main(final String[] args) throws IOException, URISyntaxException, InterruptedException {
        final Font font = FontLoader.loadFontFromJar("Fonts/DejaVu Sans Mono/16pt/bitmap.png",
                                                     "Fonts/DejaVu Sans Mono/16pt/data.fnt",
                                                     1);

        final PanelBuilder builder = new PanelBuilder();
        builder.setWidthInCharacters(120);
        builder.setHeightInCharacters(32);
        builder.setFont(font);
        final Panel panel = builder.build();

        Thread.sleep(50);
        Screen window = panel.getScreen();
        window.clear(' ');
        window.write("A", 10, 10);
        panel.draw();
    }
}
