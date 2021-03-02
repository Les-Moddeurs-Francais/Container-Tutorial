package fr.lmf.containertutorial;

import fr.lmf.containertutorial.init.BlockInit;
import fr.lmf.containertutorial.init.ContainerInit;
import fr.lmf.containertutorial.screen.TestContainerScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(Main.MODID)
public class Main {

    public static final String MODID = "container-tutorial";

    public Main() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        ContainerInit.CONTAINERS.register(bus);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ScreenManager.registerFactory(ContainerInit.TEST_CONTAINER.get(), TestContainerScreen::new);
    }
}
