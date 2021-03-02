package fr.lmf.containertutorial.init;

import fr.lmf.containertutorial.Main;
import fr.lmf.containertutorial.block.TestContainerBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);

    public static final RegistryObject<Block> TEST_CONTAINER = register("test_container_block", new TestContainerBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool().hardnessAndResistance(1.5F, 6.0F)), ItemGroup.DECORATIONS);

    public static RegistryObject<Block> register(String id, Block block, ItemGroup itemGroupIn){

        RegistryObject<Block> BLOCK = BLOCKS.register(id, ()-> block);
        RegistryObject<Item> ITEM = ITEMS.register(id, ()-> new BlockItem(block, (new Item.Properties()).group(itemGroupIn)));

        return BLOCK;

    }

}
